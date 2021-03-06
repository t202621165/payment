package com.cypay.common.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Template;
import com.cypay.common.to.Additional;
import com.cypay.common.to.Equip;
import com.cypay.common.to.Incentive;
import com.cypay.common.to.Integral;
import com.cypay.common.to.RedPacket;
import com.cypay.common.util.CommonUtil;

/**
 * 充值页面模版信息
 * @author International
 * 2018年8月11日 下午4:38:39
 */
public class TemplateVo extends Template {

	private static final long serialVersionUID = 1L;
	
	private Long merchantId;
	
	private String notice;
	
	private Boolean noticeState;
	
	public TemplateVo() {
		
	}
	
	public TemplateVo(Merchant merchant) {
		setMerchant(merchant);
	}
	
	public TemplateVo(Long id, Merchant merchant) {
		super(id);
		setMerchant(merchant);
	}

	public TemplateVo(Long id, String name, Integer type) {
		setId(id);
		setName(name); // name 为分区名称
		setType(type);
	}
	
	public TemplateVo(Long id,String name,Integer type,String currencyName,Integer ratio){
		this.setId(id);
		this.setName(name);  // name 为模板名称
		this.setType(type);
		this.setCurrencyName(currencyName);
		this.setRatio(ratio);
	}
	
	public TemplateVo(Long merchantId,Date changeDate,String useName,String name,Boolean isChangeInTime,String notice,Boolean noticeState,Long templateId,String currencyName,Integer ratio,
			String rechargeWay,BigDecimal minAmount,BigDecimal maxAmount,Boolean giveState,Boolean giveWay,Integer equipType,
			Boolean showAdditional,Boolean showEquip,Boolean showIntegral,String infoAdditional,String infoEquip,String infoIncentive,
			String infoIntegral,String infoRedPacket) {
		this.merchantId = merchantId;
		this.notice = notice;
		this.noticeState = noticeState;
		setId(templateId);
		if (isChangeInTime) {
			setName(new Date().getTime() > changeDate.getTime() ? useName : name); // name 为分区名称
		} else {
			setName(name); // name 为分区名称
		}
		setCurrencyName(currencyName);
		setRatio(ratio);
		setRechargeWay(rechargeWay);
		setMinAmount(minAmount);
		setMaxAmount(maxAmount);
		setGiveState(giveState);
		setGiveWay(giveWay);
		setEquipType(equipType);
		setShowAdditional(showAdditional);
		setShowEquip(showEquip);
		setShowIntegral(showIntegral);
		setAdditionals(CommonUtil.parseArray(infoAdditional, Additional.class));
		setIncentives(CommonUtil.parseArray(infoIncentive, Incentive.class));
		setRedPackets(CommonUtil.parseArray(infoRedPacket, RedPacket.class));
		setIntegrals(CommonUtil.parseArray(infoIntegral, Integral.class));
		setEquips(CommonUtil.parseArray(infoEquip, Equip.class));
	}
	
	public TemplateVo(String name,Long templateId,String currencyName,Integer ratio,
			BigDecimal minAmount,BigDecimal maxAmount,Boolean giveState,Boolean giveWay,
			Boolean showAdditional,Boolean showEquip,Boolean showIntegral,String infoAdditional,
			String infoEquip,String infoIncentive,String infoIntegral,String infoRedPacket) {
		setId(templateId);
		setName(name); // name 为分区名称
		setCurrencyName(currencyName);
		setRatio(ratio);
		setMinAmount(minAmount);
		setMaxAmount(maxAmount);
		setGiveState(giveState);
		setGiveWay(giveWay);
		setShowAdditional(showAdditional);
		setShowEquip(showEquip);
		setShowIntegral(showIntegral);
		setAdditionals(CommonUtil.parseArray(infoAdditional, Additional.class));
		setIncentives(CommonUtil.parseArray(infoIncentive, Incentive.class));
		setRedPackets(CommonUtil.parseArray(infoRedPacket, RedPacket.class));
		setIntegrals(CommonUtil.parseArray(infoIntegral, Integral.class));
		setEquips(CommonUtil.parseArray(infoEquip, Equip.class));
	}
	
	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Boolean getNoticeState() {
		return noticeState;
	}

	public void setNoticeState(Boolean noticeState) {
		this.noticeState = noticeState;
	}

}
