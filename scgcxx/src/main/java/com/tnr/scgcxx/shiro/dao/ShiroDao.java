package com.tnr.scgcxx.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.User;

public interface ShiroDao {

	List<Module> findModuleOfUser(String userId);
	
	@Select("select * from sys_user where u_id=#{id}")
	User findUser(String userId);
	@Select("select * from sys_module where m_ismenu=1 and m_status='55' and m_pid is not null ")
	List<Module> findAllSubModules();

}
