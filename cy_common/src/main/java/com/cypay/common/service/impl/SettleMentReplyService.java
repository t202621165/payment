package com.cypay.common.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.repository.impl.SettleMentReplyRepository;
import com.cypay.common.repository.impl.SettleMentRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentReplyVo;
import com.cypay.common.vo.SettlementExcel;

@Service
public class SettleMentReplyService extends BaseServiceImpl<SettleMentReplyRepository, SettleMentReply, SettleMentReplyVo>{
	
	@Autowired
	private SettleMentRepository settleMentRepository;
	
	@Override
	protected CriteriaData<SettleMentReply, SettleMentReplyVo> getCriteriaData(String name, SettleMentReplyVo v) {
		CriteriaData<SettleMentReply, SettleMentReplyVo> cd = super.getCriteriaData(name, v);
		Root<SettleMentReply> root = cd.getRoot();
		Join<SettleMentReply,List<SettleMent>> settleMent = root.join("settleMents",JoinType.INNER);
		settleMent.alias("settlement");
		cd.getCriteriaQuery().groupBy(root.get("id"));
		
		if (!cd.isCache()) {
			cd.getSelections().add(cd.getCriteriaBuilder().count(settleMent.get("id")));
			cd.getSelections().add(cd.getCriteriaBuilder().sum(settleMent.get("amount")));
		}
		return cd;
	}
	
	@Transactional
	public Result updateReplyState(Long id){
		int i = baseRepository.updateStateById(true, id);
		int j = settleMentRepository.updateStateBySettlementReplyId(1, id,new Date());
		if(i > 0 && j>0)
			return Result.success("批复成功");
		else
			return Result.error("批复失败");
	}
	
	public SettleMentReplyVo findTotalAmount(Date startDate,Date endDate){
		return baseRepository.findTotalAmount(startDate, endDate);
	}
	
	public SettleMentReply findBySerialNumber(String serailNumber){
		return baseRepository.findBySerialNumber(serailNumber);
	}

	/**
	 * 导出批复记录
	 * @param id
	 */
	public void excel(SettleMentReply reply,String type, HttpServletResponse response) {
		List<SettlementExcel> data = settleMentRepository.findBySettleMentReplyId(reply.getId());
		switch (type) {
		case "excel":
			this.excelToCustom(reply, data, response);
			break;
		case "CMB":
			this.excelToCmb(reply, data, response);
			break;
		default:
			this.excelToDefault(response);
			break;
		}
	}

	/**
	 * 默认EXCEL格式
	 * @param reply
	 * @param data
	 * @param response
	 */
	public void excelToCustom(SettleMentReply reply,List<SettlementExcel> data,HttpServletResponse response){
		doExcel(reply.getSerialNumber(), data, response, w -> {
			w.addHeaderAlias("serialNumber", "流水号");
			w.addHeaderAlias("applyDate", "申请时间");
			w.addHeaderAlias("nickname", "商户昵称");
			w.addHeaderAlias("amount", "付款金额");
			w.addHeaderAlias("cost", "手续费");
			w.addHeaderAlias("realName", "收款人姓名");
			w.addHeaderAlias("bankName", "收款银行");
			w.addHeaderAlias("bankNumber", "收款账号");
			w.addHeaderAlias("bankBranch", "开户地区");
			w.addHeaderAlias("discription", "描述");
			w.addHeaderAlias("complateDate", "付款时间");
			w.merge(9, "批付号：" + reply.getSerialNumber());
		});
	}
	
	/**
	 * 招商银行批量转账excel
	 * @param reply
	 * @param data
	 * @param response
	 */
	public void excelToCmb(SettleMentReply reply,List<SettlementExcel> data,HttpServletResponse response){		
		List<Map<String,Object>> maps = data.parallelStream().map(s-> {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("bankNumber", s.getBankNumber());
			map.put("realName", s.getRealName());
			map.put("amount", s.getAmount());
			map.put("mark","平台结算");
			map.put("bankName", s.getBankName());
			map.put("bankBranch", s.getBankBranch());
			map.put("province", "");
			map.put("city", "");
			map.put("outCard","");
			map.put("modle","实时");
			return map;
		}).collect(Collectors.toList());
		
		doExcel(reply.getSerialNumber(), maps, response, w -> {
			w.addHeaderAlias("bankNumber", "收款账户列");
			w.addHeaderAlias("realName", "收款户名列");
			w.addHeaderAlias("amount", "转账金额列");
			w.addHeaderAlias("mark", "备注列");
			w.addHeaderAlias("bankName", "收款银行列");
			w.addHeaderAlias("bankBranch", "收款银行支行列");
			w.addHeaderAlias("province", "收款省/直辖市列");
			w.addHeaderAlias("city", "收款市县列");
			w.addHeaderAlias("outCard", "转出账号/卡");
			w.addHeaderAlias("modle", "转账模式");
			for (int i = 0; i < 10; i++){
				w.setColumnWidth(i, 25);
			}
		});
	}
	
	public void excelToDefault(HttpServletResponse response){
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<h1 style='color:red;margin-top:20%;margin-left:35%;'>暂不支持该导出方式</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
