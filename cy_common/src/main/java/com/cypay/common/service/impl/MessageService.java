package com.cypay.common.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.cypay.common.config.WxMpConfig;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Message;
import com.cypay.common.entity.MessageRecord;
import com.cypay.common.repository.impl.MessageRecordRepository;
import com.cypay.common.repository.impl.MessageRepository;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.Result;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

@Service
public class MessageService extends BaseServiceImpl<MessageRepository, Message, Message> {
	
	@Autowired
	private PartitionRepository partitionRepository;
	
	@Autowired
	private MessageRecordRepository messageRecordRepository;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private WxMpConfig wxMpConfig;
	
	@Value("${com.payment.sse-timeout}")
	private Long sseTimeout;
	
	private Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>(64);
	private Map<String, MessageRecord> msgCache = new ConcurrentHashMap<>(64);
	
	@Override
	public Result save(Message t) {
		PartitionVo vo = partitionRepository.findMerchantById(t.getPartitionId());
		if (vo == null) {
			return Result.error("留言失败，当前分区不存在！", "partitionId");
		}
		t.setMerchant(new Merchant(vo.getMerchantId()));
		t.setPartitionName(vo.getName());
		Message message = baseRepository.save(t);
		applicationContext.publishEvent(t);
		if (wxMpConfig.isSubMpUsable()) {
			WxMpQrCodeTicket ticket;
			try {
				ticket = wxMpConfig.getSubWxMpQrcodeService().qrCodeCreateTmpTicket(message.getId().toString(), 3600);
				return Result.success("留言成功！", ticket.getUrl());
			} catch (WxErrorException e) {
				e.printStackTrace();
			}
		}
		return Result.success("留言成功！");
	}
	
	/**
	 * 删除留言
	 * @param id
	 * @param merchant
	 * @return
	 */
	@Transactional
	public Result deleteByIdAndMerchant(Long id, Merchant merchant) {
		messageRecordRepository.deleteByMessageId(id);
		baseRepository.deleteByIdAndMerchant(id, merchant);
		return Result.success("删除成功");
	}
	
	/**
	 * 批量删除留言
	 * @param ids
	 * @param merchant
	 * @return
	 */
	@Transactional
	public Result batchDelete(Long[] ids, Merchant merchant) {
		List<Long> list = Arrays.asList(ids);
		messageRecordRepository.deleteByMessageIds(list);
		baseRepository.deleteByIdsAndMerchant(list, merchant);
		return Result.success("删除成功");
	}

	/**
	 * 更新留言状态为已读
	 * @param id
	 * @param merchant
	 * @return
	 */
	public Result updateMessageState(Long id, Merchant merchant) {
		baseRepository.updateMessageState(id, merchant);
		return Result.success("更新成功");
	}
	
	public Result updateMessageState(Long id) {
		baseRepository.updateMessageState(id);
		return Result.success("更新成功");
	}

	public Optional<Message> findByIdAndMerchant(Long id, Merchant merchant) {
		return baseRepository.findByIdAndMerchant(id, merchant);
	}
	
	public Optional<Message> findMessageRecodeById(Long msgId) {
		return baseRepository.findMessageRecodeById(msgId);
	}

	/**
	 * 留言回复
	 * @param record
	 * @param msgId
	 * @return
	 */
	public Result saveMessageRecord(MessageRecord record, String msgId) {
		try {
			messageRecordRepository.save(record);
			String receiveId = (record.getType() == 1 ? "0" : "1") + msgId;
			SseEmitter sseEmitter = sseEmitterMap.get(receiveId);
			if (sseEmitter != null) {
					sseEmitter.send(record);
			} else {
				msgCache.put(receiveId, record);
				System.out.println("对方不在线，系统将通过微信通知对方！");
				// 发布留言回复推送事件
				applicationContext.publishEvent(record);
			}
		} catch (IOException e) {
			System.out.println("回复异常。。。");
			logger.error(e.getMessage());
		}
		return Result.success();
	}

	/**
	 * 创建SSE连接
	 * @param msgId
	 * @return
	 */
	public SseEmitter connect(String msgId) {
		SseEmitter sseEmitter = sseEmitterMap.get(msgId);
		try {
			if (sseEmitter != null) {
				sseEmitter.send(SseEmitter.event().name("close").data("completed"));
				sseEmitter.complete();
				System.out.println("complete..................");
				sseEmitterMap.remove(msgId);
			}
			sseEmitter = new SseEmitter(sseTimeout);
			sseEmitter.send(SseEmitter.event().name("connect").reconnectTime(3000).data("connect success"));
			MessageRecord msg = msgCache.remove(msgId);
			if (msg != null) {
				sseEmitter.send(msg);
				System.out.println("发送离线消息");
			}
			
			sseEmitter.onTimeout(() -> {
				System.out.printf("【msgId: %s】：连接超时！\r\n", msgId);
				sseEmitterMap.remove(msgId);
			});
			sseEmitterMap.put(msgId, sseEmitter);
			System.out.printf("【msgId: %s】：连接成功！%s, %s\r\n", msgId, sseEmitter, ShiroManager.getSubject());
		} catch (IOException e) {
			logger.error("连接异常：" + e.getMessage());
		}
		return sseEmitter;
	}

	public void clearMsgCache(String msgId) {
		msgCache.remove(msgId);
	}
}
