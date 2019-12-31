package com.cypay.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 商户绑定微信信息
 * @author International
 * @2019年3月16日 下午5:21:38
 */
@Entity
@Table(name = "cy_wechat_info")
public class WechatInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**微信绑定时间*/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	private Date joinDate = new Date();
	
	@Column(nullable = false)
	private Long merchantId;
	
	/**微信唯一标识*/
	@Column(nullable = false)
	private String openid;
	
	/**微信昵称*/
	private String nickname;
	
	private Boolean sex;
	
	private String country;
	
	private String province;
	
	private String city;
	
	/**微信头像url*/
	private String headimgurl;
	
	/**接口调用凭证*/
	@Column(nullable = false)
	private String accessToken;
	
	/**用户刷新access_token*/
	@Column(nullable = false)
	private String refreshToken;
	
	/**access_token有效时间，单位（秒）*/
	private Integer expiresIn;
	
	/**将公众号绑定到微信开放平台帐号后，才会出现该字段*/
	private String unionid = "";

	public WechatInfo() {
		
	}
	
	public WechatInfo(Long id, Long merchantId) {
		this.id = id;
		this.merchantId = merchantId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Override
	public String toString() {
		return "WechatInfo [id=" + id + ", joinDate=" + joinDate + ", merchantId=" + merchantId + ", openid=" + openid
				+ ", nickname=" + nickname + ", sex=" + sex + ", country=" + country + ", province=" + province
				+ ", city=" + city + ", headimgurl=" + headimgurl + ", accessToken=" + accessToken + ", refreshToken="
				+ refreshToken + ", expiresIn=" + expiresIn + ", unionid=" + unionid + ", getId()=" + getId()
				+ ", getJoinDate()=" + getJoinDate() + ", getMerchantId()=" + getMerchantId() + ", getOpenid()="
				+ getOpenid() + ", getNickname()=" + getNickname() + ", getSex()=" + getSex() + ", getCountry()="
				+ getCountry() + ", getProvince()=" + getProvince() + ", getCity()=" + getCity() + ", getHeadimgurl()="
				+ getHeadimgurl() + ", getAccessToken()=" + getAccessToken() + ", getRefreshToken()="
				+ getRefreshToken() + ", getExpiresIn()=" + getExpiresIn() + ", getUnionid()=" + getUnionid()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
