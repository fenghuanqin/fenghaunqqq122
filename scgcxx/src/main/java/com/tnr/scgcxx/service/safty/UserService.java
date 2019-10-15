package com.tnr.scgcxx.service.safty;

import java.util.List;
import java.util.Map;

import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.model.User;

public interface UserService {

	Map<String, Object> getUserPage(UserDto dto);

	User isExist(String u_id);

	int exctUserDoAdd(UserDto dto);

	int exctUserDoUpdate(UserDto dto);

	int exctUserStatus(UserDto dto);

	int exctUserDoDele(String u_id);

	int exctUserDelets(String[] u_ids);

	List<Role> getRoleList();

	Result exctUserAddRole(String u_id,List<Integer> ro_id);

	List<Integer> getRoleListById(String u_id);

}
