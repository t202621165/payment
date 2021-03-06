package com.cypay.common.pattern.strategy.reissue;

import java.util.List;

import org.apache.shiro.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Template;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.ReissueRecordService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.SocketTemplate;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.collection.CollUtil;

/**
 * 网关补发
 * 	手动充值
 * 	整区补发
 * @author International
 *
 */
@Component
public abstract class GatewayReissue {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected ReissueRecordService reissueRecordService;
	
	public abstract String getType();
	
	public abstract List<JSONObject> manualOrWhole(ReissueRecordVo vo);
	
	public Result reissue(ReissueRecordVo vo, Integer type) {
		Assert.notNull(vo, "The V connot be null.");
		
		List<JSONObject> data = manualOrWhole(vo);
		
		Partition p = vo.getPartition();
		if (CollUtil.isEmpty(data))
			return Result.error("当前分区【"+p.getName()+"】暂无可补发数据！");
		
		Integer pType = p.getType(); // 分区类型
		Result result = null;
		if (pType == 4) { // web通讯
			result = communicationByWEB(vo, data);
		} else {
			result = communicationByGageway(vo, type, data);
		}
		if (result.getState()) {
			if (type == 1) {
				orderService.updateOrderRemarks(vo);
			} else if (type != 2) {
				reissueRecordService.saveRecord(vo.getRecords());
			}
		}
		return result;
	}
	
	/**
	 * 网关通讯
	 * @return
	 */
	private Result communicationByGageway(ReissueRecordVo vo, Integer type, List<JSONObject> data) {
		Partition p = vo.getPartition();
		Template t = p.getTemplate();
		JSONObject json = new JSONObject();
		StringBuffer bf = new StringBuffer();
		if (p.getType() == 0) {
			p.setDbInfo(p.getDbInfo());
			json.put("dataBase", p.getDbInfos());
		}else {
			json.put("path", p.getScriptPath());
			bf.append(p.getScriptPath());
		}
		json.put("loadPartion",vo.isLoadPartition()); //是否加载分区
		json.put("pid", p.getId()); // 分区ID
		json.put("flag", p.getType()); // 分区类型
		// 补发类型 (0: 手动充值 1: 玩家充值 2: 订单手动补发 3: 整区补发 4: 定时整区补发)
		json.put("type", type); // 补发类型
		json.put("name", t.getCurrencyName()); // 游戏币名称
		json.put("ratio", t.getRatio()); // 兑换比例
		json.put("data", data);
		bf.append(p.getType()).append(t.getCurrencyName()).append(t.getRatio()).append(type);
		json.put("sign", MD5Util.signToLowerCase(bf.toString(), vo.getUuid(), "UTF-8"));
		logger.info("向网关服务器{},端口{},发送数据:{}",p.getServerIp(),p.getServerPort(),JSONObject.toJSONString(json));
		return SocketTemplate.SMS.send(p.getServerIp(), p.getServerPort(), json);
	}
	
	/**
	 * WEB通讯
	 * @param data
	 * @return
	 */
	private Result communicationByWEB(ReissueRecordVo vo, List<JSONObject> data) {
		Partition p = vo.getPartition();
		for (JSONObject j : data) {
			String result = restTemplate.getForObject(CommonUtil.getBufferString(j.get("url"), j.get("data")), String.class);
			if (!p.getSuccessMark().equals(result)) {
				vo.getRecords().removeIf(r -> r.getSerialNumber().equals(j.get("serialNumber")));
			}
		}
		return Result.success("【WEB通讯】：请前往补发记录（只记录补发成功订单）查看结果");
	}

	public void setReissueRecordService(ReissueRecordService reissueRecordService) {
		this.reissueRecordService = reissueRecordService;
	}
	
}
