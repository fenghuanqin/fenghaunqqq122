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

import com.tnr.scgcxx.dto.StandardDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.info.StandardService;
@RestController
@RequestMapping("/info/standard")
public class StandardContronller {
	@Autowired
	private StandardService standardService;
	@GetMapping("/st")
	public Map<String,Object> getPage(StandardDto dto){
		return standardService.getPage(dto);
		
	}
	
	@PostMapping("/st")
	public Result exctColorDoAdd(@RequestBody StandardDto dto) {

		if (dto.getStandard_id() == null) {
			return Result.failResult("编号未填写");
		}
		if (dto.getStandard_name() == null || dto.getStandard_name() == "") {
			return Result.failResult("客户名称未填写");
		}
		Standard st = standardService.isExist(dto.getStandard_id());
		if (st != null) {
			return Result.failResult("此ID已存在");
		}

		int cnt = standardService.exctStandardDoAdd(dto);
		if (cnt != 0) {
			return Result.successResult("增加成功");
		} else {
			return Result.failResult("增加失败");
		}
	}
	
	@PutMapping("/st")
	public Result exctStandardDoUpdate(@RequestBody StandardDto dto) {
		int cnt = standardService.exctStandardDoUpdate(dto);

		if (cnt > 0) {
			return Result.successResult("修改成功");
		} else {
			return Result.failResult("修改失败");
		}
	}
	
	@PutMapping("/sta")
	public Result exctStandardSatus(@RequestBody StandardDto dto) {
		int cnt = standardService.exctStandardStatus(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	@DeleteMapping("/st/{standard_id}")
	public Result exctStandardDelete(@PathVariable("standard_id") String standard_id) {
		
		int cnt = standardService.exctStandardDoDele(standard_id);
		if (cnt > 0) {
			return Result.successResult("删除成功");
		} else {
			return Result.failResult("删除失败");
		}
		
	}  
	@DeleteMapping("/st")
	public Result excutStandardDeletes(@RequestBody String[] standard_ids) {
		int cnt = standardService.exctStandardDelets(standard_ids);
		if (cnt > 1) {
			return Result.successResult("多删成功");
		} else {
			return Result.failResult("多删失败");
		}
	}

}
