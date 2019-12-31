package com.cypay.common.vo;

import static com.cypay.common.annotation.jpa.Conditional.EQ;

import java.util.Date;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.entity.Merchant;

public class MerchantVo extends Merchant {

	private static final long serialVersionUID = 1L;
	
	@JpaQuery(select = false, value = "parent",subField = "account",cond = EQ)
	private String agencyAccount;
	
	private Long merchantCount;
	
	private String nPassword;
	
	private String cPassword;
	
	private Long partitionCount;
	
	public MerchantVo() {}

	public MerchantVo(Long merchantCount) {
		super();
		this.merchantCount = merchantCount;
	}
	
	public MerchantVo(Long id,String secretKey,String uuid){
		this.setId(id);
		this.setSecretKey(secretKey);
		this.setUuid(uuid);
	}
	
	public MerchantVo(Long id,String nickname,String account,Date joinDate,Date finalDate,Boolean type,
			String qq,Integer settleType,Integer state,Long rankId,String rankName,String agencyAccount,Long partitionCount){
		this.setId(id);
		this.setAccount(account);
		this.setJoinDate(joinDate);
		this.setNickname(nickname);
		this.setQqNumber(qq);
		this.setType(type);
		this.setSettlementType(settleType);
		this.setRankName(rankName);
		this.setRankId(rankId);
		this.setFinalDate(finalDate);
		this.setState(state);
		this.agencyAccount = agencyAccount;
		this.partitionCount = partitionCount;
	}
	
	public Result newPassword(String password, String uuid) {
		setPassword(new Md5Hash(getPassword(), uuid).toHex());
		if (!getPassword().equals(password))
			return Result.error("旧密码输入错误，请重新输入", "password");
		
		if (!nPassword.equals(cPassword))
			return Result.error("两次密码输入不一致，请重新输入", "cPassword");
		
		this.nPassword = new Md5Hash(this.nPassword, uuid).toHex();
		return Result.success("校验成功");
	}

	public Long getMerchantCount() {
		return merchantCount;
	}

	public void setMerchantCount(Long merchantCount) {
		this.merchantCount = merchantCount;
	}

	public String getnPassword() {
		return nPassword;
	}

	public void setnPassword(String nPassword) {
		this.nPassword = nPassword;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public Long getPartitionCount() {
		return partitionCount;
	}

	public void setPartitionCount(Long partitionCount) {
		this.partitionCount = partitionCount;
	}

	public String getAgencyAccount() {
		return agencyAccount;
	}

	public void setAgencyAccount(String agencyAccount) {
		this.agencyAccount = agencyAccount;
	}
	
}
