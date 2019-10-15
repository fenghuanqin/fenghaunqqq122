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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.ColorDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.service.info.ColorService;

@RestController
@RequestMapping("/info/color")
public class ColorController {
	@Autowired
	private ColorService colorService;

	@GetMapping("/co")
	public Map<String, Object> getcusPage(ColorDto dto) {

		/*
		 * Map<String,Object> map= colorService.getColorPage(dto);
		 * 
		 * for(String key : map.keySet()) { String value = map.get(key).toString();
		 * System.out.println("key:" + key + " vlaue:" + value); }
		 */
		return colorService.getColorPage(dto);

	}

	@PostMapping("/co")
	public Result exctColorDoAdd(@RequestBody ColorDto dto) {

		if (dto.getCo_id() == null) {
			return Result.failResult("编号未填写");
		}
		if (dto.getCo_name() == null || dto.getCo_name() == "") {
			return Result.failResult("客户名称未填写");
		}
		Color cus = colorService.isExist(dto.getCo_id());
		if (cus != null) {
			return Result.failResult("此ID已存在");
		}

		int cnt = colorService.exctColorDoAdd(dto);
		if (cnt != 0) {
			return Result.successResult("增加成功");
		} else {
			return Result.failResult("增加失败");
		}
	}
	
	@PutMapping("/co")
	public Result exctColorDoUpdate(@RequestBody ColorDto dto) {
		int cnt = colorService.exctColorDoUpdate(dto);

		if (cnt > 0) {
			return Result.successResult("修改成功");
		} else {
			return Result.failResult("修改失败");
		}
	}
	
	@PutMapping("/col")
	public Result exctColorSatus(@RequestBody ColorDto dto) {
		int cnt = colorService.exctColorStatus(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	@DeleteMapping("/co/{co_id}")
	public Result exctColorDelete(@PathVariable("co_id") String co_id) {
		
		int cnt = colorService.exctColorDoDele(co_id);
		if (cnt > 0) {
			return Result.successResult("删除成功");
		} else {
			return Result.failResult("删除失败");
		}
		
	}  
	@DeleteMapping("/co")
	public Result excutColorDeletes(@RequestBody String[] co_ids) {
		int cnt = colorService.exctColorDelets(co_ids);
		if (cnt > 1) {
			return Result.successResult("多删成功");
		} else {
			return Result.failResult("多删失败");
		}
	}
}
