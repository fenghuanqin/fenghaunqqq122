package com.tnr.scgcxx.service.safty.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.safty.RoleDao;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.RoleDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.Rm;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.service.safty.RoleService;
import com.tnr.scgcxx.util.Utils;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Override
	public Map<String, Object> getRolePage(RoleDto dto) {
		PageHelper.startPage(dto);
		List<Role> list = roleDao.findRolePage(dto);
		PageInfo<Role> page = new PageInfo<Role>(list);
		return Utils.convert2PageData(page);
	}
	@Override
	public Role isExist(Integer ro_id) {
		
		return roleDao.isExist(ro_id);
	}

	@Override
	public int exctRoleDoAdd(RoleDto dto) {
		int n = roleDao.roleDoAdd(dto);
		return n;
	}
	
	@Override
	public int exctroleDoUpdate(RoleDto dto) {
		int n = roleDao.roleDoUpdate(dto);
		return n;
	}
	@Override
	public int exctRoleStatus(RoleDto dto) {
		int n = roleDao.roleDoStatus(dto);
		return n;
	}
	@Override
	public int exctRoleDoDele(String ro_id) {
		int n = roleDao.roledoDele(ro_id);
		return n;
	}
	@Override
	public int exctRoleDelets(String[] ro_ids) {
		int n = roleDao.roledoDeles(ro_ids);
		return n;
	}
	/*@Override
	public Map<String, String> exitRmarkList() {
		List<Module> list = roleDao.findRleRemarkList();
		//System.out.println(list);
		Map<String,String> map = new HashMap<String,String>();
		for(Module m : list) {
			
			 * map.put("m_id", m.getM_id().toString()); map.put("m_name", m.getM_name());
			 
			System.out.println(m.getM_id()+","+m.getM_name());
		}
		return map;*/
	@Override
	public List<Module> getModuleList() {
		
		return roleDao.findModuleList();
	}

	@Override
	public Result exitDoAddModule(List<Integer> m_id, Integer ro_id) {
		roleDao.roleDeletsModule(ro_id);
		for(Integer mid : m_id) {
			roleDao.roleAddModule(mid,ro_id); 
		}
		return Result.successResult("权限增加成功");
	}
	@Override
	public List<Integer> getModuleListById(Integer ro_id) {
		
		return roleDao.findModuleListById(ro_id);
	}
	@Override
	public Result exitDoReduceModule(List<Integer> m_id, Integer ro_id) {
		
		
		
		int cnt=0;
		for(Integer mid : m_id) {
	 	cnt = roleDao.roleReduceModule(mid,ro_id);
		}
		return Result.successResult("权限减少成功"+cnt);
	}
		
		
	
	
}
