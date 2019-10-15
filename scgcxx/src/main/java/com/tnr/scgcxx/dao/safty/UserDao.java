package com.tnr.scgcxx.dao.safty;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.model.Role;
import com.tnr.scgcxx.model.User;

public interface UserDao {

	List<User> findUserPage(UserDto dto);
	@Select("select * from sys_user where u_id=#{u_id}")
	User findUserById(String u_id);
	@Insert("insert into sys_user (u_id,u_name,u_pwd,u_status) value (#{u_id},#{u_name},#{u_pwd},'00')")
	int doAddUser(UserDto dto);
	@Update("update sys_user set u_name=#{u_name},u_pwd=#{u_pwd},u_status='00' where u_id=#{u_id} and u_status='00'")
	int doUpdate(UserDto dto);
	int exctDoStatus(UserDto dto);
	@Delete("delete from sys_user where u_id=#{u_id}")
	int exctDoDele(String u_id);
	int exctDoDelets(@Param("u_ids") String[] u_ids);
	@Select("select * from sys_role")
	List<Role> findRoleList();
	@Delete("delete from sys_ur where u_id=#{u_id}")
	void exctUserDeletesRole(String u_id);
	@Insert("insert into sys_ur (u_id,ro_id) values(#{uid},#{roid})")
	int exctUserAddRole(@Param("uid")String u_id, @Param("roid")Integer ro_id);
	@Select("select ro_id from sys_ur where u_id=#{u_id}")
	List<Integer> findRoleListById(String u_id);
	
	
	

}
