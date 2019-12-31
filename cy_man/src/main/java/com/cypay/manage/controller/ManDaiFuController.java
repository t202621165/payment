package com.cypay.manage.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.service.impl.DaiFuService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

@RequestMapping(value="/man")
@RestController
public class ManDaiFuController {
	
	@Autowired
	private DaiFuService daifuService;
	
	@GetMapping("/daifu/list")
	public Page<?> list(DaiFu v,PageData pageData){
		return daifuService.findAll(v, pageData);
	}
	
	@PostMapping("/daifu/save")
	public Result save(@Valid DaiFu daifu){
		return daifuService.save(daifu);
	}
	
	@GetMapping("/daifu/{mark}")
	public List<DaiFu> markNames(@PathVariable(value = "mark") String mark){
		return daifuService.findMarkNameByMark(mark);
	}
	
	@GetMapping("/daifu/delete")
	public Result delete(@RequestParam(value = "id") Long id){
		return daifuService.deleteById(id);
	}
	
	/**
	 * 资金代付
	 * @return
	 */
	@PostMapping("/payee/{mark}/{daifuId}")
	public Result payee(@PathVariable(value="mark") String mark, 
			@PathVariable(value="daifuId") Long daifuId,@RequestBody List<Long> ids,HttpServletRequest request) {
		return daifuService.payee(daifuId, ids, mark, request);
	}
	
}
