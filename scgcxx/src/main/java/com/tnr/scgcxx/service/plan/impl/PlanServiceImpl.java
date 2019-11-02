package com.tnr.scgcxx.service.plan.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.plan.PlanDao;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.PlanDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.plan.PlanService;
import com.tnr.scgcxx.util.Utils;
@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanDao planDao;
	@Override
	public Map<String, Object> getPlanPage(PlanDto dto) {
		PageHelper.startPage(dto);//pageHeleper开始分页
		List<Plan> list=planDao.findPageList(dto);//执行查询，将查询结果塞至集合
		
		PageInfo<Plan> page=new PageInfo<Plan>(list);//将list集合传至pageInfo		
		return Utils.convert2PageData(page);
	}
	@Override
	public Result planAdd(PlanDto dto,String currDate,String currUserName) {
		System.out.println("----------------------");
		System.out.println(dto.getPlan_id()+","+currUserName+","+currDate);
		System.out.println("----------------------");
		//Standard std = planDao.findStandard(dto.getStandard_id());
		//String standard_name=std.getStandard_name();
		int cnt = planDao.add(dto, currDate, currUserName);
		if(cnt>0) {
			return Result.successResult("增加计划成功");
		}
		else {
			return Result.failResult("增加计划失败");
		}
	}
	@Override
	public Result planUpd(PlanDto dto, String currDate, String currUserName) {
		System.out.println("----------------------");
		System.out.println(dto.toString()+","+currDate+","+currUserName);
		System.out.println("----------------------");
		int cnt = planDao.upd(dto,currDate,currUserName);
		if(cnt>0) {
			return Result.successResult("修改计划成功");
		}
		else {
			return Result.failResult("修改计划失败");
		}	}
	@Override
	public List<Standard> getStandardList() {
		return planDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return planDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return planDao.findColor();
	}
	@Override
	public Result planPerform(PlanDto dto, String currDate, String currUserName) {
		int cnt = planDao.updstatus(dto,currDate,currUserName);
		if(cnt>0) {
			return Result.successResult("计划下达成功");
		}
		else {
			return Result.failResult("计划下达失败");
		}	
		
	}
	@Override
	public Result exctDele(Integer plan_id) {
		int cnt = planDao.delePlan(plan_id);
		if(cnt>0) {
			return Result.successResult("计划删除成功");
		}
		else {
			return Result.failResult("计划删除失败");
		}	
		
	}
	@Override
	public Result exctDeles(Integer[] plan_ids) {
		int cnt = planDao.delesPlan(plan_ids);
		if(cnt>1) {
			return Result.successResult("计划多删除成功");
		}
		else {
			return Result.failResult("计划多删除失败");
		}	
		
	}
	
	
	

}
