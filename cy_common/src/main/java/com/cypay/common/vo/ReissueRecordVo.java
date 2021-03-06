package com.cypay.common.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;
import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.ReissueRecord;

public class ReissueRecordVo extends ReissueRecord {

	private static final long serialVersionUID = 1L;
	
	@JpaQuery(select = false, value = "reissueDate", cond = Conditional.BETWEEN_$GTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate = new Date();
	
	@JpaQuery(select = false, value = "reissueDate", cond = Conditional.BETWEEN_$LTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate = new Date();
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date autoDate = new Date();
	
	private String uuid;
	
	private Long merchantId;
	
	private Long productId;
	
	private Long partitionId;
	
	private String productName;
	
	private String partitionName;
	
	private String remarks;
	
	private BigDecimal giveAmount = BigDecimal.ZERO;
	
	private BigDecimal redPacketAmount = BigDecimal.ZERO;
	
	private BigDecimal added = BigDecimal.ZERO; // 额外补发比例
	
	private boolean containGiveAmount; // 包含赠送金额
	
	private boolean containRedPacket; // 包含红包赠送
	
	private boolean containManual; // 包含手动充值
	
	private boolean onlyYB; // 额外补发只补发元宝
	
	private boolean isAuto; // 是否自动补发
	
	private boolean loadPartition; //是否加载分区
	
	private List<ReissueRecordVo> records = new ArrayList<ReissueRecordVo>();
	
	public ReissueRecordVo() {
		
	}
	
	public ReissueRecordVo(Long id, Date reissueDate, String serialNumber, BigDecimal amount, 
			String playerAccount,String pName, Boolean type, Long productId, String productName, Long partitionId, 
			String partitionName, String useName, Date changeDate, Boolean isChangeInTime) {
		setId(id);
		setSerialNumber(serialNumber);
		setReissueDate(reissueDate);
		setAmount(amount);
		setType(type);
		setPlayerAccount(playerAccount);
		setpName(pName);
		this.productId = productId;
		this.productName = productName;
		this.partitionId = partitionId;
		this.partitionName = partitionName;
		if (changeDate !=null && new Date().compareTo(changeDate) > 0) {
			this.partitionName = isChangeInTime ? useName : partitionName;
		}
	}
	
	public ReissueRecordVo(String serialNumber, BigDecimal amount, String playerAccount, 
			Long productId, Long partitionId) {
		setProduct(new Product(productId));
		this.productId = productId;
		this.partitionId = partitionId;
		setSerialNumber(serialNumber);
		setAmount(amount);
		setPlayerAccount(playerAccount);
	}
	
	public String toJSONString() {
		setMerchant(null);
		setPartition(null);
		setProduct(null);
		this.added = this.added.setScale(2, RoundingMode.HALF_UP);
		return JSON.toJSONString(this);
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
		if (merchantId != null)
			setMerchant(new Merchant(merchantId));
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
		if (productId != null)
			setProduct(new Product(productId));
	}

	public Long getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(Long partitionId) {
		this.partitionId = partitionId;
		if (partitionId != null)
			setPartition(new Partition(partitionId));
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getGiveAmount() {
		return giveAmount;
	}

	public void setGiveAmount(BigDecimal giveAmount) {
		this.giveAmount = giveAmount;
	}

	public BigDecimal getRedPacketAmount() {
		return redPacketAmount;
	}

	public void setRedPacketAmount(BigDecimal redPacketAmount) {
		this.redPacketAmount = redPacketAmount;
	}

	public boolean isContainGiveAmount() {
		return containGiveAmount;
	}

	public void setContainGiveAmount(boolean containGiveAmount) {
		this.containGiveAmount = containGiveAmount;
	}

	public Date getAutoDate() {
		return autoDate;
	}

	public void setAutoDate(Date autoDate) {
		this.autoDate = autoDate;
	}

	public BigDecimal getAdded() {
		return added;
	}

	public void setAdded(BigDecimal added) {
		this.added = added;
	}

	public boolean isContainRedPacket() {
		return containRedPacket;
	}

	public void setContainRedPacket(boolean containRedPacket) {
		this.containRedPacket = containRedPacket;
	}

	public boolean isContainManual() {
		return containManual;
	}

	public void setContainManual(boolean containManual) {
		this.containManual = containManual;
	}

	public boolean isOnlyYB() {
		return onlyYB;
	}

	public void setOnlyYB(boolean onlyYB) {
		this.onlyYB = onlyYB;
	}

	public boolean isAuto() {
		return isAuto;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public boolean isLoadPartition() {
		return loadPartition;
	}

	public void setLoadPartition(boolean loadPartition) {
		this.loadPartition = loadPartition;
	}

	public List<ReissueRecordVo> getRecords() {
		return records;
	}

	public void setRecords(List<ReissueRecordVo> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "ReissueRecordVo [startDate=" + startDate + ", endDate=" + endDate + ", autoDate=" + autoDate
				+ ", productName=" + productName + ", partitionName=" + partitionName + ", added=" + added
				+ ", containGiveAmount=" + containGiveAmount + ", containRedPacket=" + containRedPacket
				+ ", containManual=" + containManual + ", onlyYB=" + onlyYB + ", isAuto=" + isAuto + "]";
	}

}
