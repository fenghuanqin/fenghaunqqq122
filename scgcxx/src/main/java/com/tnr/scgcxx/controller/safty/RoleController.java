package com.tnr.scgcxx.controller.safty;

import java.security.KeyStore.Entry;
import java.util.Iterator;
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

import com.tnr.scgcxx.dto.RoleDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.RoleDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.Rm;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.service.safty.RoleService;

@RestController
@RequestMapping("/safty/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/ro")
	public Map<String,Object> getRolePage(RoleDto dto){
		return roleService.getRolePage(dto);
	}
	@PostMapping("/ro")
	public Result exctRoleDoAdd(@RequestBody RoleDto dto) {
		System.out.println(dto.getRo_id());
		System.out.println(dto.getRo_name());
		System.out.println(dto.getRo_remark());
		if (dto.getRo_id() == null) {
			/*
			 * System.out.println(dto.getRo_id()); System.out.println(dto.getRo_name());
			 * System.out.println(dto.getRo_remark());
			 */
			return Result.failResult("编号未填写");
		}
		if (dto.getRo_name() == null || dto.getRo_name() == "") {
			return Result.failResult("客户名称未填写");
		}
		Role cus = roleService.isExist(dto.getRo_id());
		if (cus != null) {
			return Result.failResult("此ID已存在");
		}

		int cnt = roleService.exctRoleDoAdd(dto);
		if (cnt != 0) {
			return Result.successResult("增加成功");
		} else {
			return Result.failResult("增加失败");
		}
		
	}
		
	@PutMapping("/ro")
	public Result exctRoleDoUpdate(@RequestBody RoleDto dto) {
		int cnt = roleService.exctroleDoUpdate(dto);

		if (cnt > 0) {
			return Result.successResult("修改成功");
		} else {
			return Result.failResult("修改失败");
		}
	}
	
	@PutMapping("/rol")
	public Result exctRoleSatus(@RequestBody RoleDto dto) {
		int cnt = roleService.exctRoleStatus(dto);

		if (cnt > 0) {
			return Result.successResult("修改状态成功");
		} else {
			return Result.failResult("修改状态失败");
		}
	}
	@DeleteMapping("/ro/{ro_id}")
	public Result exctRoleDelete(@PathVariable("ro_id") String ro_id) {
		
		int cnt = roleService.exctRoleDoDele(ro_id);
		if (cnt > 0) {
			return Result.successResult("删除成功");
		} else {
			return Result.failResult("删除失败");
		}
		
	}  
	@DeleteMapping("/ro")
	public Result excutRoleDeletes(@RequestBody String[] ro_ids) {
		int cnt = roleService.exctRoleDelets(ro_ids);
		if (cnt > 1) {
			return Result.successResult("多删成功");
		} else {
			return Result.failResult("多删失败");
		}
	}
	@GetMapping("/rol")
	public List<Module> getModuleList(){
		
		return roleService.getModuleList();
	}
	@PostMapping("/rol")
	public Result exitAddModule(@RequestBody Map<String,Object> map ) {
		
		
		System.out.println(map.get("m_id").getClass());//获得数据的类型
		
		System.out.println(map.get("ro_id").getClass());
		
		List<Integer> m_id = (List<Integer>)map.get("m_id");
		Integer ro_id = (Integer)map.get("ro_id");
 
		return  roleService.exitDoAddModule(m_id, ro_id);
	}
	@GetMapping("/id")
	public List<Integer> getRoleModuleList(Integer ro_id){
		//System.out.println(ro_id);
		List<Integer> list = roleService.getModuleListById(ro_id);
		/*
		 * for(Integer r : list) { System.out.println(r); }
		 */
		
		return list;
	}
	@DeleteMapping("/rol")
	public Result exitReduceModule(@RequestBody Map<String,Object> map) {
		List<Integer> m_id = (List<Integer>)map.get("m_id");
		Integer ro_id = (Integer)map.get("ro_id");
		return roleService.exitDoReduceModule(m_id,ro_id);
	}
	 
	
}
