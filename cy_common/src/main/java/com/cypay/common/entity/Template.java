package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.VerifyMode;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.to.Additional;
import com.cypay.common.to.Equip;
import com.cypay.common.to.Incentive;
import com.cypay.common.to.Integral;
import com.cypay.common.to.MultiWayGive;
import com.cypay.common.to.NpcInfo;
import com.cypay.common.to.RedPacket;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.hutool.core.util.RandomUtil;

/**
 * 分区模板实体
 * @author International
 * 2018年8月2日 上午11:55:24
 */
@Entity
@DynamicUpdate
@Table(name = "cy_template")
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "templateWithPartition",
			attributeNodes = {@NamedAttributeNode(value = "partitions")}
	)
})
public class Template implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**模板-ID*/
	@JpaOrderBy
	@JpaQuery(select = false, cond = Conditional.EQ)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**模板-名称*/
	@Column(length = 16, nullable = false)
	private String name;
	
	/**模板-模板类型: 0：通用 1：传奇 2：传世 3：传奇三*/
	@JpaQuery(select = false, cond = Conditional.EQ)
	@Column(nullable = false, updatable = false)
	private Integer type;
	
	/**模板-游戏名称*/
	private String gameName;
	
	/**模板-游戏币名称*/
	private String currencyName;
	
	/**模板-充值赠送比例*/
	private Integer ratio = 1;
	
	/**模板-充值允许最小付款金额*/
	@Column(nullable = false)
	private BigDecimal minAmount = new BigDecimal(1.00);
	
	/**模板-充值允许最大付款金额-0.00：无上限*/
	@Column(nullable = false)
	private BigDecimal maxAmount = new BigDecimal(10000.00);

	/**模板-充值方式: true：游戏帐号、角色名称...*/
	@Column(nullable = false)
	private String rechargeWay = "游戏帐号";
	
	/**模板-赠送方式: true：金额段 false：固定比率*/
	@Column(nullable = false)
	private Boolean giveWay = Boolean.FALSE;
	
	/**模板-渠道赠送状态*/
	@Column(nullable = false)
	private Boolean giveState = Boolean.TRUE;
	
	/**模板-渠道赠送是否包含激励赠送*/
	@Column(nullable = false)
	private Boolean isContains = Boolean.TRUE;
	
	/**模板-附加赠送显示状态*/
	@Column(nullable = false)
	private Boolean showAdditional = Boolean.FALSE;
	
	/**模板-积分赠送显示状态*/
	@Column(nullable = false)
	private Boolean showIntegral = Boolean.FALSE;
	
	/**模板-装备赠送显示状态*/
	@Column(nullable = false)
	private Boolean showEquip = Boolean.FALSE;
	
	/**模板-装备赠送方式
	 * 0：关闭赠送 
	 * 1：按充值金额赠送
	 * 2：充值金额 + 渠道赠送
	 * 3：充值金额 + 激励赠送
	 * 4：充值金额 + 激励赠送 + 渠道赠送
	 * */
	@Column(nullable = false)
	private Integer equipType = 0;
	
	/**模板-红包赠送开启状态*/
	@Column(nullable = false)
	private Boolean redPacketState = Boolean.FALSE;
	
	/**模板-红包附加赠送*/
	@Column(nullable = false)
	private Boolean redPacketAdditional = Boolean.FALSE;
	
	/**模板-红包积分赠送*/
	@Column(nullable = false)
	private Boolean redPacketIntegral = Boolean.FALSE;
	
	/**模板-红包装备赠送*/
	@Column(nullable = false)
	private Boolean redPacketEquip = Boolean.FALSE;
	
	/**模板-点卡充值开启状态*/
	@Column(nullable = false)
	private Boolean cardState = Boolean.FALSE;
	
	/**模板-脚本命令*/
	private String scriptCommand;

	/**模板-浏览器指令*/
	private String browserCommand;

	/**模板-游戏引擎*/
	private String gameEngine;

	/**模板-NPC信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoNpc;

	/**模板-激励赠送信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoIncentive;

	/**模板-附加赠送信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoAdditional;

	/**模板-积分赠送信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoIntegral;

	/**模板-装备赠送信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoEquip;
	
	/**模板-红包赠送信息(JSONArray)*/
	@Column(columnDefinition = "text")
	private String infoRedPacket;
	
	/**模板-分区*/
	@OneToMany(mappedBy = "template")
	private Set<Partition> partitions = new HashSet<Partition>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "template",cascade = CascadeType.REMOVE)
	private Set<TemplateProduct> templateProducts = new HashSet<TemplateProduct>();
	
	/**模板-所属商户*/
	@JpaQuery(select = false, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@JSONField(serialize = false)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Merchant merchant;

	/*********************@Transient***********************************/
	@Transient
	private List<TemplateProduct> products = new ArrayList<TemplateProduct>();
	
	@Transient
	private List<RedPacket> redPackets = new ArrayList<RedPacket>();
	
	@Transient
	private List<Incentive> incentives = new ArrayList<Incentive>();
	
	@Transient
	private List<Additional> additionals = new ArrayList<Additional>();
	
	@Transient
	private List<Integral> integrals = new ArrayList<Integral>();
	
	@Transient
	private List<Equip> equips = new ArrayList<Equip>();
	
	@Transient
	private List<NpcInfo> npcInfos = new ArrayList<NpcInfo>();
	
	/*********************@Transient***********************************/
	
	public Template() {
		
	}

	public Template(Long id) {
		this.id = id;
	}
	
	public Result validate(Boolean isWg) {
		if (StringUtils.isEmpty(this.name.trim()) || 
				this.name.length() > 16)
			return Result.error("模板名称不能为空，并且不超过16个字符", "name");
		
		if (StringUtils.isEmpty(this.currencyName.trim()) || this.currencyName.length() > 5)
			return Result.error("游戏币不能为空，并且不超过5个字符", "currencyName");
		
		if (this.ratio == null || this.ratio < 1)
			return Result.error("请设置兑换比例", "ratio");
		if (!isWg){
			this.merchant = ShiroManager.getMerchant();
			this.infoRedPacket = JSON.toJSONString(redPackets);
			this.infoAdditional = JSON.toJSONString(additionals);
			this.infoIncentive = JSON.toJSONString(incentives);
			this.infoIntegral = JSON.toJSONString(integrals);
			this.infoEquip = JSON.toJSONString(equips);
			this.infoNpc = JSON.toJSONString(npcInfos);
		}
		return Result.success();
	}
	
	public void parse() {
		this.redPackets = CommonUtil.parseArray(this.infoRedPacket, RedPacket.class);
		this.incentives = CommonUtil.parseArray(infoIncentive, Incentive.class);
		this.equips = CommonUtil.parseArray(infoEquip, Equip.class);
		this.npcInfos = CommonUtil.parseArray(StringUtils.isEmpty(infoNpc) ? JSONObject.toJSONString(NpcInfo.npcInfos) : infoNpc, NpcInfo.class);
		setAdditionals(CommonUtil.parseArray(this.infoAdditional, Additional.class));
		setIntegrals(CommonUtil.parseArray(infoIntegral, Integral.class));
	}
	
	/**
	 * 根据充值金额获取激励赠送金额
	 * @param amount
	 * @return
	 */
	public BigDecimal incentiveAmount(int amount) {
		int iAmount = this.incentives.stream()
				.filter(i -> i.getAmount() <= amount).map(i -> i.getGiveAmount()).reduce(0, Integer::max);
		return new BigDecimal(iAmount);
	}
	
	/**
	 * 
	 * @param amount
	 * 			充值金额
	 * @param cAmount
	 * 			渠道赠送金额
	 * @return
	 */
	public JSONObject dataToGetway(ReissueRecordVo v, BigDecimal cAmount, String uuid) {
		StringBuilder bf = new StringBuilder(v.getPlayerAccount());
		StringBuilder remarksBuf = new StringBuilder();
		StringBuilder remarksBuf2 = new StringBuilder();
		BigDecimal amount = v.getAmount();
		boolean containGiveAmount = v.isContainGiveAmount();
		boolean containRedPacket = v.isContainRedPacket();
		boolean onlyYB = v.isOnlyYB();
		BigDecimal added = new BigDecimal(0.01).multiply(v.getAdded()).add(BigDecimal.ONE).setScale(2, RoundingMode.HALF_UP);
		BigDecimal iAmount = incentiveAmount(amount.intValue());
		JSONObject json = new JSONObject();
		// 红包赠送金额
		BigDecimal packetAmount = redPacket(amount);
		
		BigDecimal currency = (!containGiveAmount?amount.add(cAmount).add(iAmount):amount).multiply(added);
		remarksBuf.append(currencyName).append("x").append(currency.intValue() * ratio);

		v.setGiveAmount(cAmount.add(iAmount));
		Integer partitionType = v.getPartition().getType(); // 分区类型
		if (partitionType == 4) {
			String dataFormat = v.getPartition().getDataFormat();
			dataFormat = dataFormat.replace("订单号", v.getSerialNumber()).replace("玩家账号", v.getPlayerAccount()).replace("支付方式", v.getProductName()).replace("兑换比例", String.valueOf(ratio))
			.replace("游戏币", currencyName).replace("实际支付金额", String.valueOf(amount.intValue())).replace("赠送后金额", String.valueOf(currency.intValue())).replace("签名密钥", uuid);
			String[] dataFormatArr = dataFormat.split("(MD5\\()|[)]");
			json.put("url", v.getPartition().getWebUrl());
			json.put("serialNumber", v.getSerialNumber());
			json.put("data", CommonUtil.getBuffer("?", dataFormatArr[0], MD5Util.signToLowerCase(dataFormatArr[1], "", "UTF-8")));
		} else {
			bf.append(amount.intValue()).append(currency.intValue());
			json.put("account", v.getPlayerAccount());
			json.put("amount", amount.intValue()); // 充值金额
			json.put("currency", currency.intValue()); // 游戏币金额
			boolean isPacket = CommonUtil.isDecimal(packetAmount);
			if (isPacket && containRedPacket) {
				json.put("hbAmount", packetAmount.intValue()); // 红包赠送金额
				v.setRedPacketAmount(packetAmount);
				bf.append(packetAmount.intValue());
				remarksBuf2.append(currencyName).append("x").append(packetAmount.intValue() * ratio);
			}
			
			if (partitionType == 1 || partitionType == 2) {
				// 附加赠送
				List<Map<String, Object>> aArray = this.additionals.stream().filter(a -> a.getRatio() > 0 && a.getType() != 0).map(a -> {
					Map<String, Object> map = new HashMap<String, Object>();
					BigDecimal finalAmount = (!containGiveAmount?a.calcFinalAmount(amount, cAmount, iAmount)
							:amount).multiply(onlyYB?BigDecimal.ONE:added);
					int ratio = a.getRatio();
					map.put("ratio", ratio);
					map.put("show", a.isShow());
					map.put("name", a.getName());
					map.put("amount", finalAmount.intValue());
					bf.append(a.getName()).append(finalAmount.intValue()).append(ratio);
					remarksBuf.append("、").append(a.getName()).append("x").append(finalAmount.intValue() * ratio);
					if (redPacketAdditional && isPacket && containRedPacket) {
						map.put("hbAmount", packetAmount.intValue());
						bf.append(packetAmount.intValue());
						remarksBuf2.append("、").append(a.getName()).append("x").append(packetAmount.intValue() * ratio);
					}
					return map;
				}).collect(Collectors.toList());
				json.put("additional", aArray.isEmpty()?null:aArray);
				
				// 积分赠送
				List<Map<String, Object>> iArray = this.integrals.stream().filter(i -> i.getRatio() > 0 && i.getType() != 0).map(i -> {
					
					Map<String, Object> map = new HashMap<String, Object>();
					BigDecimal finalAmount = (!containGiveAmount?i.calcFinalAmount(amount, cAmount, iAmount)
							:amount).multiply(onlyYB?BigDecimal.ONE:added);
					int ratio = i.getRatio();
					map.put("ratio", ratio);
					map.put("show", i.isShow());
					map.put("name", i.getName());
					map.put("amount", finalAmount.intValue());
					bf.append(i.getName()).append(finalAmount.intValue()).append(ratio);
					remarksBuf.append("、").append(i.getName()).append("x").append(finalAmount.intValue() * ratio);
					if (redPacketIntegral && isPacket && containRedPacket) {
						map.put("hbAmount", packetAmount.intValue());
						bf.append(packetAmount.intValue());
						remarksBuf2.append("、").append(i.getName()).append("x").append(packetAmount.intValue() * ratio);
					}
					return map;
				}).collect(Collectors.toList());
				json.put("integral", iArray.isEmpty()?null:iArray);
				
				int equipAmount = (!containGiveAmount?(MultiWayGive.calcFinalAmount(equipType, amount, cAmount, iAmount)):amount)
						.multiply(onlyYB?BigDecimal.ONE:added).add(redPacketEquip && containRedPacket?packetAmount:BigDecimal.ZERO).intValue();
				// 装备赠送
				List<Map<String, Object>> eArray = this.equips.stream().filter(e -> e.getAmount() > 0 && equipAmount >= e.getAmount()).map(e -> {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("amount", e.getAmount());
					map.put("name", e.getName());
					bf.append(e.getAmount());
					remarksBuf.append("、").append(e.getName()).append("x1");
					return map;
				}).collect(Collectors.toList());
				json.put("equip", eArray.isEmpty()?null:eArray);
			}
			
			json.put("sign", MD5Util.signToLowerCase(bf.toString(), uuid, "UTF-8"));
		}
		
		if (!"".equals(remarksBuf2.toString())) {
			remarksBuf.append("。红包赠送：").append(remarksBuf2);	
		}
		v.setRemarks(remarksBuf.toString());
		return json;
	}
	
	/**
	 * 获取红包赠送金额
	 * @param amount
	 * @return
	 */
	private BigDecimal redPacket(BigDecimal amount) {
		BigDecimal packetAmount = new BigDecimal(0);
		
		if (redPacketState) {
			Optional<RedPacket> optional = this.redPackets.stream().filter(r -> r.getAmount() 
					<= amount.intValue()).max(Comparator.comparingInt(RedPacket ::getAmount));
			
			if (optional.isPresent()) {
				RedPacket redPacket = optional.get();
				packetAmount = new BigDecimal(RandomUtil.randomInt(
						redPacket.getStartAmount(), redPacket.getEndAmount()));
			}
		}
		return packetAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Integer getRatio() {
		return ratio;
	}

	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getRechargeWay() {
		return rechargeWay;
	}

	public void setRechargeWay(String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}

	public Boolean getGiveWay() {
		return giveWay;
	}

	public void setGiveWay(Boolean giveWay) {
		this.giveWay = giveWay;
	}

	public Boolean getGiveState() {
		return giveState;
	}

	public void setGiveState(Boolean giveState) {
		this.giveState = giveState;
	}

	public Boolean getIsContains() {
		return isContains;
	}

	public void setIsContains(Boolean isContains) {
		this.isContains = isContains;
	}

	public Boolean getShowAdditional() {
		return showAdditional;
	}

	public void setShowAdditional(Boolean showAdditional) {
		this.showAdditional = showAdditional;
	}

	public Boolean getShowIntegral() {
		return showIntegral;
	}

	public void setShowIntegral(Boolean showIntegral) {
		this.showIntegral = showIntegral;
	}

	public Boolean getShowEquip() {
		return showEquip;
	}

	public void setShowEquip(Boolean showEquip) {
		this.showEquip = showEquip;
	}

	public Integer getEquipType() {
		return equipType;
	}

	public void setEquipType(Integer equipType) {
		this.equipType = equipType;
	}

	public Boolean getRedPacketState() {
		return redPacketState;
	}

	public void setRedPacketState(Boolean redPacketState) {
		this.redPacketState = redPacketState;
	}

	public Boolean getRedPacketAdditional() {
		return redPacketAdditional;
	}

	public void setRedPacketAdditional(Boolean redPacketAdditional) {
		this.redPacketAdditional = redPacketAdditional;
	}

	public Boolean getRedPacketIntegral() {
		return redPacketIntegral;
	}

	public void setRedPacketIntegral(Boolean redPacketIntegral) {
		this.redPacketIntegral = redPacketIntegral;
	}

	public Boolean getRedPacketEquip() {
		return redPacketEquip;
	}

	public void setRedPacketEquip(Boolean redPacketEquip) {
		this.redPacketEquip = redPacketEquip;
	}

	public Boolean getCardState() {
		return cardState;
	}

	public void setCardState(Boolean cardState) {
		this.cardState = cardState;
	}

	public String getScriptCommand() {
		return scriptCommand;
	}

	public void setScriptCommand(String scriptCommand) {
		this.scriptCommand = scriptCommand;
	}

	public String getBrowserCommand() {
		return browserCommand;
	}

	public void setBrowserCommand(String browserCommand) {
		this.browserCommand = browserCommand;
	}

	public String getGameEngine() {
		return gameEngine;
	}

	public void setGameEngine(String gameEngine) {
		this.gameEngine = gameEngine;
	}

	public String getInfoNpc() {
		return infoNpc;
	}

	public void setInfoNpc(String infoNpc) {
		this.infoNpc = infoNpc;
	}

	public String getInfoIncentive() {
		return infoIncentive;
	}

	public void setInfoIncentive(String infoIncentive) {
		this.infoIncentive = infoIncentive;
	}

	public String getInfoAdditional() {
		return infoAdditional;
	}

	public void setInfoAdditional(String infoAdditional) {
		this.infoAdditional = infoAdditional;
	}

	public String getInfoIntegral() {
		return infoIntegral;
	}

	public void setInfoIntegral(String infoIntegral) {
		this.infoIntegral = infoIntegral;
	}

	public String getInfoEquip() {
		return infoEquip;
	}

	public void setInfoEquip(String infoEquip) {
		this.infoEquip = infoEquip;
	}

	public String getInfoRedPacket() {
		return infoRedPacket;
	}

	public void setInfoRedPacket(String infoRedPacket) {
		this.infoRedPacket = infoRedPacket;
	}

	public Set<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(Set<Partition> partitions) {
		this.partitions = partitions;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public List<TemplateProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TemplateProduct> products) {
		this.products = products;
	}

	public List<RedPacket> getRedPackets() {
		return redPackets;
	}

	public void setRedPackets(List<RedPacket> redPackets) {
		this.redPackets = redPackets;
	}

	public List<Incentive> getIncentives() {
		return incentives;
	}

	public void setIncentives(List<Incentive> incentives) {
		this.incentives = incentives;
	}

	public List<Additional> getAdditionals() {
		return additionals;
	}

	public void setAdditionals(List<Additional> additionals) {
		if (additionals == null || additionals.isEmpty()) {
			additionals = new ArrayList<Additional>();
			additionals.add(new Additional("金刚石", "GAMEDIAMOND + "));
			additionals.add(new Additional("荣誉点", "GAMEGLORY + "));
			additionals.add(new Additional("游戏点", "GAMEPOINT + "));
			additionals.add(new Additional("灵符", "GAMEGIRD + "));
			additionals.add(new Additional("声望", "CREDITPOINT + "));
		}
		this.additionals = additionals;
	}

	public List<Integral> getIntegrals() {
		return integrals;
	}

	public void setIntegrals(List<Integral> integrals) {
		if (integrals == null || integrals.isEmpty()) {
			integrals = new ArrayList<Integral>();
			integrals.add(new Integral("元宝消费", "\\QuestDiary\\充值积分\\元宝消费Save.txt"));
			integrals.add(new Integral("消费积分", "\\QuestDiary\\充值积分\\消费积分Save.txt"));
		}
		this.integrals = integrals;
	}

	public List<Equip> getEquips() {
		return equips;
	}

	public void setEquips(List<Equip> equips) {
		this.equips = equips;
	}

	public List<NpcInfo> getNpcInfos() {
		return npcInfos;
	}

	public void setNpcInfos(List<NpcInfo> npcInfos) {
		this.npcInfos = npcInfos;
	}

	public Set<TemplateProduct> getTemplateProducts() {
		return templateProducts;
	}

	public void setTemplateProducts(Set<TemplateProduct> templateProducts) {
		this.templateProducts = templateProducts;
	}

	@Override
	public String toString() {
		return "Template [id=" + id + ", name=" + name + ", type=" + type + ", gameName=" + gameName + ", currencyName="
				+ currencyName + ", ratio=" + ratio + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount
				+ ", rechargeWay=" + rechargeWay + ", giveWay=" + giveWay + ", giveState=" + giveState + ", isContains="
				+ isContains + ", showAdditional=" + showAdditional + ", showIntegral=" + showIntegral + ", showEquip="
				+ showEquip + ", equipType=" + equipType + ", redPacketState=" + redPacketState
				+ ", redPacketAdditional=" + redPacketAdditional + ", redPacketIntegral=" + redPacketIntegral
				+ ", redPacketEquip=" + redPacketEquip + ", cardState=" + cardState + ", scriptCommand=" + scriptCommand
				+ ", browserCommand=" + browserCommand + ", gameEngine=" + gameEngine + ", infoNpc=" + infoNpc
				+ ", infoIncentive=" + infoIncentive + ", infoAdditional=" + infoAdditional + ", infoIntegral="
				+ infoIntegral + ", infoEquip=" + infoEquip + ", infoRedPacket=" + infoRedPacket + "]";
	}
	
}
