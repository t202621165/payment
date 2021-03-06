package com.cypay.common.vo;

import java.util.Date;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Template;

public class PartitionVo extends Partition {

	private static final long serialVersionUID = 1L;
	
	private Long groupId;
	
	private Long merchantId;
	
	private Long templateId;
	
	private String nickname;
	
	@JpaQuery(select = false, value = "merchant", cond = Conditional.EQ, subField = "account")
	private String account;
	
	private String groupName;
	
	private String templateName;
	
	private String currencyName;

	
	public PartitionVo() {
		
	}
	
	public PartitionVo(Long id, Merchant merchant) {
		super(id);
		setMerchant(merchant);
	}
	
	public PartitionVo(Long merchantId, String name) {
		this.merchantId = merchantId;
		setName(name);
	}
	
	public PartitionVo(Merchant merchant) {
		setMerchant(merchant);
	}
	
	public PartitionVo(Long id,String name,String useName,Date changeDate,Date useDate,Boolean isChangeInTime, Long merchantId, Long parentId) {
		setId(id);
		setName(name);
		if (changeDate != null && new Date().compareTo(changeDate) > 0) {
			setName(isChangeInTime ? useName : name);
		}
		Merchant m = new Merchant(merchantId);
		if (parentId != null)
			m.setParent(new Merchant(parentId));
		
		setMerchant(m);
	}
	
	public PartitionVo(Long id, String name, Date useDate, Date changeDate, String useName, Boolean isChangeInTime, 
			Integer type, Integer sort, Boolean state, String scriptPath, String serverIp, Integer serverPort) {
		setId(id);
		setName(name);
		setUseDate(useDate);
		setUseName(useName);
		setServerIp(serverIp);
		setServerPort(serverPort);
		setScriptPath(scriptPath);
		setIsChangeInTime(isChangeInTime);
		setChangeDate(changeDate);
		setType(type);
		setSort(sort);
		setState(state);
	}
	
	public PartitionVo(Long id, String name, Date createDate, Date useDate, Date changeDate, String useName, String serverIp, 
			Integer serverPort, String scriptPath, Integer type, String notice, Boolean noticeState, 
			Boolean ybEgg, String dbInfo, Integer sort, Boolean state, Boolean isChangeInTime, String webUrl, String successMark, 
			String dataFormat, Long templateId) {
		
		this(id, name, useDate, changeDate, useName, isChangeInTime, type, sort, state, scriptPath, serverIp, serverPort);
		setNotice(notice);
		setNoticeState(noticeState);
		setYbEgg(ybEgg);
		setDbInfo(dbInfo);
		setWebUrl(webUrl);
		setSuccessMark(successMark);
		setDataFormat(dataFormat);
		setCreateDate(createDate);
		this.templateId = templateId;
	}
	
	public PartitionVo(Long id, Date createDate, Date changeDate, String name, Date useDate, String useName, 
			Integer type, Integer sort, String uuid, Boolean state, String scriptPath, String serverIp, 
			Integer serverPort, Boolean isChangeInTime, String templateName, String currencyName, Long merchantId, String nickname, 
			String account) {
		
		this(id, name, useDate, changeDate, useName, isChangeInTime, type, sort, state, scriptPath, serverIp, serverPort);
		
		setCreateDate(createDate);
		setUuid(uuid);
		this.templateName = templateName;
		this.currencyName = currencyName;
		this.merchantId = merchantId;
		this.nickname = nickname;
		this.account = account;
	}
	
	
	
	public PartitionVo(Long id,String name,String currencyName,String ip,String path) {
		super();
		this.setId(id);
		this.setName(name);
		this.currencyName = currencyName;
		this.setServerIp(ip);
		this.setScriptPath(path);
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
		if (templateId != null)
			setTemplate(new Template(templateId));
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "PartitionVo [groupId=" + groupId + ", merchantId=" + merchantId + ", templateId=" + templateId
				+ ", nickname=" + nickname + ", groupName=" + groupName + ", templateName=" + templateName
				+ ", currencyName=" + currencyName + "]";
	}

}
