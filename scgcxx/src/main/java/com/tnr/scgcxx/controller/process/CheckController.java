package com.tnr.scgcxx.controller.process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.ProductDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Product;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.CheckService;





@RestController
@RequestMapping("/process/check")
public class CheckController {
	@Autowired
	private CheckService checkService;
	@GetMapping("/sele")
	public Map<String,Object> getcheck(ProcessDto dto){
		/*
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 * System.out.println(dto.toString());
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 */
		return checkService.getCheck(dto);
	}
	
	@GetMapping("/plan")
	public List<Plan> getPlan(){
		return checkService.getPlan();
	}
	
	@GetMapping("/standard")
	public List<Standard> getStandard(){
		List<Standard> standardList = checkService.getStandardList();
		return standardList;
	}
	@GetMapping("/cus")
	public List<Customer> getCustomer(){
		return checkService.getCustomer();
	}
	@GetMapping("/co")
	public List<Color> getColor(){
		return checkService.getColor();
	}
	@GetMapping("/oneplan")
	public Plan getOnePlan(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		
		return checkService.getOnePlan(plan_id);
	}
	@PostMapping("/add")
	public Result exctAddProcess(@RequestBody ProcessDto dto) {
		
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return checkService.exctAdd(dto,currDate,currUserName);
	}
	@GetMapping("/oneplanup")
	public Plan getOnePlanup(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		
		return checkService.getOnePlanUp(plan_id);
	}
	@PutMapping("/upd")
	public Result exctUpdProcess(@RequestBody ProcessDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return checkService.exctUpd(dto,currDate,currUserName);
	}
	@PutMapping("/checkOn")
	public Result exctUpdStatus(@RequestBody ProductDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		System.out.println("----------------------");
		System.out.println(dto.toString());
		
		System.out.println("----------------------");
		return checkService.exctUpdStatus(dto,currDate,currUserName);
	}
	@DeleteMapping("dele/{process_id}")
	public Result exctDele(@PathVariable("process_id") Double process_id) {
		return checkService.exctDele(process_id);
	}
	@DeleteMapping("deles")
	public Result exctDeletes(@RequestBody Double[] process_ids) {
		return checkService.exctDeletes(process_ids);
	}
	@PostMapping("/addcheck")
	public List<Product> exctAddCheck(@RequestBody ProcessDto dto) {
		//System.out.println(dto.getProcess_id()+","+dto.getProcess_cus()+","+dto.getProcess_std()+","+dto.getProcess_color());
		return checkService.excAddCheck(dto);
	}

}
