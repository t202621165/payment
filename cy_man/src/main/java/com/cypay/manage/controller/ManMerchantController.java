package com.cypay.manage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.service.impl.BankService;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.WechatInfoService;
import com.cypay.common.to.SettlementBank;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.MerchantVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping("/man")
public class ManMerchantController {
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private BankService bankService;
	@Autowired
	private LineService lineService;
	@Autowired
	private SystemSetService systemSetService;
	@Autowired
	private WechatInfoService wechatInfoService;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 商户列表
	 * 
	 * @param v
	 * @param pageData
	 * @return
	 */
	@GetMapping("/merchant/list")
	public Page<?> page(MerchantVo v, PageData pageData) {
		return merchantService.findVoPageList(v, pageData);
	}

	/**
	 * 商户编辑
	 * 
	 * @param m
	 * @return
	 */
	@PostMapping("/merchant/update")
	public Result merUpdate(@Valid Merchant m) {
		return merchantService.merUpdate(m);
	}

	/**
	 * 账户 冻结/解冻
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/bank/frozen")
	public Result frozen(@RequestParam(value = "id") Long id) {
		return bankService.frozen(id);
	}

	/**
	 * 账户银行卡更新
	 * @param v
	 * @return
	 */
	@PostMapping("/bank/update")
	public Result bank_update(@Valid Bank v){
		Bank bank = bankService.findById(v.getId());
		String settlementBanks = systemSetService.findSettlementBankByMark();
		List<SettlementBank> list = JSONObject.parseArray(settlementBanks, SettlementBank.class);
		if(!StringUtils.isEmpty(bank)){
			bank.setRealName(v.getRealName());
			bank.setBankName(v.getBankName());
			bank.setBankBranch(v.getBankBranch());
			bank.setBankNumber(v.getBankNumber());
			bank.setBankMark(list.stream().filter(l -> l.getName().equals(v.getBankName())).findFirst().get().getMark());
			bankService.update(bank);
		}else{
			return Result.error("银行卡不存在,更新失败");
		}
		return Result.success("银行卡更新成功");
	}

	/**
	 * 密码重置
	 * 
	 * @return
	 */
	@GetMapping("/password/reset")
	public Result reset_password(@RequestParam(value = "id") Long id) {
		Merchant merchant = merchantService.findById(id);
		String salt = merchant.getUuid();
		merchant.setPassword(new Md5Hash("000000", salt).toHex());
		try {
			merchantService.update(merchant);
			return Result.success("密码重置成功！重置后密码:000000");
		} catch (Exception e) {
			logger.info(e.getMessage());
			return Result.error("密码重置失败");
		}
	}

	@GetMapping("/merchant/del")
	public Result del(@RequestParam(value = "id") Long id) {
		return merchantService.deleteById(id);
	}

	@PostMapping("/merchant/state")
	public Result state(@RequestParam(value = "id") Long id) {
		return merchantService.updateState(id);
	}

	@GetMapping("/go")
	public Result go(@RequestParam(value = "id") Long id, HttpServletRequest request) throws IOException {
		Merchant merchant = merchantService.findById(id);
		List<Line> lines = lineService.findByType(1);
		if (lines == null || lines.isEmpty()) {
			return Result.error("请前往配置商户登录域名！");
		}
		Line line = lines.get(0);
		String sign = MD5Util.signToLowerCase(
				String.format("%s@%s", id,
						merchant.getFinalDate() == null ? "1546272000000" : merchant.getFinalDate().getTime()),
				"", "UTF-8");
		return Result
				.success(CommonUtil.getBufferString(CommonUtil.getWholeDomainName(line.getDomainName(), line.getPort()),
						"/mer/tomerchant?id=", id, "&sign=", sign));
	}

	@GetMapping("/unbind")
	public Result unbind(@RequestParam(value = "id") Long id) {
		return wechatInfoService.deleteById(id);
	}

	/**
	 * 日期格式自动转换
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
