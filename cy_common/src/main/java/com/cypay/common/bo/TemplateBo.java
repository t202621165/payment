package com.cypay.common.bo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cypay.common.entity.Line;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.TemplateProductVo;

public class TemplateBo {
	private Long id;
	private String name;
	private Integer type;
	private String gameName;
	private String currencyName;
	private Integer ratio;
	private BigDecimal minAmount;
	private BigDecimal maxAmount;
	private String rechargeWay;
	private Boolean giveWay;
	private Boolean giveState;
	private Boolean isContains;
	private Boolean showAdditional;
	private Boolean showIntegral;
	private Boolean showEquip;
	private String scriptCommand;
	private String browserCommand;
	private String gameEngine;
	private String infoNpc;
	private String infoIncentive;
	private String infoAdditional;
	private String infoIntegral;
	private String infoEquip;
	private Integer equipType;
	private Boolean ybEgg;
	private String scriptPath;
	private String uuid;
	private Set<String> lines;
	private List<TemplateProductVo> products;
	private Boolean redPacketState;
	private Boolean redPacketAdditional;
	private Boolean redPacketIntegral;
	private Boolean redPacketEquip;
	private Boolean cardState;
	
	public TemplateBo(Long id, String name, Integer type, String gameName, String currencyName, Integer ratio,
			BigDecimal minAmount, BigDecimal maxAmount, String rechargeWay, Boolean giveWay, Boolean giveState,
			Boolean isContains, Boolean showAdditional, Boolean showIntegral, Boolean showEquip, String scriptCommand,
			String browserCommand, String gameEngine, String infoNpc, String infoIncentive, String infoAdditional,
			String infoIntegral, String infoEquip,Boolean ybEgg,String scriptPath, String uuid,Integer equipType,
			Boolean redPacketState,Boolean redPacketAdditional,Boolean redPacketIntegral,Boolean redPacketEquip,Boolean cardState) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gameName = gameName;
		this.currencyName = currencyName;
		this.ratio = ratio;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.rechargeWay = rechargeWay;
		this.giveWay = giveWay;
		this.giveState = giveState;
		this.isContains = isContains;
		this.showAdditional = showAdditional;
		this.showIntegral = showIntegral;
		this.showEquip = showEquip;
		this.scriptCommand = scriptCommand;
		this.browserCommand = browserCommand;
		this.gameEngine = gameEngine;
		this.infoNpc = infoNpc;
		this.infoIncentive = infoIncentive;
		this.infoAdditional = infoAdditional;
		this.infoIntegral = infoIntegral;
		this.infoEquip = infoEquip;
		this.ybEgg = ybEgg;
		this.scriptPath = scriptPath;
		this.uuid = uuid;
		this.equipType = equipType;
		this.redPacketState = redPacketState;
		this.redPacketAdditional = redPacketAdditional;
		this.redPacketIntegral = redPacketIntegral;
		this.redPacketEquip = redPacketEquip;
		this.cardState = cardState;
	}
	
	public TemplateBo(Long id, String name, Integer type, String gameName, String currencyName, Integer ratio,
			BigDecimal minAmount, BigDecimal maxAmount, String rechargeWay, Boolean giveWay, Boolean giveState,
			Boolean isContains, Boolean showAdditional, Boolean showIntegral, Boolean showEquip, String scriptCommand,
			String browserCommand, String gameEngine, String infoNpc, String infoIncentive, String infoAdditional,
			String infoIntegral, String infoEquip,Integer equipType,
			Boolean redPacketState,Boolean redPacketAdditional,Boolean redPacketIntegral,Boolean redPacketEquip,Boolean cardState) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gameName = gameName;
		this.currencyName = currencyName;
		this.ratio = ratio;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.rechargeWay = rechargeWay;
		this.giveWay = giveWay;
		this.giveState = giveState;
		this.isContains = isContains;
		this.showAdditional = showAdditional;
		this.showIntegral = showIntegral;
		this.showEquip = showEquip;
		this.scriptCommand = scriptCommand;
		this.browserCommand = browserCommand;
		this.gameEngine = gameEngine;
		this.infoNpc = infoNpc;
		this.infoIncentive = infoIncentive;
		this.infoAdditional = infoAdditional;
		this.infoIntegral = infoIntegral;
		this.infoEquip = infoEquip;
		this.equipType = equipType;
		this.equipType = equipType;
		this.redPacketState = redPacketState;
		this.redPacketAdditional = redPacketAdditional;
		this.redPacketIntegral = redPacketIntegral;
		this.redPacketEquip = redPacketEquip;
		this.cardState = cardState;
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

	public Boolean getYbEgg() {
		return ybEgg;
	}

	public void setYbEgg(Boolean ybEgg) {
		this.ybEgg = ybEgg;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Set<String> getLines() {
		return lines;
	}
		

	public List<TemplateProductVo> getProducts() {
		return products;
	}

	public void setProducts(List<TemplateProductVo> products) {
		this.products = products;
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

	public void setLines(List<Line> lines) {
		if (lines != null) {
			this.lines = lines.parallelStream().map(l -> {
				return CommonUtil.getBufferString(CommonUtil.getWholeDomainName(
						l.getDomainName(), l.getPort()), "/pay/recharge/", uuid);
			}).collect(Collectors.toSet());
		}
	}

}
