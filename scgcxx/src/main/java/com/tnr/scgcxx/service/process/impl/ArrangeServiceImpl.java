package com.tnr.scgcxx.service.process.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.process.ArrangeDao;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.ArrangeService;
import com.tnr.scgcxx.service.process.PrintService;
import com.tnr.scgcxx.util.Utils;
@Service
public class ArrangeServiceImpl implements ArrangeService {
	@Autowired
	private ArrangeDao arrangeDao;
	
	  @Override public Map<String, Object> getArrange(ProcessDto dto) {
	  PageHelper.startPage(dto); 
	  List<com.tnr.scgcxx.model.Process> list=arrangeDao.findArrangeList(dto);
	  PageInfo<com.tnr.scgcxx.model.Process> page=new PageInfo<com.tnr.scgcxx.model.Process>(list); 
	  return Utils.convert2PageData(page); 
	  }
	 
	
	@Override
	public List<Plan> getPlan() {
		
		return arrangeDao.getPlanList();
	}
	@Override
	public List<Standard> getStandardList() {
		return arrangeDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return arrangeDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return arrangeDao.findColor();
	}
	@Override
	public Plan getOnePlan(Integer plan_id) {
		Plan plan = arrangeDao.getOnePlan(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctAdd(ProcessDto dto, String currDate, String currUserName) {
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备添加失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		else {
			int n = arrangeDao.addProcess(dto,currDate,currUserName);
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
		Plan plan = arrangeDao.getOnePlanUp(plan_id);
		Double process_num=dto.getGroup_num();
		
		Double process_id=dto.getProcess_id();
		Integer process_cus=plan.getCus_id();
		Integer process_std=plan.getStandard_id();
		Integer process_color=plan.getCo_id();
		
		//int n = arrangeDao.updProcess(process_id,plan_id,process_cus,process_std,process_color,process_num,currDate,currUserName);
		int n = arrangeDao.updProcess(process_id, plan, process_num, currDate, currUserName);
		if(n>0) {
			return Result.successResult("坯布准备修改成功");
		} 
		else {
			return Result.failResult("坯布准备修改失败"); 
		}
	}
	@Override
	public Plan getOnePlanUp(Integer plan_id) {
		Plan plan = arrangeDao.getOnePlanUp(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctDele(Double process_id) {
		int n = arrangeDao.dele(process_id);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}
	@Override
	public Result exctDeletes(Double[] process_ids) {
		int n = arrangeDao.deletes(process_ids);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}


	@Override
	public Result exctUpdStatus(ProcessDto dto, String currDate, String currUserName) {
		
		Double arrange_num=dto.getArrange_num();
		//Double dye_num=dto.getDye_num();
		Double print_num=dto.getPrint_num();
		Double pretreat_num=dto.getPretreat_num();
		String plan_type=dto.getPlan_type();
		System.out.println("???????????????????????");
		System.out.println(arrange_num+","+print_num+","+pretreat_num+","+plan_type);
		System.out.println(dto);
		System.out.println("???????????????????????");
		
		if(plan_type.equals("2") || plan_type.equals("4") || plan_type.equals("3")) {
			if(arrange_num>print_num) {
				return Result.failResult("输入的整理产量大于印花产量，请重新输入"); 
			}
			else {
				int n = arrangeDao.updStatus(dto,currDate,currUserName);
				if(n>0) {
					return Result.successResult("已整理成功");
				} 
				else {
					return Result.failResult("已整理失败"); 
				}
			}
		}
		if(plan_type.equals("1")) {
			if(arrange_num>pretreat_num) {
				return Result.failResult("输入的整理产量大于前处理产量，请重新输入"); 
			}
			else {
				int n = arrangeDao.updStatus(dto,currDate,currUserName);
				if(n>0) {
					return Result.successResult("已整理成功");
				} 
				else {
					return Result.failResult("已整理失败"); 
				}
			}
		}
		return null;
		
		
	}


	

	
	
	
}
