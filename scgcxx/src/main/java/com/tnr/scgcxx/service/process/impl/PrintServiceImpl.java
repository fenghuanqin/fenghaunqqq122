package com.tnr.scgcxx.service.process.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.process.PrintDao;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.PrintService;
import com.tnr.scgcxx.util.Utils;
@Service
public class PrintServiceImpl implements PrintService {
	@Autowired
	private PrintDao printDao;
	
	  @Override public Map<String, Object> getPrint(ProcessDto dto) {
	  PageHelper.startPage(dto); 
	  List<com.tnr.scgcxx.model.Process> list=printDao.findPrintList(dto);
	  PageInfo<com.tnr.scgcxx.model.Process> page=new PageInfo<com.tnr.scgcxx.model.Process>(list); 
	  return Utils.convert2PageData(page); 
	  }
	 
	
	@Override
	public List<Plan> getPlan() {
		
		return printDao.getPlanList();
	}
	@Override
	public List<Standard> getStandardList() {
		return printDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return printDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return printDao.findColor();
	}
	@Override
	public Plan getOnePlan(Integer plan_id) {
		Plan plan = printDao.getOnePlan(plan_id);
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
			int n = printDao.addProcess(dto,currDate,currUserName);
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
		Plan plan = printDao.getOnePlanUp(plan_id);
		Double process_num=dto.getGroup_num();
		
		Double process_id=dto.getProcess_id();
		Integer process_cus=plan.getCus_id();
		Integer process_std=plan.getStandard_id();
		Integer process_color=plan.getCo_id();
		
		//int n = printDao.updProcess(process_id,plan_id,process_cus,process_std,process_color,process_num,currDate,currUserName);
		int n = printDao.updProcess(process_id, plan, process_num, currDate, currUserName);
		if(n>0) {
			return Result.successResult("坯布准备修改成功");
		} 
		else {
			return Result.failResult("坯布准备修改失败"); 
		}
	}
	@Override
	public Plan getOnePlanUp(Integer plan_id) {
		Plan plan = printDao.getOnePlanUp(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctDele(Double process_id) {
		int n = printDao.dele(process_id);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}
	@Override
	public Result exctDeletes(Double[] process_ids) {
		int n = printDao.deletes(process_ids);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}


	@Override
	public Result exctUpdStatus(ProcessDto dto, String currDate, String currUserName) {
		
		Double print_num=dto.getPrint_num();
		Double dye_num=dto.getDye_num();
		Double pretreat_num=dto.getPretreat_num();
		String plan_type=dto.getPlan_type();
		System.out.println("???????????????????????");
		System.out.println(print_num+","+dye_num+","+pretreat_num+","+plan_type);
		//System.out.println(dto);
		System.out.println("???????????????????????");
		
		if(plan_type.equals("2") || plan_type.equals("4")) {
			if(print_num>dye_num) {
				return Result.failResult("输入的印花产量大于染色产量，请重新输入"); 
			}
			else {
				int n = printDao.updStatus(dto,currDate,currUserName);
				if(n>0) {
					return Result.successResult("已印花成功");
				} 
				else {
					return Result.failResult("已印花失败"); 
				}
			}
		}
		if(plan_type.equals("3")) {
			if(print_num>pretreat_num) {
				return Result.failResult("输入的印花产量大于染色产量，请重新输入"); 
			}
			else {
				int n = printDao.updStatus(dto,currDate,currUserName);
				if(n>0) {
					return Result.successResult("已印花成功");
				} 
				else {
					return Result.failResult("已印花失败"); 
				}
			}
		}
		return null;
		
		
		
		
	}


	

	
	
	
}
