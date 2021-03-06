package com.cypay.pay.vo;

import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$GTE;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$LTE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.entity.Order;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JpaOrderBy
	private Long id;
	
	@JpaQuery(cond = EQ)
	private String orderNumber;

	@JpaQuery(cond = BETWEEN_$GTE, jType = JavaType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderDate;
	
	@JpaQuery
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date payDate;
	
	@JpaQuery(select = false, value = "orderDate", cond = BETWEEN_$LTE, jType = JavaType.DATE)
	private Date endDate = new Date();
	
	@JpaQuery
	private BigDecimal amount;
	
	@JpaQuery
	private Integer state;
	
	@JpaQuery(value = "partition", chain = "name")
	private String partitionName;
	
	@JpaQuery(value = "product", chain = "name")
	private String productName;

	@JpaQuery(select = false, value = "product", subField = "typeMark", cond = EQ)
	private String productTypeMark;
	
	@JpaQuery(select = false, cond = EQ)
	private String playerAccount;

	private String playerQQ;

	private String playerPhone;
	
	private Long productId;
	
	private String uuid;
	
	private String guid;
	
	public OrderVo() {}
	
	public Result validate() {
		if (playerAccount == null) {
			return Result.error("不能为空！", "playerAccount");
		}
		
		playerAccount = playerAccount.replace(" ", "");
		if (StringUtils.isEmpty(playerAccount))
			return Result.error("不能为空！", "playerAccount");
		
		if (amount == null)
			return Result.error("请输入有效的充值金额！", "amount");
		
		return Result.success("校验成功！");
	}
	
	public Order createOrder() {
		Order order = new Order(amount, CommonUtil.replaceBlank(playerAccount), playerQQ, playerPhone, productId);
		return order;
	}
	

	public OrderVo(String orderNumber, Date orderDate, Date payDate, BigDecimal amount, Integer state,
			String partitionName, String productName) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.payDate = payDate;
		this.amount = amount;
		this.state = state;
		this.partitionName = partitionName;
		this.productName = productName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(String playerAccount) {
		this.playerAccount = playerAccount;
	}

	public String getPlayerQQ() {
		return playerQQ;
	}

	public void setPlayerQQ(String playerQQ) {
		this.playerQQ = playerQQ;
	}

	public String getPlayerPhone() {
		return playerPhone;
	}

	public void setPlayerPhone(String playerPhone) {
		this.playerPhone = playerPhone;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTypeMark() {
		return productTypeMark;
	}

	public void setProductTypeMark(String productTypeMark) {
		this.productTypeMark = productTypeMark;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "OrderVo [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", payDate="
				+ payDate + ", amount=" + amount + ", state=" + state + ", partitionName=" + partitionName
				+ ", productName=" + productName + ", productTypeMark=" + productTypeMark + ", playerAccount="
				+ playerAccount + ", playerQQ=" + playerQQ + ", playerPhone=" + playerPhone + ", productId=" + productId
				+ ", uuid=" + uuid + "]";
	}
	
}
