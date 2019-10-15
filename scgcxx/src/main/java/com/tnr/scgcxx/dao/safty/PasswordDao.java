package com.tnr.scgcxx.dao.safty;

import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.PasswordUser;


public interface PasswordDao {
	@Update("update sys_user set u_pwd=#{u_pwd} where u_id=#{u_id}")
	int updatePassword(PasswordUser dto);
	

}
