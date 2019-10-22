package com.tnr.scgcxx.service.process.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgc.base.Time;
import com.tnr.scgcxx.dao.process.CheckDao;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.ProductDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Product;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.ArrangeService;
import com.tnr.scgcxx.service.process.CheckService;
import com.tnr.scgcxx.service.process.PrintService;
import com.tnr.scgcxx.util.Utils;
@Service
public class CheckServiceImpl implements CheckService {
	@Autowired
	private CheckDao checkDao;
	
	  @Override public Map<String, Object> getCheck(ProcessDto dto) {
	  PageHelper.startPage(dto); 
	  List<com.tnr.scgcxx.model.Process> list=checkDao.findCheckList(dto);
	  PageInfo<com.tnr.scgcxx.model.Process> page=new PageInfo<com.tnr.scgcxx.model.Process>(list); 
	  return Utils.convert2PageData(page); 
	  }
	 
	
	@Override
	public List<Plan> getPlan() {
		
		return checkDao.getPlanList();
	}
	@Override
	public List<Standard> getStandardList() {
		return checkDao.findStandardList();
	}
	@Override
	public List<Customer> getCustomer() {
		return checkDao.findCustomer();
	}
	@Override
	public List<Color> getColor() {
		
		return checkDao.findColor();
	}
	@Override
	public Plan getOnePlan(Integer plan_id) {
		Plan plan = checkDao.getOnePlan(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctAdd(ProcessDto dto, String currDate, String currUserName) {
		if(dto.getGroup_num()>dto.getPlan_num()) {
			return Result.failResult("坯布准备添加失败，坯布分组产量大于计划产量,请重新输入坯布分组数量");
		}
		else {
			int n = checkDao.addProcess(dto,currDate,currUserName);
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
		Plan plan = checkDao.getOnePlanUp(plan_id);
		Double process_num=dto.getGroup_num();
		
		Double process_id=dto.getProcess_id();
		Integer process_cus=plan.getCus_id();
		Integer process_std=plan.getStandard_id();
		Integer process_color=plan.getCo_id();
		
		//int n = checkDao.updProcess(process_id,plan_id,process_cus,process_std,process_color,process_num,currDate,currUserName);
		int n = checkDao.updProcess(process_id, plan, process_num, currDate, currUserName);
		if(n>0) {
			return Result.successResult("坯布准备修改成功");
		} 
		else {
			return Result.failResult("坯布准备修改失败"); 
		}
	}
	@Override
	public Plan getOnePlanUp(Integer plan_id) {
		Plan plan = checkDao.getOnePlanUp(plan_id);
		
		return plan;
	}
	
	@Override
	public Result exctDele(Double process_id) {
		int n = checkDao.dele(process_id);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}
	@Override
	public Result exctDeletes(Double[] process_ids) {
		int n = checkDao.deletes(process_ids);
		if(n>0) {
			return Result.successResult("印花删除成功");
		} 
		else {
			return Result.failResult("印花删除失败"); 
		}
	}


	@Override
	public Result exctUpdStatusOn(ProductDto dto, String currDate, String currUserName) {
		
		Double arrange_num=dto.getArrange_num();
		Double product_num=dto.getProduct_numOne()+dto.getProduct_numTwo()+dto.getProduct_numThree()+dto.getProduct_numOther();
		//Double dye_num=dto.getDye_num();
		
	
		/*
		 * String plan_type=dto.getPlan_type();
		 * System.out.println("???????????????????????");
		 * System.out.println(arrange_num+","+plan_type+","+check_num);
		 * System.out.println(dto); System.out.println("???????????????????????");
		 */
			if(product_num<arrange_num) {
				
				int n = checkDao.updStatusOn(dto,currDate,currUserName);
				int m = checkDao.upStatusOnProductOne(dto.getProduct_numOne(),dto);
				int o = checkDao.upStatusOnProductTwo(dto.getProduct_numTwo(),dto);
				int p = checkDao.upStatusOnProductThree(dto.getProduct_numThree(),dto);
				int q = checkDao.upStatusOnProductOther(dto.getProduct_numOther(),dto);
				if(n==1 && m==1 && o==1 && p==1 && q==1) {
					return Result.successResult("质检中成功");
				} 
				else {
					return Result.failResult("质检中失败"); 
				}
			}
			
			if(product_num>arrange_num) {
				return Result.failResult("输入的质检总量大于整理产量，请重新输入"); 
			}
			else {
				return Result.failResult("输入的质检总量等于于整理产量，请点击质检完成"); 
			}
		/*
		 * else { int n = checkDao.updStatusAfter(dto,currDate,currUserName); if(n>0) {
		 * return Result.successResult("已质检成功"); } else { return
		 * Result.failResult("已质检失败"); } }
		 */
			
		
	}


	@Override
	public List<Product> excAddCheck(ProcessDto dto) {
		double d1=(double)Time.getDate(new Date());
		Double product_idOne=Double.valueOf(d1);
		//System.out.println(product_idOne);
		double d2=(double)Time.getDate(new Date());
		Double product_idTwo=Double.valueOf(d2+1);
		//System.out.println(product_idTwo);
		double d3=(double)Time.getDate(new Date());
		Double product_idThree=Double.valueOf(d3+2);
		//System.out.println(product_idThree);
		double d4=(double)Time.getDate(new Date());
		Double product_idOther=Double.valueOf(d4+3);
		//System.out.println(product_idOther);
		List<Product> listOne= checkDao.selectProductOne(dto);
		if(listOne.isEmpty()) {
			int n = checkDao.addProduct(product_idOne,product_idTwo,product_idThree,product_idOther,dto);
			System.out.println("插入数据 的影响行数为"+n);
			List<Product> list= checkDao.selectProduct(dto); 
			/*for(Product p : list) {
				System.out.println(p.toString());
			}*/
			return list;
		}
		else {
			List<Product> list= checkDao.selectProduct(dto); 
			/*for(Product p : list) {
				System.out.println(p.toString());
			}*/
			return list;
		}
		
		
	}


	

	@Override
	public Result exctUpdStatusAfter(ProductDto dto, String currDate, String currUserName) {
		Double arrange_num=dto.getArrange_num();
		Double product_num=dto.getProduct_numOne()+dto.getProduct_numTwo()+dto.getProduct_numThree()+dto.getProduct_numOther();
		//Double dye_num=dto.getDye_num();
		
		System.out.println("进入业务层");
		
		 //String plan_type=dto.getPlan_type();
		  System.out.println("???????????????????????");
		  System.out.println(arrange_num+","+product_num);
		  System.out.println(dto); System.out.println("???????????????????????");
		 
			if(product_num<arrange_num) {
				return Result.failResult("输入的质检总量小于整理产量，请点击保存"); 
			}
			
			if(product_num>arrange_num) {
				return Result.failResult("输入的质检总量大于整理产量,请重新输入"); 
			}
			else{
				System.out.println("即将进入道层");
				int n = checkDao.updStatusAfter(dto,currDate,currUserName);
				System.out.println("影响行数为n"+n);
				int m = checkDao.upStatusAfterProductOne(dto.getProduct_numOne(),dto);
				System.out.println("影响行数为m"+m);
				int o = checkDao.upStatusAfterProductTwo(dto.getProduct_numTwo(),dto);
				System.out.println("影响行数为o"+o);
				int p = checkDao.upStatusAfterProductThree(dto.getProduct_numThree(),dto);
				System.out.println("影响行数为p"+p);
				int q = checkDao.upStatusAfterProductOther(dto.getProduct_numOther(),dto);
				System.out.println("影响行数为q"+q);
				if(product_num == 0) {
					if(n==1 && m==1 && o==1 && p==1 && q==1) {
						return Result.successResult("单次质检成功");
					} 
					else {
						return Result.failResult("单次质检失败"); 
					}
				}else {
					if(n==1 && (m==1 || o==1 || p==1 || q==1)) {
						return Result.successResult("多次质检成功");
					} 
					else {
						return Result.failResult("多次质检失败"); 
					}
				}
				
			}
		/*
		 * else { int n = checkDao.updStatusAfter(dto,currDate,currUserName); if(n>0) {
		 * return Result.successResult("已质检成功"); } else { return
		 * Result.failResult("已质检失败"); } }
		 */
			
	}


	

	
	
	
}
