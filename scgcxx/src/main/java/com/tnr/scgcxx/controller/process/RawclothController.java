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
import com.tnr.scgcxx.service.process.RawclothService;
@RestController
@RequestMapping("/process/rawcloth")
public class RawclothController {
	@Autowired
	private RawclothService rawclothService;
	@GetMapping("/sele")
	public Map<String,Object> getRawcloth(ProcessDto dto){
		/*
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 * System.out.println(dto.toString());
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 */
		return rawclothService.getRawcloth(dto);
	}
	@GetMapping("/plan")
	public List<Plan> getPlan(){
		return rawclothService.getPlan();
	}
	
	@GetMapping("/standard")
	public List<Standard> getStandard(){
		List<Standard> standardList = rawclothService.getStandardList();
		return standardList;
	}
	@GetMapping("/cus")
	public List<Customer> getCustomer(){
		return rawclothService.getCustomer();
	}
	@GetMapping("/co")
	public List<Color> getColor(){
		return rawclothService.getColor();
	}
	@GetMapping("/oneplan")
	public Plan getOnePlan(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		/*
		System.out.println("？？？？？？？？？？？？？？？？");
		System.out.println(plan_id);
		System.out.println(dto.toString());
		System.out.println("？？？？？？？？？？？？？？？？");
		*/
		return rawclothService.getOnePlan(plan_id);
	}
	@PostMapping("/add")
	public Result exctAddProcess(@RequestBody ProcessDto dto) {
		/*
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 * System.out.println(dto.getPlan_num());
		 * System.out.println(dto.getGroup_num()); System.out.println(dto.toString());
		 * System.out.println(dto.getProcess_id());
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 */
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return rawclothService.exctAdd(dto,currDate,currUserName);
	}
	@GetMapping("/oneplanup")
	public Plan getOnePlanup(ProcessDto dto){
		Integer plan_id = dto.getPlan_id();
		/*
		System.out.println("？？？？？？？？？？？？？？？？");
		System.out.println(plan_id);
		System.out.println(dto.toString());
		System.out.println("？？？？？？？？？？？？？？？？");
		*/
		return rawclothService.getOnePlanUp(plan_id);
	}
	@PutMapping("/upd")
	public Result exctUpdProcess(@RequestBody ProcessDto dto) {
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		String currUserName=currUser.getUserName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currDate=df.format(new Date());
		
		return rawclothService.exctUpd(dto,currDate,currUserName);
	}
	@PutMapping("/perform")
	public Result exctUpdStatus(@RequestBody ProcessDto dto) {
		
		return rawclothService.exctUpdStatus(dto);
	}
	@DeleteMapping("dele/{process_id}")
	public Result exctDele(@PathVariable("process_id") Double process_id) {
		return rawclothService.exctDele(process_id);
	}
	@DeleteMapping("deles")
	public Result exctDeletes(@RequestBody Double[] process_ids) {
		return rawclothService.exctDeletes(process_ids);
	}
}
