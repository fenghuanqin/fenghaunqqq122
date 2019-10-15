package com.tnr.scgcxx.controller.info;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.CustomerDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.exception.SysException;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.service.info.CustomerService;

@RestController
@RequestMapping("/info/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/cus")
	public Map<String, Object> getcusPage(CustomerDto dto) {

		return customerService.getcusPage(dto);

	}

	@PostMapping("/cus")
	public Result exctCustomerDoAdd(@RequestBody CustomerDto dto) {
		
			if(dto.getCus_id()==null) {
				return Result.failResult("编号未填写");
			}
			if(dto.getCus_name()==null || dto.getCus_name()=="") {
				return Result.failResult("客户名称未填写");
			}
		Customer cus = customerService.isExist(dto.getCus_id());
			if (cus != null) {
				return Result.failResult("此ID已存在");
			}
			
			int cnt = customerService.exctCustomerDoAdd(dto);
			if (cnt != 0) {
				return Result.successResult("增加成功");
			} else {
				return Result.failResult("增加失败");
			}
		
	}

	@PutMapping("/cus")
	public Result exctCustomerDoUpdate(@RequestBody CustomerDto dto) {
		System.out.println(dto.getCus_id()+","+dto.getCus_name()+","+dto.getCus_remark()+","+dto.getCus_status());
		int cnt = customerService.exctCustomerDoUpdate(dto);

		if (cnt > 0) {
			return Result.successResult("修改成功");
		} else {
			return Result.failResult("修改失败");
		}

	}

	@DeleteMapping("/cus/{cus_id}")
	public Result exctCustomerDelete(@PathVariable("cus_id") String cus_id) {

		int cnt = customerService.excutCustomerDelete(cus_id);
		if (cnt > 0) {
			return Result.successResult("删除成功");
		} else {
			return Result.failResult("删除失败");
		}

	}

	@DeleteMapping("/cus")
	public Result exctCustomerDelets(@RequestBody String[] cus_ids) {
		int cnt = customerService.exctCustomerDelets(cus_ids);
		if (cnt > 1) {
			return Result.successResult("多删成功");
		} else {
			return Result.failResult("多删失败");
		}
	}
	
	@PutMapping("/sure")
	public Result excuteSure(@RequestBody CustomerDto dto) {
		int cnt = customerService.exctCustomerDoSure(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	
	@PutMapping("/start")
	public Result excuteStart(@RequestBody CustomerDto dto) {
		int cnt = customerService.exctCustomerDoStart(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	
	
	@PutMapping("/disable")
	public Result excuteDisable(@RequestBody CustomerDto dto) {
		int cnt = customerService.exctCustomerDoDisable(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	
	@PutMapping("/tombstone")
	public Result excuteTombstone(@RequestBody CustomerDto dto) {
		int cnt = customerService.exctCustomerDoTombstone(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}

}
