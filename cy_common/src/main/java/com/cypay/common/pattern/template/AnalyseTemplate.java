package com.cypay.common.pattern.template;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.vo.OrderVo;

import cn.hutool.core.date.DateTime;

/**
 * 订单数据分析模板
 * @param sql
 */
@Component
public abstract class AnalyseTemplate {
	
	@Autowired
	EntityManager entityManager;
	
	private static final String SQL = "SELECT COUNT(o.id), IFNULL(SUM(o.pay_amount), 0.00) AS payAmount, IFNULL(SUM(o.merchant_profit), 0.00), IFNULL(SUM(o.agent_profit), 0.00)";
	
	private static final Map<String, StringBuilder> SQL_CACHE = new ConcurrentHashMap<>();
	
	public abstract String getType();
	
	public void select(StringBuilder sql) {}
	
	public void join(StringBuilder sql) {}
	
	public abstract void group(StringBuilder sql);
	
	protected Integer groupModle = 0;
	
	public void init(StringBuilder sql) {
		sql.append(SQL);
		
		if(ShiroManager.isAdminUser())
			sql.append(", SUM(o.platform_profit)");
	}
	
	public void form(StringBuilder sql) {
		sql.append(" , o.discription , m.nickname FROM cy_order o LEFT JOIN cy_merchant m ON m.id = o.merchant_id");
	}
	
	public void order(StringBuilder sql) {
		sql.append(" ORDER BY payAmount DESC");
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getResultList(StringBuilder sql) {
		Query query = entityManager.createNativeQuery(sql.toString());
		
		return query.getResultList();
	}
	
	
	public final List<Object[]> excute(OrderVo v) {	
		setGroupModle(v.getGroupModle());
		// 获取sql缓存
		StringBuilder sql = SQL_CACHE.get(getKey());
		if (sql == null) { // 未缓存sql，初始化
			sql = new StringBuilder();
			// 初始化sql
			init(sql);
			
			// 添加查询字段
			select(sql);
			
			// 查询对象
			form(sql);
			
			// 关联对象
			join(sql);
			
			where(sql);
			
			SQL_CACHE.put(getKey(), sql);
		}
		StringBuilder where = new StringBuilder(sql.toString());
		
		// 查询条件
		condition(v, where);
		
		// 分组
		group(where);
		
		// 排序
		order(where);
		
		return getResultList(where);
	}
	
	public void where(StringBuilder sql) {
		sql.append(" WHERE 1=1");
	}
	
	public void condition(OrderVo v, StringBuilder sql) {
		Assert.notNull(v, "The V connot be null.");
		
		sql.append(" AND o.state IN(1,2)");
		// 订单创建时间 >> 开始时间
		Date orderDate = v.getOrderDate();
		orderDate = orderDate==null?DUtil.beginOfToday():new DateTime(orderDate);
		sql.append(" AND o.order_date >= '").append(orderDate.toString()).append("'");
		
		// 订单支付时间 >> 结束时间
		Date payDate = v.getPayDate();
		if (payDate != null)
			sql.append(" AND o.order_date <= '").append(new DateTime(payDate).toString()).append("'");
		
		// 根据商户查询
		Merchant m = v.getMerchant();
		if (m != null && m.getId() != null)
			sql.append(" AND o.merchant_id = ").append(m.getId());
		
		String account = CommonUtil.sqlInject(v.getAccount());
		if (account != null) {
			sql.append(" AND m.account = ").append(account);
		}
		
		// 根据游戏分区查询
		Partition p = v.getPartition();
		if (p != null && p.getId() != null)
			sql.append(" AND o.partition_id = ").append(p.getId());
		
		// 根据游戏分组查询
		//Group g = v.getGroup();
		if (v.getGroupId() != null)
			sql.append(" AND o.group_id = ").append(v.getGroupId());

		// 根据代理查询
		Merchant agent = v.getAgent();
		if (agent != null && agent.getId() != null)
			sql.append(" AND o.agent_id = ").append(agent.getId());
		
		if (v.getIsAgency() && ShiroManager.isAdminUser()) {
			sql.append(" AND o.agent_id IS NOT NULL");
		}
	}
	
	private String getKey() {
		if (getType().equals("group")){
			return getType() + (ShiroManager.isAdminUser() ? "-admin" : "") + getGroupModle();
		}
		return getType() + (ShiroManager.isAdminUser() ? "-admin" : "");
	}

	public Integer getGroupModle() {
		return groupModle;
	}

	public void setGroupModle(Integer groupModle) {
		this.groupModle = groupModle;
	}
	
}
