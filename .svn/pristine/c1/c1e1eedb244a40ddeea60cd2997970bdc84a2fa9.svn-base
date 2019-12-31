package com.cypay.common.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Gallery;
import com.cypay.common.enums.Edition;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.repository.impl.GalleryRepository;
import com.cypay.common.vo.GalleryVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.StrUtil;
@Service
public class GalleryService extends BaseServiceImpl<GalleryRepository, Gallery,GalleryVo>{
	
	public List<Gallery> findIdAndGalleryNameList(){
		List<Gallery> gallerys = baseRepository.findIdAndGalleryNameList();
		gallerys.parallelStream().forEach(g -> {
			g.setSupport(PaymentType.getSupportByMark(g.getMark()));
		});
		return gallerys;
	}
	
	public Result updateState(Long id){
		int i = baseRepository.updateState(id);
		if(i > 0){
			return Result.success("通道状态更改成功");
		}else{
			return Result.error("通道状态更改失败");
		}
	}
	
	public Result save(List<String> marks){
		List<Gallery> gallerys = new ArrayList<>();
		Set<String> existMark = new HashSet<>();
		int galleryCount = Edition.current_edition.getGalleryCount();
		if (galleryCount > 0) {
			List<Map<String, Object>> list = baseRepository.findCountGroupByMark();
			for (Map<String, Object> map : list) {
				int i = Integer.valueOf(map.get("count").toString());
				if (i >= galleryCount) {
					existMark.add(map.get("mark").toString());
				}
			}
			
		}
		
		StringBuilder builder = new StringBuilder();
		for (String mark : marks) {
			if (InitialLoader.USABLE_GALLERY.contains(mark)) {
				if (!existMark.contains(mark)) {
					Gallery gallery = PaymentType.getByMark(mark);
					if (gallery != null) {
						gallerys.add(gallery);
					}
				} else {
					if (!"".equals(builder.toString())) {
						builder.append("、");
					}
					builder.append(PaymentType.getPaymentTypeByMark(mark).getName());
				}
			}
		}
		if (!gallerys.isEmpty()) {
			baseRepository.saveAll(gallerys);
		}
		if (!"".equals(builder.toString())) {
			builder.insert(0, "通道【").append("】已达到最大可创建数（").append(galleryCount).append("）！");
		}
		return Result.success("操作成功！" + builder.toString());
	}
	
	@Override
	public Result save(Gallery g){
		if ("wechat".equals(g.getMark()) && StrUtil.isBlank(g.getAppId())) {
			return Result.error("微信支付请输入AppId", "appId");
		}
		
		if (g.getSignType() == 0 ) {
			if (StrUtil.isBlank(g.getMd5Key())) {
				return Result.error("通道密钥不能为空", "md5Key");
			}
		} else {
			if (StrUtil.isBlank(g.getPrivateKey())) {
				return Result.error("私钥不能为空", "privateKey");
			}
			if (StrUtil.isBlank(g.getPublicKey())) {
				return Result.error("公钥不能为空", "publicKey");
			}
		}
		
		baseRepository.save(g);
		return Result.success("通道编辑成功");
	}

	/**
	 * 根据通道标识获取已添加的通道数量
	 * @param mark
	 * @return
	 */
	public Long countByMark(String mark) {
		return baseRepository.countByMark(mark);
	}
	
	public Gallery findByMark(String mark){
		return baseRepository.findByMark(mark);
	}
}
