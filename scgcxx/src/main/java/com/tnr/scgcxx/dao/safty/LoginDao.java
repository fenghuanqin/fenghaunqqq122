package com.tnr.scgcxx.dao.safty;

import org.apache.ibatis.annotations.Select;

import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.model.User;

public interface LoginDao {
	@Select("select u_id,u_name from sys_user where u_id=#{u_id} and u_pwd=#{u_pwd}")
	User findUser(UserDto dto);
	
}
