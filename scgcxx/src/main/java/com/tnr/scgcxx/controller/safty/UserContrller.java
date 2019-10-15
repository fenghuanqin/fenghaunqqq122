package com.tnr.scgcxx.controller.safty;

import java.util.List;
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

import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.model.User;
import com.tnr.scgcxx.service.safty.UserService;
@RestController
@RequestMapping("/safty/user")
public class UserContrller {
	
	@Autowired
	private UserService userService;

	@GetMapping("/u")
	public Map<String, Object> getcusPage(UserDto dto) {

		/*
		 * Map<String,Object> map= userService.getUserPage(dto);
		 * 
		 * for(String key : map.keySet()) { String value = map.get(key).toString();
		 * System.out.println("key:" + key + " vlaue:" + value); }
		 */
		return userService.getUserPage(dto);

	}
	
	@PostMapping("/u")
	public Result exctUserDoAdd(@RequestBody UserDto dto) {

		if (dto.getU_id() == null) {
			return Result.failResult("编号未填写");
		}
		if (dto.getU_name() == null || dto.getU_name() == "") {
			return Result.failResult("客户名称未填写");
		}
		User cus = userService.isExist(dto.getU_id());
		if (cus != null) {
			return Result.failResult("此ID已存在");
		}

		int cnt = userService.exctUserDoAdd(dto);
		if (cnt != 0) {
			return Result.successResult("增加成功");
		} else {
			return Result.failResult("增加失败");
		}
	}
	
	@PutMapping("/u")
	public Result exctUserDoUpdate(@RequestBody UserDto dto) {
		int cnt = userService.exctUserDoUpdate(dto);

		if (cnt > 0) {
			return Result.successResult("修改成功");
		} else {
			return Result.failResult("修改失败");
		}
	}
	
	@PutMapping("/ul")
	public Result exctUserSatus(@RequestBody UserDto dto) {
		int cnt = userService.exctUserStatus(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	@DeleteMapping("/u/{u_id}")
	public Result exctUserDelete(@PathVariable("u_id") String u_id) {
		
		int cnt = userService.exctUserDoDele(u_id);
		if (cnt > 0) {
			return Result.successResult("删除成功");
		} else {
			return Result.failResult("删除失败");
		}
		
	}  
	@DeleteMapping("/u")
	public Result exctUserDeletes(@RequestBody String[] u_ids) {
		int cnt = userService.exctUserDelets(u_ids);
		if (cnt > 1) {
			return Result.successResult("多删成功");
		} else {
			return Result.failResult("多删失败");
		}
	}
	@GetMapping("/show")
	public List<Role> getAllRoleList(){
		return userService.getRoleList();
	}
	@PostMapping("/add")
	public Result exctUserAddRole(@RequestBody Map<String,Object> map) {
		List<Integer> ro_id = (List<Integer>)map.get("ro_id");
		String u_id = (String)map.get("u_id");
		
		return userService.exctUserAddRole(u_id,ro_id);
	}
	@GetMapping("/id")
	public List<Integer> getRoleListById(String u_id){
		return userService.getRoleListById(u_id);
	}
}
