package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.config.SystemAuthorize;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.entity.Token;
import com.cypay.common.enums.Edition;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.SystemSetRepository;
import com.cypay.common.repository.impl.TokenRepository;
import com.cypay.common.shiro.realm.MyModularRealmAuthenticator;
import com.cypay.common.to.GameEngine;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.vo.Result;

import cn.hutool.crypto.SecureUtil;
@Service
public class SystemSetService extends BaseServiceImpl<SystemSetRepository, SystemSet,SystemSet>{
	
	@Value("${com.payment.mark}")
	private String mark;
	
	@Value("${com.payment.ssid}")
	private String ssid;
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	private static final Map<String, String> SERVERS = new ConcurrentHashMap<>();
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private MyModularRealmAuthenticator myModularRealmAuthenticator;
	
	/**
	 * 系统授权信息验证
	 * @param request
	 * @return
	 */
	public boolean oAuth(HttpServletRequest request) {
		try {
			if (Edition.current_edition == Edition.DEFAULT) {
				//获取请求域名
				String domain = request.getServerName();
				String ip = SERVERS.get(domain);
				if (ip == null) {
					//根据域名获取IP
					InetAddress[] address = InetAddress.getAllByName(domain);
					ip = address[0].getHostAddress();
					
					int port = request.getServerPort();
					if (port != 80 && port != 443) {
						ip = ip + ":" + port;
					}
					SERVERS.put(domain, ip);
				}
				
				return this.token(ip, InitialLoader.token);
			} else {
				return Edition.current_edition.getExpiration_date() > DUtil.getNetworkTime("yyMMdd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean token(String ip, String token) {
		if (token.indexOf(".") == -1) {
			ip = dbUrl.split("\\?")[0];
		}
		boolean isValid = new SystemAuthorize().parse(ip, token);
		// 清空授权
		clearCachedAuthorizationInfo();
		return isValid;
	}
	
	/**
	 * 清空所有登陆用户的授权缓存
	 */
	private void clearCachedAuthorizationInfo() {
		myModularRealmAuthenticator.getCustomRealms().forEach(r -> {
			Cache<Object, AuthorizationInfo> cache = r.getAuthorizationCache();
			if (cache != null) {
				cache.clear();
			}
		});
	}
	
	public SystemSet getSystemSet(){
		return baseRepository.findAll().get(0);
	}
	
	public String findSettlementBankByMark(String mark){
		return baseRepository.findSettlementBankByMark(mark);
	}
	
	public String findSettlementBankByMark(){
		return baseRepository.findSettlementBankByMark(mark);
	}
	
	public Optional<Token> findTokenByMark(){
		return findTokenByMark(getMark());
	}
	
	public Optional<Token> findTokenByMark(String mark){
		return tokenRepository.findByMark(mark);
	}
	
	private String getMark() {
		return SecureUtil.md5(String.format("%s@iwanol@%s", ssid, dbUrl.split("\\?")[0]));
	}
	
	public String findVersionByMark(Integer type){
		if (type == 1 || type == 2)
			return baseRepository.findVersionByMark(mark);
		else if (type == 0)
			return baseRepository.findTyVersionByMark(mark);
		else
			return baseRepository.findCq3VersionByMark(mark);
	}
	
	public Boolean findIsOpenTailAmount(){
		return baseRepository.findIsOpenTailAmount(mark);
	}
	
	public Double findTailAmountScope(){
		return baseRepository.findTailAmountScope(mark);
	}
	
	public int findVisitTime(){
		return baseRepository.findVisitTimeByMark(mark);
	}
	
	public int findLoginTime(){
		return baseRepository.findLoginTimeByMark(mark);
	}
	
	public int findTailAmountRatio(){
		return baseRepository.findTailAmountRatio(mark);
	}
	
	public Map<String, Object> findIpsAndLoginState(){
		return baseRepository.findIpsAndLoginState(mark);
	}
	
	public BigDecimal findT1MinAmount() {
		return baseRepository.findT1MinAmount(mark);
	}

	public int updateTokenByMark(String token){
		try {
			String mark = getMark();
			Optional<Token> optional = findTokenByMark(mark);
			Token t = null;
			if (optional.isPresent()) {
				t = optional.get();
				t.setToken(token);
			} else {
				t = new Token(mark, token);
			}
			
			tokenRepository.save(t);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	public int updateVersionByMark(String version,String type){
		if (type.equals("wg"))
			return baseRepository.updateVersionByMark(version, mark);
		else if (type.equals("ty"))
			return baseRepository.updateTyVersionByMark(version,mark);
		else
			return baseRepository.updateCq3VersionByMark(version, mark);
	}
	
	public SystemSet findRegisterData(){
		return baseRepository.findRegisterData(mark);
	}
	
	public Result updateSysSet(SystemSet systemSet){
		try{
			baseRepository.save(systemSet);
			return Result.success("更新系统设置信息成功");
		}catch(Exception e){
			return Result.error("更新系统设置信息失败");
		}
	}
	
	@Transactional
	public Result updateIpsLogin(String flag,Boolean state){
		if(flag.equals("isIps")){
			int i = baseRepository.updateIsIps(state, mark);
			if ( i > 0 ){
				int j = merchantRepository.updateIsIps(state);
				if (j > 0)
					return Result.success("【已"+(state?"开启":"关闭")+"】IPS流量统计");
				else
					return Result.error("IPS流量统计状态更改失败");
			}
		}else{
			int i = baseRepository.updateIsLogin(state, mark);
			if ( i > 0 ){
				int j = merchantRepository.updateIsLogin(state);
				if (j > 0)
					return Result.success("【已"+(state?"开启":"关闭")+"】登录器统计");
				else
					return Result.error("登录器统计状态更改失败");
			}
		}
		return null;
	}
	
	/**
	 * 更新统计间隔时间
	 * @param flag 统计类型
	 * @param time 时间
	 * @return
	 */
	@Transactional
	public Result updateIntervalTime(String flag,int time){
		if (flag.equals("visit")){
			int i = baseRepository.updateVisitTime(time, mark);
			if (i > 0)
				return Result.success("流量统计间隔设置为【"+time+"分钟】统计一次");			
		}else{
			int i = baseRepository.updateLoginTime(time, mark);
			if (i > 0)
				return Result.success("登录器统计间隔设置为【"+time+"分钟】统计一次");
		}
		return Result.error();
	}
	
	public Result updateIsOpenTailAmount(Boolean state){
		int i = baseRepository.updateIsOpenTailAmount(state, mark);
		if (i > 0){
			return Result.success("订单尾额【已"+(state?"开启":"关闭")+"】");
		}
		return Result.error();
	}
	
	public Optional<SystemSet> findSystemSetByMark(){
		return baseRepository.findByMark(mark);
	}

	public Optional<SystemSet> findByMark(String mark) {
		return baseRepository.findByMark(mark);
	}

	@Cacheable(key="'webInfo'",cacheNames = "web_info")
	public SystemSet findWebInfo(){
		return baseRepository.findWebInfo(mark);
	}

	public Result updateSettlementType(Integer settlementType) {
		baseRepository.updateSettlementType(settlementType, mark);
		return Result.success("设置成功");
	}

	public Result updateRegisterState(Integer registerState) {
		baseRepository.updateRegisterState(registerState, mark);
		return Result.success("设置成功");
	}
	
	@Cacheable(key="'gameEngine'",cacheNames = "payment")
	public List<GameEngine> findGameEngine() {
		String gameEngine = baseRepository.findGameEngineByMark(mark);
		return CommonUtil.parseArray(gameEngine, GameEngine.class);
	}
}
