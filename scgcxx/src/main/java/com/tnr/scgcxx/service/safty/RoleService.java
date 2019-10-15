package com.tnr.scgcxx.service.safty;

import java.util.List;
import java.util.Map;

import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.RoleDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.Rm;
import com.tnr.scgcxx.model.Role;

public interface RoleService {

	Map<String, Object> getRolePage(RoleDto dto);
	
	Role isExist(Integer ro_id);

	int exctRoleDoAdd(RoleDto dto);

	int exctroleDoUpdate(RoleDto dto);

	int exctRoleStatus(RoleDto dto);

	int exctRoleDoDele(String ro_id);

	int exctRoleDelets(String[] ro_ids);

	//Map<String, String> exitRmarkList();

	List<Module> getModuleList();

	Result exitDoAddModule(List<Integer> m_id, Integer ro_id);

	List<Integer> getModuleListById(Integer ro_id);

	Result exitDoReduceModule(List<Integer> m_id, Integer ro_id);

	

	

}
