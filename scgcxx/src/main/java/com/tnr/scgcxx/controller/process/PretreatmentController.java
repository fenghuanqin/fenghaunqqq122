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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.process.PretreatmentService;

@RestController
@RequestMapping("/process/pretreatment")
public class PretreatmentController {
	@Autowired
	private PretreatmentService pretreatmentService;
	@GetMapping("/sele")
	public Map<String,Object> getPretreatment(ProcessDto dto){
		
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		  System.out.println(dto.toString());
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 
		return pretreatmentService.getPretreatment(dto);
	}
	
	@GetMapping("/plan")
	public List<Plan> getPlan(){
		return pretreatmentService.getPlan();
	}
	
	@GetMapping("/standard")
	public List<Standard> getStandard(){
		List<Standard> standardList = pretreatmentService.getStandardList();
		return standardList;
	}
	@GetMapping("/cus")
	public List<Customer> getCustomer(){
		return pretreatmentService.getCustomer();
	}
	@GetMapping("/co")
	public List<Color> getColor(){
		return pretreatmentService.getColor();
	}
	@GetMapping("/oneplan")
	public Plan getOnePlan(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		
		return pretreatmentService.getOnePlan(plan_id);
	}
	@PostMapping("/add")
	public Result exctAddProcess(@RequestBody ProcessDto dto) {
		
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return pretreatmentService.exctAdd(dto,currDate,currUserName);
	}
	@GetMapping("/oneplanup")
	public Plan getOnePlanup(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		
		return pretreatmentService.getOnePlanUp(plan_id);
	}
	@PutMapping("/upd")
	public Result exctUpdProcess(@RequestBody ProcessDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return pretreatmentService.exctUpd(dto,currDate,currUserName);
	}
	@PutMapping("/pretreatment")
	public Result exctUpdStatus(@RequestBody ProcessDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		return pretreatmentService.exctUpdStatus(dto,currDate,currUserName);
	}
	@DeleteMapping("dele/{process_id}")
	public Result exctDele(@PathVariable("process_id") Double process_id) {
		return pretreatmentService.exctDele(process_id);
	}
	@DeleteMapping("deles")
	public Result exctDeletes(@RequestBody Double[] process_ids) {
		return pretreatmentService.exctDeletes(process_ids);
	}
	
}
