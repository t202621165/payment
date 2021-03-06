package com.cypay.manage.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.Role;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.entity.User;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.RankService;
import com.cypay.common.service.impl.RoleService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.UserService;
import com.cypay.common.service.impl.VisitService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.FileUtil;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.RankVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value = "/man")
public class SystemController {
	@Autowired
	private SystemSetService systemSetService;
	@Autowired
	private RankService rankService;
	@Autowired
	private LineService lineService;
	@Autowired
	private UserService userServicel;
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 级别列表
	 * @param pageData
	 * @param rank
	 * @return
	 */
	@GetMapping("/rank/list")
	public Page<RankVo> ranks(PageData pageData,RankVo rank){
		return rankService.findRankAndMerchantCount(pageData);
	}
	
	/**
	 * 用户列表
	 * @param pageData
	 * @param user
	 * @return
	 */
	@GetMapping("/user/list")
	public Page<User> users(PageData pageData,User user){
		return userServicel.findAll(user, pageData);
	}
	
	/**
	 * 角色列表
	 * @param pageData
	 * @param role
	 * @return
	 */
	@GetMapping("/role/list")
	public Page<Role> roles(PageData pageData,Role role){
		return roleService.findAll(role, pageData);
	}
	
	/**
	 * 保存费率级别
	 * @param productId
	 * @param rate
	 * @param rank
	 * @return
	 */
	@PostMapping("/rate/save")
	public Result rateSave(Rank rank) {
		rank.getRates().forEach(r -> {
			r.setRank(rank);
			rank.getRankRates().add(r);
		});
		rankService.save(rank);
		return Result.success();
	}
	
	/**
	 * 域名集合
	 * @return
	 */
	@GetMapping("/sys/line")
	public Map<String, List<Line>> lines(){
		return lineService.findAll().parallelStream().collect(Collectors.groupingBy(Line::typeKey));
	}

	/**
	 * 移除线路
	 * @param line
	 * @return
	 */
	@DeleteMapping("/remove/line")
	@Caching(evict = {
			@CacheEvict(key="'line_list'",cacheNames = "line_all"),
			@CacheEvict(key="'line_map'",cacheNames = "line_all")
	})
	public Result removeLine(Line line) {
		return lineService.deleteById(line.getId());
	}
	
	/**
	 * 设置默认线路
	 * @param id
	 * @param type
	 * @return
	 */
	@PostMapping("/line/default")
	@CacheEvict(key="'line_list'",cacheNames = "line_all")
	public Result defaultLine(@RequestParam(value="id") Long id,@RequestParam(value="type") Integer type){
		return lineService.lineDefault(id,type);
	}

	/**
	 * 保存线路
	 * @param line
	 * @return
	 */
	@PostMapping("/save/line")
	@Caching(evict = {
			@CacheEvict(key="'line_list'",cacheNames = "line_all"),
			@CacheEvict(key="'line_map'",cacheNames = "line_all")
	})
	public Result saveLine(@Valid Line line) {
		return lineService.save(line);
	}
	
	@PostMapping("/line/test")
	public Object testLine(@Valid Line line) {
		try {
			String url = CommonUtil.getWholeDomainName(line.getDomainName(), line.getPort()) + "/test-line";
			return restTemplate.postForObject(url, null, JSONObject.class);
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}

	/**
	 * 更新系统设置
	 * @param systemSet
	 * @return
	 */
	@PostMapping("/update/sys")
	@Caching(evict = {
			@CacheEvict(key="'webInfo'",cacheNames = "web_info"),
			@CacheEvict(key="'gameEngine'",cacheNames = "payment")
	})
	public Result updateSys(SystemSet systemSet) {
		return systemSetService.updateSysSet(systemSet.parseToJsonStr());
	}
	
	/**
	 * 设置默认级别
	 * @param rank
	 * @return
	 */
	@PutMapping("/update/rank/default")
	public Result def(Rank rank){
		return rankService.updateIsDefault(rank.getId(),false);
	}
	
	/**
	 * 设置用户状态
	 * @param user
	 * @return
	 */
	@PutMapping("/user/state")
	public Result userState(User user){
		return userServicel.updateState(user.getId());
	}
	
	/**
	 * 设置角色状态
	 * @param role
	 * @return
	 */
	@PutMapping("/role/state")
	public Result roleState(Role role){
		return roleService.updateState(role.getId());
	}
	
	/**
	 * 更新ips状态
	 * @param flag
	 * @param state
	 * @return
	 */
	@PostMapping("/update/{flag}")
	public Result ipsLogin(@PathVariable(value="flag") String flag,@RequestParam(value="data") Boolean state){
		return systemSetService.updateIpsLogin(flag, state);
	}
	
	/**
	 * 
	 * @param state 尾额状态
	 * @return
	 */
	@PostMapping("/update/isOpenTailAmount")
	public Result isOpenTailAmount(@RequestParam(value="data") Boolean state){
		return systemSetService.updateIsOpenTailAmount(state);
	}
	
	/**
	 * 更新流量统计时间间隔
	 * @param visitTime 时间间隔
	 * @return
	 */
	@PostMapping("/update/visitTime")
	public Result visitTime(@RequestParam(value = "data") Integer visitTime){
		return systemSetService.updateIntervalTime("visit", visitTime);
	}
	
	/**
	 * 更新游戏登陆统计时间间隔
	 * @param loginTime 时间间隔
	 * @return
	 */
	@PostMapping("/update/loginTime")
	public Result loginTime(@RequestParam(value = "data") Integer loginTime){
		return systemSetService.updateIntervalTime("login", loginTime);
	}
	
	/**
	 * 更新商户默认结算类型
	 * @param loginTime 时间间隔
	 * @return
	 */
	@PostMapping("/update/settlementType")
	public Result settlementType(@RequestParam(value = "data") Integer settlementType){
		return systemSetService.updateSettlementType(settlementType);
	}
	
	/**
	 * 更新注册状态
	 * @param loginTime 时间间隔
	 * @return
	 */
	@PostMapping("/update/registerState")
	public Result registerState(@RequestParam(value = "data") Integer registerState){
		return systemSetService.updateRegisterState(registerState);
	}
	
	/**
	 * 删除费率级别
	 * @param id
	 * @return
	 */
	@GetMapping("/rank/del")
	public Result rankDel(@RequestParam(value = "id") Long id){
		return rankService.deleteById(id);
	}
	
	/**
	 * 网关上传
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @throws Exception 
	 */
	@PostMapping("/upload/{flag}")
	public Result upload(@RequestParam(value="file") MultipartFile file,HttpServletRequest request,@PathVariable(value="flag") String flag) throws Exception {
        String fileName = file.getOriginalFilename(); //文件名字
        String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString();
        filePath = filePath.replace("file:/", "").trim();
        filePath = filePath.replace("/", "\\").trim();
        if (flag.equals("wg") || flag.equals("ty") || flag.equals("cq3")){
        	 Optional<SystemSet> optional = systemSetService.findSystemSetByMark();
         	if(optional.isPresent()){
         		SystemSet set = optional.get();
         		String version = "4.0.0";
         		if (flag.equals("wg"))
             		version = this.versionPlus(set.getVersion());
         		else if (flag.equals("ty"))
         			version = this.versionPlus(set.getTyVersion());
         		else
         			version = this.versionPlus(set.getCq3Version());       		
         		systemSetService.updateVersionByMark(version,flag); //更新系统设置
         		FileUtil.uploadFile(file.getBytes(),URLDecoder.decode(filePath,"utf-8") , fileName);
         		return Result.success("网关上传成功,当前网关版本"+version);
         	}
        }else if (flag.equals("cert")){
        	FileUtil.uploadFile(file.getBytes(),URLDecoder.decode(filePath,"utf-8") , fileName);
        	return Result.success("微信API安全证书上传成功!");
        }
       
		return Result.error("上传失败");
	}
	
	@GetMapping("/settlement/minAmount")
	public Result minAmount(@RequestParam(value = "flag") String flag){
		SystemSet sys = systemSetService.getSystemSet();
		BigDecimal minAmount = null;
		if (flag.equals("t1")){
			minAmount = sys.getT1MinAmount();
		}else{
			minAmount = sys.getT0MinAmount();
		}
		return Result.success("查询成功", minAmount);
	}
	
	/**
	 * 资源上传
	 * @param file
	 * @param request
	 * @return
	 */
	@PostMapping("/res/{type}")
	public Result res(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request,@PathVariable(value = "type") String type){
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString();
        filePath = filePath.replace("file:/", "").trim();
        filePath = filePath.replace("/", "\\").trim();
        filePath = filePath+"\\static\\assets\\images\\web";
		String fileName = file.getOriginalFilename();
		String msg = "上传成功";
		if(type.equals("lg")){
			fileName = "logo.png";
			msg = "上传网站logo成功";
		}else if(type.equals("lg_min")){
			fileName = "logo-min.png";
			msg = "上传网站小logo成功";
		}else if(type.equals("index")){
			fileName = "index_banner.jpg";
			msg = "首页横幅上传成功";
		}else if(type.equals("register")){
			fileName = "register_banner.jpg";
			msg = "注册页面横幅上传成功";
		}else if (type.equals("fee")){
			fileName = "fee_banner.jpg";
			msg = "资费页面横幅上传成功";
		}else if (type.equals("us")){
			fileName = "us_banner.jpg";
			msg = "联系我们页面横幅上传成功";
		}else if(type.equals("gzh")){
			fileName = "gzh_ewm.jpg";
			msg = "公众号二维码上传成功";
		}
		try{
			FileUtil.uploadFile(file.getBytes(), URLDecoder.decode(filePath,"utf-8"), fileName);
		}catch (Exception e) {
			return Result.error("上传失败");
		}
		return Result.success(msg);
	}
	
	/**
	 * 清理IPS统计
	 * @return
	 */
	@GetMapping("/ips/clear")
	public Result clearIps(){
		return visitService.clearIps(DUtil.offsetDay(-3));
	}
	
	@GetMapping("/ips/count")
	public Result ipsTotal(){
		return visitService.ipsTotal();
	}
	
	/**
	 * 版本累加算法
	 * 
	 * @param oldVersion 老版本号
	 * @return
	 */
	private String versionPlus(String oldVersion) {
		String sysVersionTmp = oldVersion.replaceAll("\\.", "");
		if (!NumberUtils.isNumber(sysVersionTmp)) {
			return oldVersion;
		}
		
		String sysVersionNum = String.valueOf(Integer.valueOf(sysVersionTmp)+1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sysVersionNum.length(); i++) {
			if (i == 0) {
				builder.append(sysVersionNum.charAt(i));
			} else {
				builder.append(".").append(sysVersionNum.charAt(i));
			}
		}
		return builder.toString();
	}
	
}
