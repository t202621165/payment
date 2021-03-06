package com.cypay.manage.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.DaiFu;
import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Notice;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.RankRate;
import com.cypay.common.entity.Role;
import com.cypay.common.entity.User;
import com.cypay.common.entity.WechatInfo;
import com.cypay.common.enums.Edition;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.service.impl.BankService;
import com.cypay.common.service.impl.GalleryRateService;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.LogService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.NoticeService;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.RankRateService;
import com.cypay.common.service.impl.RankService;
import com.cypay.common.service.impl.RoleService;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.UserService;
import com.cypay.common.service.impl.WechatInfoService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.to.Support;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.GalleryRateVo;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.ProductVo;
import com.cypay.common.vo.SettleMentReplyVo;
import com.cypay.common.vo.SettleMentVo;

import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping(value = "man")
public class ViewController {
	@Autowired
	private SystemSetService systemSetService;
	@Autowired
	private BankService bankService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RankService rankService;
	@Autowired
	private RankRateService rankRateService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private SettleMentService settleMentService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private GalleryRateService galleryRateService;
	@Autowired
	private LogService logService;
	@Autowired
	private InitialLoader initialLoader;
	@Autowired
	private LineService lineService;
	@Autowired
	private WechatInfoService wechatInfoService;

	@Value("${com.payment.mark}")
	private String mark;

	/**
	 * 登陆界面
	 * 
	 * @return
	 */
	@GetMapping(value = { "/", "/login" })
	public String login(HttpServletRequest request) {
		try {
			Integer type = initialLoader.getTypeByDomain(request);
			if (type != null && type == 2) {
				if (ShiroManager.isLogin(User.class))
					return "redirect:/man/index";
				return "manage/login/login";
			}
			return "manage/line";
		} catch (Exception e) {
			return "manage/line";
		}

	}

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("user", ShiroManager.getUser());
		model.addAttribute("role", roleService.findRoleMarkByUserId(ShiroManager.getUser().getId()));
		model.addAttribute("webInfo", systemSetService.findWebInfo());
		model.addAttribute("time", Edition.current_edition.getExpiration_date());
		return "manage/index/index";
	}

	/**
	 * 首页主界面
	 * 
	 * @return
	 */
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("log", logService.findLastLoginByUser(ShiroManager.getUser().getId()));
		model.addAttribute("role", roleService.findRoleMarkByUserId(ShiroManager.getUser().getId()));
		model.addAttribute("order", orderService.findOrderSummary());
		return "manage/index/main";
	}

	/**
	 * 修改密码界面
	 * 
	 * @return
	 */
	@GetMapping("/password")
	public String password(@RequestParam(value = "id") Long id, Model model) {
		if (id == -1) {
			model.addAttribute("id", ShiroManager.getUser().getId());
		} else {
			model.addAttribute("id", id);
		}
		return "manage/system/user/password";
	}

	/**
	 * 商户列表界面
	 * 
	 * @return
	 */
	@GetMapping("/merchant")
	public String merchant_list(Model model, @RequestParam(value = "type") Boolean type) {
		model.addAttribute("rank", rankService.findAllByIdAndName());
		model.addAttribute("type", type);
		return "manage/merchant/list";
	}

	/**
	 * 公告列表
	 * 
	 * @return
	 */
	@GetMapping("/notice")
	public String notice_list() {
		return "manage/notice/list";
	}

	/**
	 * 公告发布框
	 * 
	 * @return
	 */
	@GetMapping("/notice/opration/ui")
	public String notice_ui(Notice v, Model model) {
		if (!StringUtils.isEmpty(v.getId())) {
			v = noticeService.findById(v.getId());
			model.addAttribute("flag", true);
		} else {
			model.addAttribute("flag", false);
		}
		model.addAttribute("notice", v);
		return "manage/notice/notice";
	}

	/**
	 * 商户编辑界面
	 * 
	 * @return
	 */
	@GetMapping("/merchant/edit")
	public String merchant_edit(@RequestParam(value = "param") Long merchantId, Model model) {
		Merchant merchant = merchantService.findById(merchantId);
		Bank bank = bankService.findByMerchantId(merchantId);
		if (!StringUtils.isEmpty(merchant.getParent())) {
			merchant.setParentId(merchant.getParent().getId());
		}
		WechatInfo wechatInfo = wechatInfoService.findByMerchantId(merchantId);
		model.addAttribute("merchant", merchant);
		model.addAttribute("bank", bank);
		model.addAttribute("rank", rankService.findAllByIdAndName());
		model.addAttribute("wechatInfo", wechatInfo);
		return "manage/merchant/detail";
	}

	/**
	 * 商户银行卡页面
	 * 
	 * @return
	 */
	@GetMapping("/merchant/bank")
	public String merchant_bank(Bank bank, Model model) {
		String banks = systemSetService.findSettlementBankByMark(mark);
		model.addAttribute("bank", bank);
		model.addAttribute("banks", JSON.parseArray(banks));
		return "manage/merchant/bank";
	}

	/**
	 * 系统配置界面
	 * 
	 * @return
	 */
	@GetMapping("/system/set")
	public String systemSet(Model model) {
		model.addAttribute("system", systemSetService.getSystemSet().parse());
		return "manage/system/set";
	}

	/**
	 * 代付配置界面
	 * 
	 * @return
	 */
	@GetMapping("/daifu")
	public String daifuSet() {
		return "manage/system/daifu/list";
	}

	/**
	 * 订单列表界面
	 * 
	 * @return
	 */
	@GetMapping("/order")
	public String order_list(OrderVo v,Model model) {
		model.addAttribute("role", roleService.findRoleMarkByUserId(ShiroManager.getUser().getId()));
		if (v.getIsAgency()) {
			return "manage/order/agency";
		}
		return "manage/order/list";
	}

	/**
	 * 订单详情界面
	 * 
	 * @return
	 */
	@GetMapping(value = "/order/detail")
	public String order_detail(@RequestParam(value = "orderNumber") String orderNumber, Model model) {
		model.addAttribute("order", orderService.findDetail(orderNumber));
		return "manage/order/detail";
	}

	/**
	 * 资金列表界面
	 * 
	 * @return
	 */
	@GetMapping("/funds")
	public String funds() {
		return "manage/funds/funds";
	}

	/**
	 * 通道资金详情界面
	 * 
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/funds/gallery")
	public String funds_gallery(HttpServletRequest request, Model model) throws ParseException {
		Long merchantId = Long.valueOf(request.getParameter("merchantId"));
		List<SettleMentVo> galleryFunds = settleMentService.findGalleryFunds(merchantId);
		model.addAttribute("galleryFunds", galleryFunds);
		return "manage/funds/product";
	}

	/**
	 * T+1界面
	 * 
	 * @return
	 */
	@GetMapping("/t1")
	public String t1(Model model) {
		Bank bank = bankService.findSumOverMoney(1);
		model.addAttribute("flag", true);
		model.addAttribute("totalOverMoney", bank == null ? 0.00 : bank.getOverMoney());
		return "manage/funds/t";
	}

	/**
	 * T+0界面
	 * 
	 * @return
	 */
	@GetMapping("/t0")
	public String t0(Model model) {
		Bank bank = bankService.findSumOverMoney(0);
		model.addAttribute("flag", false);
		model.addAttribute("totalOverMoney", bank == null ? 0.00 : bank.getOverMoney());
		return "manage/funds/t";
	}

	/**
	 * 提现业务界面
	 * 
	 * @return
	 */
	@GetMapping("/payment")
	public String payment(Model model,@RequestParam(value="state") Integer state) {
		model.addAttribute("state", state);
		return "manage/funds/payment";
	}

	/**
	 * 批复记录
	 * 
	 * @return
	 */
	@GetMapping("/reply")
	public String reply() {
		return "manage/funds/reply";
	}

	/**
	 * 批复详情
	 * 
	 * @return
	 */
	@GetMapping("/reply/detail")
	public String reply_detail(SettleMentReplyVo v, Model model) {
		model.addAttribute("serialNumber", v.getSerialNumber());
		return "manage/funds/detail";
	}

	/**
	 * 游戏管理分组列表
	 * 
	 * @return
	 */
	@GetMapping("/group")
	public String group_list(Model model) {
		List<Line> list = lineService.findByType(0);
		String line = "";
		if (list != null && !list.isEmpty())
			line = CommonUtil.getWholeDomainName(list.get(0).getDomainName(), list.get(0).getPort());
		model.addAttribute("line", line);
		return "manage/game/group/list";
	}

	@GetMapping("/group/partiton")
	public String group_partiton() {
		return "manage/game/group/partition";
	}

	/**
	 * 游戏管理分区列表
	 * 
	 * @return
	 */
	@GetMapping("/partition")
	public String partition_list(Model model) {
		List<Line> list = lineService.findByType(0);
		String line = "";
		if (list != null && !list.isEmpty())
			line = CommonUtil.getWholeDomainName(list.get(0).getDomainName(), list.get(0).getPort());
		model.addAttribute("line", line);
		return "manage/game/partition/list";
	}

	/**
	 * 产品列表界面
	 * 
	 * @return
	 */
	@GetMapping("/product")
	public String product_list(Model model) {
		return "manage/gate/product/list";
	}

	/**
	 * 添加/编辑产品界面
	 * 
	 * @return
	 */
	@GetMapping("/product/opration/ui")
	public String product_add(Model model, ProductVo v) {
		if (StrUtil.isBlank(v.getTypeMark())) {
			v.setTypeMark("alipay");
		}
		model.addAttribute("product", v);
		return "manage/gate/product/product";
	}

	/**
	 * 通道列表界面
	 * 
	 * @return
	 */
	@GetMapping("/gallery")
	public String gallery_list(Model model) {
		List<Gallery> list = PaymentType.oAuthGallery();
		model.addAttribute("gallerys", CommonUtil.listToTableFormat(4, list));
		return "manage/gate/gallery/list";
	}

	@GetMapping("/gallery/rate/ui")
	public String galleryRate(Gallery g, Model model) {
		Support support = PaymentType.getSupportByMark(g.getMark());
		if (support != null) {
			List<GalleryRateVo> rates = new ArrayList<>();
			for (GalleryRateVo gr : galleryRateService.findRateByGalleryId(g.getId())) {
				if (support.getTypes().contains(gr.getTypeMark())) {
					rates.add(gr);
				}
			}
			model.addAttribute("gallery", g);
			model.addAttribute("rates", CommonUtil.listToTableFormat(3, rates));
		}
		return "manage/gate/gallery/rate";
	}

	/**
	 * 添加/编辑通道界面
	 * 
	 * @return
	 */
	@GetMapping("/gallery/opration/ui")
	public String gallery_add(Gallery g, Model model) {
		return "manage/gate/gallery/gallery";
	}

	/**
	 * 费率列表界面
	 * 
	 * @return
	 */
	@GetMapping("/rate")
	public String rate_list() {
		return "manage/system/rate/list";
	}

	/**
	 * 添加/编辑费率界面
	 * 
	 * @return
	 */
	@GetMapping("/rate/opration/ui")
	public String rate_add(Rank rank, Model model) {
		List<RankRate> rates = rankRateService.findRankRateByRankId(rank.getId());
		model.addAttribute("rank", rank);
		model.addAttribute("rates", CommonUtil.listToTableFormat(4, rates));
		return "manage/system/rate/rate";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	@GetMapping("/user")
	public String user_list() {
		return "manage/system/user/list";
	}

	@GetMapping("/user/opration/ui")
	public String user_ui(User user, Model model) {
		if (!StringUtils.isEmpty(user.getId())) {
			model.addAttribute("flag", true);
			model.addAttribute("user", userService.findById(user.getId()));
		} else {
			model.addAttribute("flag", false);
		}
		return "manage/system/user/save";
	}

	@GetMapping("/daifu/opration/ui")
	public String daifu_ui(DaiFu daifu, Model model) {
		if (daifu.getId() != null) {
			model.addAttribute("flag", true);
		} else {
			daifu.setMark("alipay");
			model.addAttribute("flag", false);
		}
		model.addAttribute("daifu", daifu);
		return "manage/system/daifu/save";
	}

	/**
	 * 角色列表
	 * 
	 * @return
	 */
	@GetMapping("/role")
	public String role_list() {
		return "manage/system/role/list";
	}

	@GetMapping("/role/opration/ui")
	public String role_ui(Role role, Model model) {
		if (!StringUtils.isEmpty(role.getId())) {
			model.addAttribute("flag", true);
			model.addAttribute("role", roleService.findById(role.getId()));
		} else {
			model.addAttribute("flag", false);
		}
		return "manage/system/role/save";
	}

	/**
	 * 登录日志列表
	 * 
	 * @return
	 */
	@GetMapping("/log")
	public String log_list() {
		return "manage/log/list";
	}
	
	/**
	 * 系统日志列表
	 * 
	 * @return
	 */
	@GetMapping("/syslog")
	public String log() {
		return "manage/log/log";
	}

	@GetMapping("/statistics/{flag}")
	public String statistics__ui(@PathVariable(value = "flag") String flag, Model model) {
		model.addAttribute("flag", flag);
		if (flag.equals("merchant") || flag.equals("agency")) {
			return "manage/statistics/merchant";
		} else if (flag.equals("partition")) {
			return "manage/statistics/partition";
		} else {
			return null;
		}
	}

	/**
	 * 资源上传
	 * 
	 * @return
	 */
	@GetMapping("/system/upload")
	public String upload(Model model) {
		return "manage/system/upload";
	}

	/**
	 * 域名设置
	 * 
	 * @return
	 */
	@GetMapping("/domain/set")
	public String domain(Model model) {
		model.addAllAttributes(lineService.findAll().parallelStream().collect(Collectors.groupingBy(Line::typeKey)));
		return "manage/system/domain/domain";
	}

	/**
	 * 退出登录
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/logout")
	public String logout() {
		ShiroManager.logout();
		return "redirect:/";
	}

	@GetMapping(value = "/test")
	public String test() {
		return "manage/test";
	}
}
