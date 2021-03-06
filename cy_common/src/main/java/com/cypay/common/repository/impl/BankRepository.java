package com.cypay.common.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Merchant;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface BankRepository extends BaseRepository<Bank,Long>{
	@Query("select b from Bank b where b.merchant.id = ?1")
	Bank findBankByMerchantId(Long merchantId);
	
	
	@Query(value = "SELECT new com.cypay.common.entity.Bank(b.id, b.realName, b.bankName, "
			+ "b.bankMark, b.bankBranch, b.bankNumber, b.overMoney, b.state, b.activated, b.version, m.fee) "
			+ "FROM Bank b INNER JOIN b.merchant m WHERE m = ?1")
	Bank findByMerchant(Merchant merchant);
	
	/**
	 * 冻结/解冻 账户
	 * @param id
	 * @return
	 */
	@Transactional
	@Query(value = "UPDATE cy_bank SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);

	List<Bank> findAllByMerchant(Merchant merchant);
	

	@Query(value="select SUM(b.overMoney) as overMoney from Bank b inner join Merchant m on b.merchant.id = m.id and m.settlementType = ?1")
	Bank findSumOverMoney(Integer settlementType);

	@Transactional
	@Query(value = "UPDATE cy_bank SET over_money = over_money - ?2, all_pay = all_pay + ?2, "
			+ "version = version + 1 WHERE id=?1 and version = ?3", nativeQuery = true)
	@Modifying
	int updateOverMoney(Long id, BigDecimal amount, Long version);
	
	@Transactional
	@Query(value = "DELETE FROM Bank b WHERE b.merchant = ?1")
	@Modifying
	int deleteByMerchant(Merchant merchant);
	
	@Query(value="SELECT new com.cypay.common.entity.Bank(SUM(s.amount), b.overMoney, b.state, b.activated) FROM Bank b LEFT JOIN b.settleMents s WITH s.state IN(0, 2, 3) WHERE b.merchant = ?1")
	Bank findOverMoneyAndSettlementMoney(Merchant merchant);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Bank b SET b.overMoney = b.overMoney + ?2, b.allDeposit = b.allDeposit + ?2 WHERE b.merchant = ?1")
	int updateOverMoney(Merchant merchant, BigDecimal merchantProfit);

	@Query(value = "SELECT new com.cypay.common.entity.Bank(b.id, b.overMoney, m.id, m.fee) "
			+ "FROM Bank b INNER JOIN b.merchant m WHERE b.id IN(?1)")
	List<Bank> findByIdIn(List<Long> ids);
	
	@Query(value = "SELECT new com.cypay.common.entity.Bank(b.id, b.overMoney, m.id, m.fee) "
			+ "FROM Bank b INNER JOIN b.merchant m WHERE b.state = 1 AND m.settlementType = 1")
	List<Bank> findT1SettlementInfo();
}
