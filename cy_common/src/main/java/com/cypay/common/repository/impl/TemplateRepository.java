package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.cypay.common.bo.TemplateBo;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Template;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.TemplateVo;

@Repository
public interface TemplateRepository extends BaseRepository<Template, Long> {
	
	@Override
	@EntityGraph(value = "templateWithPartition", type = EntityGraphType.FETCH)
	Page<Template> findAll(@Nullable Specification<Template> spec, Pageable pageable);
	
	@Override
	@EntityGraph(value = "templateWithPartition", type = EntityGraphType.FETCH)
	List<Template> findAll(@Nullable Specification<Template> spec);
	
	Long countByIdAndMerchant(Long id, Merchant merchant);

	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_template SET give_state = "
			+ "CASE WHEN give_state = 0 THEN 1 ELSE 0 END "
			+ "WHERE id = ?1 AND merchant_id = ?2", nativeQuery = true)
	int updateState(Long id, Long merchantId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Template t WHERE t.id = ?1 AND t.merchant = ?2")
	int deleteByIdAndMerchant(Long id, Merchant merchant);
	
	@Query(value = "SELECT new com.cypay.common.vo.TemplateVo(p.name,t.id,t.currencyName,t.ratio,"
			+ "t.minAmount,t.maxAmount,t.giveState,t.giveWay,t.showAdditional,t.showEquip,t.showIntegral,"
			+ "t.infoAdditional,t.infoEquip,t.infoIncentive,t.infoIntegral,t.infoRedPacket) FROM Partition p "
			+ "INNER JOIN p.template t WHERE p.state = 1 AND p = ?1 AND p.merchant = ?2")
	TemplateVo findTemplateInfo(Partition p, Merchant m);
	
	/**
	 * 根据商户密钥查找模板
	 * @param key 商户密钥
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.TemplateVo(t.id,t.name,t.type,t.currencyName,t.ratio) from Template t "
			+ "inner join Merchant m on t.merchant.id = m.id "
			+ "and m.secretKey = ?1")
	List<TemplateVo> findTemplatesByMerchantKey(String key);
	
	@Query(value="select new com.cypay.common.bo.TemplateBo(t.id,t.name,t.type,t.gameName,t.currencyName,t.ratio,t.minAmount,"
			+ "t.maxAmount,t.rechargeWay,t.giveWay,t.giveState,t.isContains,t.showAdditional,t.showIntegral,t.showEquip,"
			+ "t.scriptCommand,t.browserCommand,t.gameEngine, t.infoNpc,t.infoIncentive,t.infoAdditional,t.infoIntegral,"
			+ "t.infoEquip,p.ybEgg,p.scriptPath,p.uuid,t.equipType,t.redPacketState,t.redPacketAdditional,t.redPacketIntegral,"
			+ "t.redPacketEquip,t.cardState) FROM  Partition p inner join p.template t with p.id = ?1")
	TemplateBo findTemplateByPartitionId(Long id);
	
	@Query(value="select new com.cypay.common.bo.TemplateBo(t.id,t.name,t.type,t.gameName,t.currencyName,t.ratio,t.minAmount,"
			+ "t.maxAmount,t.rechargeWay,t.giveWay,t.giveState,t.isContains,t.showAdditional,"
			+ "t.showIntegral,t.showEquip,t.scriptCommand,t.browserCommand,t.gameEngine,"
			+ "t.infoNpc,t.infoIncentive,t.infoAdditional,t.infoIntegral,t.infoEquip,t.equipType,t.redPacketState,t.redPacketAdditional,"
			+ "t.redPacketIntegral,t.redPacketEquip,t.cardState)"
			+ " FROM Template t where t.id = ?1")
	TemplateBo findTemplateByTemplateId(Long id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Template t WHERE t.merchant = ?1")
	int deleteByMerchant(Merchant m);
	
	/**
	 * 根据分区唯一标识（uuid）查询模板信息
	 * @param uuid
	 * @return
	 */
	@Query(value = "SELECT new com.cypay.common.vo.TemplateVo(p.merchant.id,p.changeDate,p.useName,p.name,"
			+ "p.isChangeInTime,p.notice,p.noticeState,t.id,t.currencyName,t.ratio,t.rechargeWay,t.minAmount,t.maxAmount,"
			+ "t.giveState,t.giveWay,t.equipType,t.showAdditional,t.showEquip,t.showIntegral,t.infoAdditional,"
			+ "t.infoEquip,t.infoIncentive,t.infoIntegral,t.infoRedPacket) FROM Partition p INNER JOIN "
			+ "p.template t WHERE p.uuid = ?1 AND p.state = 1")
	TemplateVo findByProdutUuid(String uuid);
}
