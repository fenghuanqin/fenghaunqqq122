package com.tnr.scgcxx.service.safty.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.safty.UserDao;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.model.User;
import com.tnr.scgcxx.service.safty.UserService;
import com.tnr.scgcxx.util.Utils;
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDao userDao;
	@Override
	public Map<String, Object> getUserPage(UserDto dto) {
		PageHelper.startPage(dto);
		List<User> list = userDao.findUserPage(dto);
		PageInfo<User> page = new PageInfo<User>(list);
		return Utils.convert2PageData(page);
		
	}
	@Override
	public User isExist(String u_id) {
		return userDao.findUserById(u_id);
	}
	@Override
	public int exctUserDoAdd(UserDto dto) {
		int n = userDao.doAddUser(dto);
		return n;
	}
	@Override
	public int exctUserDoUpdate(UserDto dto) {
		int n = userDao.doUpdate(dto);
		return n;
	}
	@Override
	public int exctUserStatus(UserDto dto) {
		int n = userDao.exctDoStatus(dto);
		return n;
	}
	@Override
	public int exctUserDoDele(String u_id) {
		int n = userDao.exctDoDele(u_id);
		return n;
	}
	@Override
	public int exctUserDelets(String[] u_ids) {
		int n = userDao.exctDoDelets(u_ids);
		return n;
	}
	@Override
	public List<Role> getRoleList() {
		
		return userDao.findRoleList();
	}
	@Override
	public Result exctUserAddRole( String u_id,List<Integer> ro_id) {
		
		userDao.exctUserDeletesRole(u_id);
		int cnt = 0;
		for(Integer roid : ro_id) {
			cnt = userDao.exctUserAddRole(u_id,roid);
		}
		return Result.successResult("用户添加角色成功"+cnt);
	}
	
	@Override
	public List<Integer> getRoleListById(String u_id) {
		return userDao.findRoleListById(u_id);
	}

	
}
