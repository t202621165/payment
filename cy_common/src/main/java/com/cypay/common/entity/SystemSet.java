package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.alibaba.fastjson.JSON;
import com.cypay.common.to.FeeStandard;
import com.cypay.common.to.GameEngine;
import com.cypay.common.to.SettlementBank;
import com.cypay.common.util.CommonUtil;

import cn.hutool.core.collection.CollUtil;

@Entity
@DynamicUpdate
@Table(name = "cy_system_set")
public class SystemSet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**系统设置唯一标识*/
	@Column(unique = true, nullable = false, updatable = false, length = 10)
	private String mark;
	
	/**网站名称*/
	@Column(nullable = false)
	private String webName;
	
	/**网站底部版权信息*/
	private String copyright;
	
	/**默认结算类型*/
	@Column(nullable = false)
	private Integer settlementType = 0;
	
	/**定时结算*/
	@Column(nullable = false)
	private Boolean timedSettlement = Boolean.FALSE;
	
	/**商户可创建定时任务数量*/
	private Integer taskCount = 5;
	
	/**T0最小提现金额*/
	@Column(nullable = false)
	private BigDecimal t0MinAmount = new BigDecimal(0.00);
	
	/**T1最小结算金额(定时器)*/
	@Column(nullable = false)
	private BigDecimal t1MinAmount = new BigDecimal(0.00);
	
	/*默认结算提现手续费*/
	private BigDecimal defaultFee = new BigDecimal(0.00);
	
	/**客服QQ*/
	@Column(name = "service_qq")
	private String serviceQQ;
	
	/**客服电话*/
	private String servicePhone;
	
	/**网站注册状态0：关闭 1：开启 2：注册审核*/
	@Column(nullable = false)
	private Integer registerState = 2;
	
	/**游戏引擎(JSONArray)*/
	@Column(nullable = false, columnDefinition = "text")
	private String gameEngine;
	
	/**结算银行(JSONArray)*/
	@Column(nullable = false, columnDefinition = "text")
	private String settlementBank;
	
	/**默认开启IPS统计*/
	private Boolean isIps = Boolean.TRUE;
	
	/**默认开启游戏登陆统计*/
	private Boolean isLogin = Boolean.TRUE;
	
	/*是否开启订单尾额功能*/
	private Boolean isOpenTailAmount = Boolean.FALSE;
	
	/*尾额结算比例*/
	private Integer tailAmountRatio = 0;
	
	/*尾额范围*/
	@Column(scale = 2)
	private Double tailAmountScope = 0.5;
	
	/**流量统计时间间隔*/
	private int visitTime = 5;
	
	/**游戏登陆统计间隔*/
	private int loginTime = 30;
	
	/**系统版本号*/
	@Column(updatable = false)
	private String version = "4.0.0";
	
	private String tyVersion = "4.0.0";
	
	private String cq3Version = "4.0.0";
	
	/**资费标准*/
	@Column(columnDefinition="Text")
	private String feeStandard;
	
	/**关于我们*/
	@Column(columnDefinition="Text")
	private String about;
	
	/**公司地址*/
	private String companyAddress;
	
	@Transient
	private List<GameEngine> engines = new ArrayList<>();
	
	@Transient
	private List<SettlementBank> banks = new ArrayList<>();
	
	@Transient
	private List<FeeStandard> fees = new ArrayList<>();
	
	public SystemSet() {
		
	}
	
	public SystemSet(Integer registerState, Integer settlementType,BigDecimal defaultFee) {
		this.registerState = registerState;
		this.settlementType = settlementType;
		this.defaultFee = defaultFee;
	}
	
	public SystemSet(String webName,String servicePhone,String copyright,String companyAddress,
			String feeStandard,String about,String serviceQQ) {
		this.webName = webName;
		this.servicePhone = servicePhone;
		this.copyright = copyright;
		this.companyAddress = companyAddress;
		this.feeStandard = feeStandard;
		this.about = about;
		this.serviceQQ = serviceQQ;
		this.fees = CommonUtil.parseArray(feeStandard, FeeStandard.class, FeeStandard.feeStandards);
	}
	
	public SystemSet(String mark, String webName) {
		this.mark = mark;
		this.webName = webName;
		this.gameEngine = JSON.toJSONString(GameEngine.engines);
		this.settlementBank = JSON.toJSONString(SettlementBank.banks);
		this.version = "4.0.0";
		this.feeStandard = JSON.toJSONString(FeeStandard.feeStandards);
	}
	
	public SystemSet parse() {
		this.engines = CommonUtil.parseArray(gameEngine, GameEngine.class, GameEngine.engines);
		this.banks = CommonUtil.parseArray(settlementBank, SettlementBank.class, SettlementBank.banks);
		this.fees = CommonUtil.parseArray(feeStandard, FeeStandard.class, FeeStandard.feeStandards);
		return this;
	}
	
	public SystemSet parseToJsonStr() {
		if (CollUtil.isNotEmpty(engines)) {
			this.gameEngine = JSON.toJSONString(engines);
		}
		if (CollUtil.isNotEmpty(banks)) {
			this.settlementBank = JSON.toJSONString(banks);
		}
		if (CollUtil.isNotEmpty(fees)) {
			this.feeStandard = JSON.toJSONString(fees);
		}
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Integer getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(Integer settlementType) {
		this.settlementType = settlementType;
	}

	public Boolean getTimedSettlement() {
		return timedSettlement;
	}

	public void setTimedSettlement(Boolean timedSettlement) {
		this.timedSettlement = timedSettlement;
	}

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}

	public BigDecimal getT0MinAmount() {
		return t0MinAmount;
	}

	public void setT0MinAmount(BigDecimal t0MinAmount) {
		this.t0MinAmount = t0MinAmount;
	}

	public BigDecimal getT1MinAmount() {
		return t1MinAmount;
	}

	public void setT1MinAmount(BigDecimal t1MinAmount) {
		this.t1MinAmount = t1MinAmount;
	}

	public String getServiceQQ() {
		return serviceQQ;
	}

	public void setServiceQQ(String serviceQQ) {
		this.serviceQQ = serviceQQ;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public Integer getRegisterState() {
		return registerState;
	}

	public void setRegisterState(Integer registerState) {
		this.registerState = registerState;
	}

	public String getGameEngine() {
		return gameEngine;
	}

	public void setGameEngine(String gameEngine) {
		this.gameEngine = gameEngine;
		this.engines = CommonUtil.parseArray(gameEngine, GameEngine.class);
	}

	public String getSettlementBank() {
		return settlementBank;
	}

	public void setSettlementBank(String settlementBank) {
		this.settlementBank = settlementBank;
		this.banks = CommonUtil.parseArray(settlementBank, SettlementBank.class);
	}

	public List<GameEngine> getEngines() {
		return engines;
	}

	public void setEngines(List<GameEngine> engines) {
		this.engines = engines;
	}

	public List<SettlementBank> getBanks() {
		return banks;
	}

	public void setBanks(List<SettlementBank> banks) {
		this.banks = banks;
	}

	public Boolean getIsIps() {
		return isIps;
	}

	public void setIsIps(Boolean isIps) {
		this.isIps = isIps;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	public Boolean getIsOpenTailAmount() {
		return isOpenTailAmount;
	}

	public void setIsOpenTailAmount(Boolean isOpenTailAmount) {
		this.isOpenTailAmount = isOpenTailAmount;
	}

	public Integer getTailAmountRatio() {
		return tailAmountRatio;
	}

	public void setTailAmountRatio(Integer tailAmountRatio) {
		this.tailAmountRatio = tailAmountRatio;
	}

	public int getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(int visitTime) {
		this.visitTime = visitTime;
	}

	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	

	public String getTyVersion() {
		return tyVersion;
	}

	public void setTyVersion(String tyVersion) {
		this.tyVersion = tyVersion;
	}

	public String getCq3Version() {
		return cq3Version;
	}

	public void setCq3Version(String cq3Version) {
		this.cq3Version = cq3Version;
	}

	public String getFeeStandard() {
		return feeStandard;
	}

	public void setFeeStandard(String feeStandard) {
		this.feeStandard = feeStandard;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public List<FeeStandard> getFees() {
		return fees;
	}

	public void setFees(List<FeeStandard> fees) {
		this.fees = fees;
	}

	public BigDecimal getDefaultFee() {
		return defaultFee;
	}

	public void setDefaultFee(BigDecimal defaultFee) {
		this.defaultFee = defaultFee;
	}

	public Double getTailAmountScope() {
		return tailAmountScope;
	}

	public void setTailAmountScope(Double tailAmountScope) {
		this.tailAmountScope = tailAmountScope;
	}

	@Override
	public String toString() {
		return "SystemSet [id=" + id + ", mark=" + mark + ", webName=" + webName + ", copyright=" + copyright
				+ ", settlementType=" + settlementType + ", timedSettlement=" + timedSettlement + ", taskCount="
				+ taskCount + ", t0MinAmount=" + t0MinAmount + ", t1MinAmount=" + t1MinAmount + ", defaultFee="
				+ defaultFee + ", serviceQQ=" + serviceQQ + ", servicePhone=" + servicePhone + ", registerState="
				+ registerState + ", gameEngine=" + gameEngine + ", settlementBank=" + settlementBank + ", isIps="
				+ isIps + ", isLogin=" + isLogin + ", isOpenTailAmount=" + isOpenTailAmount + ", tailAmountRatio="
				+ tailAmountRatio + ", visitTime=" + visitTime + ", loginTime=" + loginTime + ", version=" + version
				+ ", tyVersion=" + tyVersion + ", cq3Version=" + cq3Version + ", feeStandard=" + feeStandard
				+ ", about=" + about + ", companyAddress=" + companyAddress + "]";
	}

}
