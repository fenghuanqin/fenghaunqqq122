package com.tnr.scgcxx.service.process.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.process.PretreatmentDao;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.PretreatmentService;
import com.tnr.scgcxx.service.process.RawclothService;
import com.tnr.scgcxx.util.Utils;
@Service
public class PretreatmentServiceImpl implements PretreatmentService {
	@Autowired
	private PretreatmentDao pretreatmentDao;
	
	  @Override public Map<String, Object> getPretreatment(ProcessDto dto) {
	  PageHelper.startPage(dto); 
	  List<com.tnr.scgcxx.model.Process> list=pretreatmentDao.findPretreatmentList(dto);
	  PageInfo<com.tnr.scgcxx.model.Process> page=new PageInfo<com.tnr.scgcxx.model.Process>(list);
	  return Utils.convert2PageData(page); }
	 
	
	@Override
	public List<Plan> getPlan() {
		
		return pretreatmentDao.getPlanList();
	}
	@Override
	public List<Standard> getStandardList() {
		return pretreatmentDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return pretreatmentDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return pretreatmentDao.findColor();
	}
	@Override
	public Plan getOnePlan(Integer plan_id) {
		Plan plan = pretreatmentDao.getOnePlan(plan_id);
		System.out.println("-----------------");
		System.out.println(plan.toString());
		System.out.println("-----------------");
		return plan;
	}
	
	@Override
	public Result exctAdd(ProcessDto dto, String currDate, String currUserName) {
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备添加失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		else {
			int n = pretreatmentDao.addProcess(dto,currDate,currUserName);
			if(n>0) {
				return Result.successResult("坯布准备添加成功"); 
			} 
			else {
				return Result.failResult("坯布准备添加失败");
			}
		}
		
	}
	@Override
	public Result exctUpd(ProcessDto dto, String currDate, String currUserName) {
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备修改失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		Integer plan_id=dto.getPlan_id();
		Plan plan = pretreatmentDao.getOnePlanUp(plan_id);
		Double process_num=dto.getGroup_num();
		
		Double process_id=dto.getProcess_id();
		Integer process_cus=plan.getCus_id();
		Integer process_std=plan.getStandard_id();
		Integer process_color=plan.getCo_id();
		
		//int n = PretreatmentDao.updProcess(process_id,plan_id,process_cus,process_std,process_color,process_num,currDate,currUserName);
		int n = pretreatmentDao.updProcess(process_id, plan, process_num, currDate, currUserName);
		if(n>0) {
			return Result.successResult("坯布准备修改成功");
		} 
		else {
			return Result.failResult("坯布准备修改失败"); 
		}
	}
	@Override
	public Plan getOnePlanUp(Integer plan_id) {
		Plan plan = pretreatmentDao.getOnePlanUp(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctDele(Double process_id) {
		int n = pretreatmentDao.dele(process_id);
		if(n>0) {
			return Result.successResult("坯布准备删除成功");
		} 
		else {
			return Result.failResult("坯布准备删除失败"); 
		}
	}
	@Override
	public Result exctDeletes(Double[] process_ids) {
		int n = pretreatmentDao.deletes(process_ids);
		if(n>0) {
			return Result.successResult("坯布准备删除成功");
		} 
		else {
			return Result.failResult("坯布准备删除失败"); 
		}
	}


	@Override
	public Result exctUpdStatus(ProcessDto dto, String currDate, String currUserName) {
		
		Double group_num=dto.getGroup_num();
		Double pretreat_num=dto.getPretreat_num();
		System.out.println("???????????????????????");
		System.out.println(group_num+","+pretreat_num);
		System.out.println(dto);
		System.out.println("???????????????????????");
		if(pretreat_num>group_num) {
			return Result.failResult("输入的前处理产量大于坯布准产量，请重新输入"); 
		}
		else {
			int n = pretreatmentDao.updStatus(dto,currDate,currUserName);
			if(n>0) {
				return Result.successResult("已前处理成功");
			} 
			else {
				return Result.failResult("已前处理失败"); 
			}
		}
		
		
		
	}


	

	
	
	
}
