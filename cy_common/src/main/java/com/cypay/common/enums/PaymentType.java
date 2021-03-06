package com.cypay.common.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Gallery;
import com.cypay.common.to.Support;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

/**
 * -接口类型-
 * 
 * @author International
 * @2019年1月10日 下午4:16:47
 */
public enum PaymentType {

	IWANOL("爱玩", Boolean.TRUE, s -> {s.alipay().wechat().qpay().hbpay().tenpay().ebank().union();}),

	ALIPAY("官方支付宝", Boolean.TRUE, s -> {s.alipay().hbpay();}),

	WECHAT("官方微信", Boolean.TRUE, s -> {s.wechat();}),

	QPAY("QQ钱包", Boolean.TRUE, s -> {s.qpay();}),

	TENPAY("财付通", "GBK", Boolean.TRUE, s -> {s.tenpay();}),

	PAY_15173("15173", "GB2312", Boolean.TRUE, s -> {s.alipay().wechat();}),

	/*******************************************************/

	LSUPAY("零速付", "GB2312", s -> {s.alipay().wechat().qpay().tenpay().ebank();}),
	
	LONGPAY("龙宝支付", "GB2312", s -> {s.alipay().wechat().tenpay().ebank();}),
	
	ILONGPAY("龙付支付", "GB2312", s -> {s.alipay().wechat().qpay().tenpay().hbpay().ebank();}),
	
	PAY_186UE("优易数卡", s -> {s.alipay().wechat().qpay().tenpay().hbpay().ebank();}),
	
	PAY_7UKA("优卡联盟", "GB2312", s -> {s.alipay().wechat().qpay().tenpay().ebank();}),
	
	YIAIPAY("易爱支付", "GB2312", s -> {s.alipay().wechat().hbpay().tenpay().ebank();}),
	
	YEEPAY("易宝支付", s -> {s.ebank();}),
	
	ZFY("支付云", s -> {s.alipay().wechat().qpay().hbpay().ebank().union();}),
	
	ZLYF("智联易付", s -> {s.alipay().wechat().qpay().jingdong();}),
	
	DLB("哆啦宝", s -> {s.alipay().wechat();}),
	
	MJH("码聚合", s -> {s.alipay().wechat().qpay().union().jingdong();}),
	
	LINGPAO("领跑支付", s -> {s.alipay().wechat().tenpay();}),
	
	JIABEI("嘉贝", s -> {s.alipay().wechat().qpay().ebank().union();}),
	
	KUNDIU("520","GB2312", s -> {s.alipay().wechat().hbpay().ebank();}),
	
	SHANHAI(Boolean.FALSE, "山海", s -> {s.alipay().wechat().hbpay();}),
	
	XINRUI("新瑞支付", s -> {s.alipay().wechat();}),

	KBPAY("口碑支付", s -> {s.alipay().wechat().qpay().ebank();}),
	
	WOJIBAO("沃基宝","GB2312",s -> {s.alipay().wechat();}),
	
	HUILIAN("汇联",s -> {s.alipay().wechat().hbpay();}),
	
	MILABAO(Boolean.FALSE,"咪啦宝",s -> {s.alipay().wechat().qpay();}),
	
	TONGFU("通付",s -> {s.alipay().wechat().ebank().union();}),
	
	QUANHAI("全海",s -> {s.alipay().wechat().ebank().hbpay();}),
	
	QIANTAI(Boolean.FALSE,"钱台",s -> {s.alipay().wechat();}),
	
	WANXIANG("万象",s -> {s.alipay().wechat().tenpay().ebank().hbpay();}),
	
	YINLIAN("银联商务", s -> {s.alipay().wechat().union();}),
	
	BBPAY("BBPay", s -> {s.alipay().wechat().qpay().tenpay().ebank();}),
	
	PAY_369("369Pay", s -> {s.alipay().wechat().qpay().tenpay().ebank();});
	
	/**通道名称*/
	private String name;
	
	private String charset = "UTF-8";
	
	/**通道支持业务*/
	private Support support = new Support();
	
	/** 
	 * 签名方式
	 * <pre>
	 * 0: MD5、SHA等哈希/摘要算法 1：RSA等非对称加密算法
	 *  </pre>
	 */
	private Integer signType = 0;
	
	/**
	 * 是否为开放通道
	 */
	private Boolean isOpen = Boolean.FALSE;
	
	/** 
	 * 是否为统一支付 
	 * <pre>
	 * 非统一支付：接口标识 = 通道标识 + _ + 产品类型标识
	 * 山海微信：shanhai + _ + wechat = shanhai_wechat
	 *  </pre>
	 * */
	private Boolean isUnified = Boolean.TRUE;
	
	private Boolean isSupportRiskAmount = Boolean.FALSE;
	
	private PaymentType(String name, Consumer<Support> consumer) {
		this.name = name;
		consumer.accept(this.support);
	}
	
	private PaymentType(String name, Boolean isOpen, Consumer<Support> consumer) {
		this(name, consumer);
		this.isOpen = isOpen;
	}
	
	private PaymentType(Boolean isUnified, String name, Consumer<Support> consumer) {
		this(name, consumer);
		this.isUnified = isUnified;
	}
	
	private PaymentType(String name, String charset, Consumer<Support> consumer) {
		this(name, consumer);
		this.charset = charset;
	}
	
	private PaymentType(String name, String charset, Boolean isOpen, Consumer<Support> consumer) {
		this(name, charset, consumer);
		this.isOpen = isOpen;
	}
	
	/**
	 * 获取已开放的通道标识
	 * @return
	 */
	public static List<String> openGalleryMark() {
		return Arrays.asList(PaymentType.values()).parallelStream().filter(pt -> pt.isOpen)
				.map(PaymentType::type).collect(Collectors.toList());
	}
	
	/**
	 * 获取未开放的通道标识
	 * @return
	 */
	public static List<String> notOpenGalleryMark() {
		return Arrays.asList(PaymentType.values()).parallelStream().filter(pt -> !pt.isOpen)
				.map(PaymentType::type).collect(Collectors.toList());
	}
	
	/**
	 * 获取所有通道的通道标识
	 * @return
	 */
	public static List<String> allGalleryMark(boolean isSupportRiskAmount) {
		return Arrays.asList(PaymentType.values()).parallelStream().map((p) -> {
			p.setIsSupportRiskAmount(isSupportRiskAmount);
			return p.type();
		}).collect(Collectors.toList());
	}
	
	/**
	 * 获取动态授权的通道标识
	 */
	public static Set<String> dynamicAuthorMark(List<Integer> indexs, boolean allGallery) {
		List<String> allMark = allGallery ? allGalleryMark(false) : notOpenGalleryMark();
		Set<String> marks = new HashSet<>();
		if (CollUtil.isNotEmpty(indexs)) {
			for (Integer index : indexs) {
				try {
					boolean isSupportRiskAmount = index < 0;
					int i = allGallery ? Math.abs(index) - 1 : index;
					String mark = allMark.get(i);
					PaymentType pt = getPaymentTypeByMark(mark);
					if (pt != null) {
						pt.setIsSupportRiskAmount(isSupportRiskAmount);
					}
					marks.add(mark);
				} catch (Exception e) {} // 不处理异常，防止索引越界
			}
		}
		return marks;
	}
	
	/**
	 * 获取所有开放通道
	 * @return
	 */
	public static List<Gallery> openGallery() {
		return Arrays.asList(PaymentType.values()).parallelStream().filter(pt -> pt.isOpen)
				.map(pt -> pt.createGallery()).collect(Collectors.toList());
	}
	
	/**
	 * 获取已授权通道(包含开放通道)
	 * @return
	 */
	public static List<Gallery> oAuthGallery() {
		return Arrays.asList(PaymentType.values()).parallelStream().filter(
				pt -> InitialLoader.USABLE_GALLERY.contains(pt.type())).map(
						pt -> pt.createGallery()).collect(Collectors.toList());
	}
	
	/**
	 * 根据通道标识创建通道
	 * @param mark 通道标识
	 * @return
	 */
	public static Gallery getByMark(String mark) {
		if (StrUtil.isNotBlank(mark)) {
			return getPaymentTypeByMark(mark).createGallery();
		}
		return null;
	}
	
	/**
	 * 根据通道标识获取当前通道支持的支付方式
	 * @param mark 通道标识
	 * @return
	 */
	public static Support getSupportByMark(String mark) {
		if (StrUtil.isNotBlank(mark)) {
			PaymentType payment = getPaymentTypeByMark(mark);
			if (payment != null) {
				return payment.support;
			}
		}
		return Support.DEFAULT;
	}
	
	/**
	 * 根据通道标识判断是否是统一支付
	 * @param mark 通道标识
	 * @return
	 */
	public static Boolean getIsUnified(String mark) {
		if (StrUtil.isNotBlank(mark)) {
			return getPaymentTypeByMark(mark).isUnified;
		}
		return false;
	}
	
	/**
	 * 判断通道mark是否支持产品productMark
	 * @param mark 通道标识
	 * @param productMark 产品标识
	 * @return
	 */
	public static boolean isSupport(String mark, String productMark) {
		return getSupportByMark(mark).support(productMark);
	}
	
	public static PaymentType getPaymentTypeByMark(String mark) {
		return InitialLoader.PAYMENT_ENUMS.get(mark.toUpperCase());
	}
	
	public static void loadGallery(Gallery gallery) {
		PaymentType p = getPaymentTypeByMark(gallery.getMark());
		gallery.setRealName(p.getName());
		gallery.setSignType(p.getSignType());
		gallery.setSupport(p.getSupport());
		gallery.setIsUnified(p.getIsUnified());
		gallery.setIsSupportRiskAmount(p.getIsSupportRiskAmount());
	}
	
	private Gallery createGallery() {
		return new Gallery(name, type(), isUnified);
	}

	public String type() {
		return this.toString().toLowerCase();
	}
	
	public String getName() {
		return this.name;
	}

	public Support getSupport() {
		return support;
	}

	public String getCharset() {
		return this.charset;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public Integer getSignType() {
		return signType;
	}

	public Boolean getIsUnified() {
		return isUnified;
	}

	public Boolean getIsSupportRiskAmount() {
		return isSupportRiskAmount;
	}

	public void setIsSupportRiskAmount(Boolean isSupportRiskAmount) {
		this.isSupportRiskAmount = isSupportRiskAmount;
	}
	
}
