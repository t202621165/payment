package com.cypay.common.to;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class Login {
	
	private boolean encrypt = true;
	
	public abstract String getAccount();
	
	public abstract String getPassword();
	
	public abstract String getSalt();
	
	/**
	 * 是否被禁用
	 * @return
	 */
	public boolean isUnusable() {
		return false;
	}
	/**
	 * 是否正在审核中
	 * @return
	 */
	public boolean isInAudit() {
		return false;
	}

	public boolean isEncrypt() {
		return encrypt;
	}

	public Login setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
		return this;
	}
	
	@JSONField(serialize = false)
	public String getRealm() {
		return this.getClass().getSimpleName();
	}
}
