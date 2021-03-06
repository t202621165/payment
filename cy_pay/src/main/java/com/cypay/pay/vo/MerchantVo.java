package com.cypay.pay.vo;

import org.springframework.util.StringUtils;

import com.cypay.common.entity.Merchant;

public class MerchantVo extends Merchant {

	private static final long serialVersionUID = 1L;
	
	public MerchantVo(Boolean phoneState, String servicePhone, String serviceQQ, Boolean serviceState, Boolean leaveState) {
		setPhoneState(phoneState);
		setServicePhone(servicePhone);
		setServiceQQ(serviceQQ);
		serviceState = (StringUtils.isEmpty(servicePhone) 
				&& StringUtils.isEmpty(serviceQQ))?false:serviceState;
		setServiceState(serviceState);
		setLeaveState(leaveState);
	}

}
