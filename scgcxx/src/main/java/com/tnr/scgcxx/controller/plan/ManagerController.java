package com.tnr.scgcxx.controller.plan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.Contstants;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.PlanDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.plan.PlanService;
@RestController
@RequestMapping("/plan/manager")
public class ManagerController {
	@Autowired
	private PlanService planService;
	@GetMapping("/sele")
	public Map<String,Object> getPlanPage(PlanDto dto){
		System.out.println(dto);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map=planService.getPlanPage(dto);
		/*
		 * Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); while
		 * (it.hasNext()) { Map.Entry<String, Object> entry = it.next();
		 * System.out.println("key= " + entry.getKey() + " and value= " +
		 * entry.getValue()); }
		 */
		
		return map;
	}
	@PostMapping("/add")
	public Result planAdd(@RequestBody PlanDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		System.out.println(currUser+","+currDate);
		return planService.planAdd(dto,currDate,currUserName);
	}
	@PutMapping("/upd")
	public Result planUpd(@RequestBody PlanDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		return planService.planUpd(dto,currDate,currUserName);
	}
	@GetMapping("/standard")
	public List<Standard> getStandard(){
		List<Standard> standardList = planService.getStandardList();
		return standardList;
	}
	@GetMapping("/cus")
	public List<Customer> getCustomer(){
		return planService.getCustomer();
	}
	@GetMapping("/co")
	public List<Color> getColor(){
		return planService.getColor();
	}
	@PutMapping("/perform")//达成
	public Result planPerform(@RequestBody PlanDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		return planService.planPerform(dto,currDate,currUserName);
	}
	@DeleteMapping("/dele/{plan_id}")
	public Result planDele(@PathVariable("plan_id") Integer plan_id) {
		return planService.exctDele(plan_id);
	}
	@DeleteMapping("/deles")
	public Result PlanDeles(@RequestBody Integer[] plan_ids) {
		return planService.exctDeles(plan_ids);
	}
}
