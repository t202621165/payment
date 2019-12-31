package com.cypay.common.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.RankRate;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.RankRateRepository;
import com.cypay.common.repository.impl.RankRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.RankVo;
import com.cypay.common.vo.Result;
@Service
public class RankService extends BaseServiceImpl<RankRepository, Rank, RankVo>{
	
	@Autowired
	private RankRateRepository rankRateRepository;
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	/**
	 * 查询所有费率分组和使用的商户数量
	 * @param pageData
	 * @return
	 */
	public Page<RankVo> findRankAndMerchantCount(PageData pageData) {
		Pageable pageable = pageData.ofPageable();
		List<RankVo> list = baseRepository.findAllRankAndMerchantCount(pageable);
		return PageableExecutionUtils.getPage(list, pageable, () -> baseRepository.count());
	}
	
	@Transactional
	public Result deleteByIdAndMerchant(Long id) {
		Merchant merchant = ShiroManager.getMerchant();
		Long count = merchantRepository.countByRankAndParent(new Rank(id), merchant);
		if (count > 0)
			return Result.error("删除失败，当前【"+count+"个】商户正在使用当前分组！");
		
		rankRateRepository.deleteByRankId(id);
		baseRepository.deleteByIdAndMerchant(id, merchant);
		return Result.success("删除成功！");
	}

	public Rank saveRank(Rank rank){
		return baseRepository.save(rank);
	}
	
	public Result updateIsDefault(Long id,Boolean isAgency){
		int i = baseRepository.updateIsDefault(id,isAgency);
		if( i > 0 )
			return Result.success("设置默认级别成功");
		else
			return Result.error("设置默认级别失败");
	}
	
	public Result updateIsDefault(Long id, Long merchantId){
		int i = baseRepository.updateIsDefault(id, merchantId);
		if( i == 0 )
			return Result.error("设置失败");
		
		return Result.success("设置成功");
	}
	
	/**
	 * 查询级别id名称集合
	 * @return
	 */
	public List<RankVo> findAllByIdAndName(){
		return baseRepository.findAllByIdAndName();
	}
	
	public List<RankVo> findAllByMerchant(Merchant merchant){
		return baseRepository.findAllByMerchant(merchant);
	}

	@Transactional
	public Result saveWithRate(Rank rank) {
		String msg = "";
		Rank r;
		if (StringUtils.isEmpty(rank.getName()))
			return Result.error("分组名称不能为空", "name");
		
		if (rank.getId() != null) {
			Optional<Rank> optional = baseRepository.findByIdAndMerchant(rank.getId(), ShiroManager.getMerchant());
			if (!optional.isPresent())
				return Result.error("当前分组不存在，或已被删除！");
			r = optional.get();
			r.setName(rank.getName());
			r.setRankRates(rank.getRankRates());
			rankRateRepository.deleteByRankId(r.getId());
			msg = "分组【"+r.getName()+"】更新成功！";
		}else {
			
			rank.setIsAgency(Boolean.TRUE);
			rank.setMerchant(ShiroManager.getMerchant());
			r = rank;
			msg = "成功添加分组【"+rank.getName()+"】！";
		}
		baseRepository.save(r);
		List<RankRate> rates = rank.getRates();
		
		String sql = "insert into cy_rank_rate(rate, product_id, rank_id) values(?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				RankRate rate = rates.get(i);
				ps.setBigDecimal(1, rate.getRate());
				ps.setLong(2, rate.getProduct().getId());
				ps.setLong(3, r.getId());
			}
			
			@Override
			public int getBatchSize() {
				return rates.size();
			}
		});
		return Result.success(msg);
	}

}
