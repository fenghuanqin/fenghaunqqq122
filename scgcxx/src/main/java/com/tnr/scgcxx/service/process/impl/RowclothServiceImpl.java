package com.tnr.scgcxx.service.process.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgc.base.Time;
import com.tnr.scgcxx.dao.process.RowclothDao;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.RawclothService;
import com.tnr.scgcxx.util.Utils;
@Service
public class RowclothServiceImpl implements RawclothService {
	@Autowired
	private RowclothDao rowclothDao;

	@Override
	public Map<String, Object> getRawcloth(ProcessDto dto) {
		PageHelper.startPage(dto);
		List<com.tnr.scgcxx.model.Process> list=rowclothDao.findRowclothList(dto);
		/*
		 * System.out.println("----------------------------------------------");
		 * for(com.tnr.scgcxx.model.Process p : list) {
		 * 
		 * System.out.println(p.toString()); }
		 * System.out.println("----------------------------------------------");
		 */
		 
		PageInfo<com.tnr.scgcxx.model.Process> page=new PageInfo<com.tnr.scgcxx.model.Process>(list);
		return Utils.convert2PageData(page);
	}
	@Override
	public List<Plan> getPlan() {
		
		return rowclothDao.getPlanList();
	}
	@Override
	public List<Standard> getStandardList() {
		return rowclothDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return rowclothDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return rowclothDao.findColor();
	}
	@Override
	public Plan getOnePlan(Integer plan_id) {
		Plan plan = rowclothDao.getOnePlan(plan_id);
		System.out.println("-----------------");
		System.out.println(plan.toString());
		System.out.println("-----------------");
		return plan;
	}
	
	@Override
	public Result exctAdd(ProcessDto dto, String currDate, String currUserName) {
		Integer plan_id=dto.getPlan_id();
		int plan_idNum=rowclothDao.selectPlanIdNum(plan_id);//plan_idNum指通过计划编号查询出该计划的计划编号数目（已经添加分组了，该数肯定大于0.未分组则肯定等于0）
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备添加失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		if(plan_idNum>0) {
			return Result.failResult("坯布准备分组添加失败，此计划已被分组");
		}
		
		else {
			int j=0;
			Double group_num=dto.getGroup_num();
			if(dto.getPlan_num()%dto.getGroup_num()==0) {
				j=(int)(dto.getPlan_num()/dto.getGroup_num());//j表示将计划数量分成多少组数
					int n=0;//n表示更新影响行数
					for(int i=0;i<j;i++) {
						//Double process_id=rowclothDao.getCount();
						double d=(double)Time.getDate(new Date());
						Double process_id=Double.valueOf(d);
						n = rowclothDao.addProcess(process_id,group_num,dto,currDate,currUserName)+n;
						
					}
					
					if(n==j) {
						return Result.successResult("坯布准备添加成功"); 
					} 
					else {
						return Result.failResult("坯布准备添加失败");
					}
				
			}
			else {
				j=Integer.parseInt(new java.text.DecimalFormat("0").format(dto.getPlan_num()/dto.getGroup_num()));
				Double s=dto.getPlan_num()%dto.getGroup_num();
					int k=0;
					for(int i=0;i<j-1;i++) {
						Double process_id=rowclothDao.getCount();
						k = rowclothDao.addProcess(process_id,group_num,dto,currDate,currUserName)+k;
					}
					Double process_id=rowclothDao.getCount();
					
					int a=rowclothDao.addProcess(process_id,s,dto,currDate,currUserName);
					System.out.println("-----------------");
					System.out.println(a+","+k+","+j);
					System.out.println("-----------------");
					if(k+a==j) {
						return Result.successResult("坯布准备添加成功"); 
					} 
					else {
						return Result.failResult("坯布准备添加失败");
					}
				
				
			}
		
		
		}
		
		
	}
	@Override
	public Result exctUpd(ProcessDto dto, String currDate, String currUserName) {
		
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备修改失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		Integer plan_id=dto.getPlan_id();
		Plan plan = rowclothDao.getOnePlanUp(plan_id);
		Double process_num=dto.getGroup_num();
		/*
		 * System.out.println("-----------------");
		 * System.out.println(plan.getPlan_id()+","+plan.getCus_name()+","+plan.
		 * getStandard_name()+","+plan.getCo_name()+","+process_num+","+plan.getPlan_num
		 * ()); System.out.println("-----------------");
		 */
		Double process_id=dto.getProcess_id();
		Integer process_cus=plan.getCus_id();
		Integer process_std=plan.getStandard_id();
		Integer process_color=plan.getCo_id();
		
		//int n = rowclothDao.updProcess(process_id,plan_id,process_cus,process_std,process_color,process_num,currDate,currUserName);
		int n = rowclothDao.updProcess(process_id, plan, process_num, currDate, currUserName);
		if(n>0) {
			return Result.successResult("坯布准备修改成功");
		} 
		else {
			return Result.failResult("坯布准备修改失败"); 
		}
	}
	@Override
	public Plan getOnePlanUp(Integer plan_id) {
		Plan plan = rowclothDao.getOnePlanUp(plan_id);
		
		return plan;
	}
	@Override
	public Result exctUpdStatus(ProcessDto dto) {
		int n = rowclothDao.updStatus(dto);
		if(n>0) {
			return Result.successResult("已投坯成功");
		} 
		else {
			return Result.failResult("已投坯失败"); 
		}
	}
	@Override
	public Result exctDele(Double process_id) {
		int n = rowclothDao.dele(process_id);
		if(n>0) {
			return Result.successResult("坯布准备删除成功");
		} 
		else {
			return Result.failResult("坯布准备删除失败"); 
		}
	}
	@Override
	public Result exctDeletes(Double[] process_ids) {
		int n = rowclothDao.deletes(process_ids);
		if(n>0) {
			return Result.successResult("坯布准备删除成功");
		} 
		else {
			return Result.failResult("坯布准备删除失败"); 
		}
	}
	

}
