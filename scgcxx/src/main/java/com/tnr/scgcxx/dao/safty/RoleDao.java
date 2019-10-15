package com.tnr.scgcxx.dao.safty;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.RoleDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.Rm;
import com.tnr.scgcxx.model.Role;

public interface RoleDao {
	
	List<Role> findRolePage(RoleDto dto);
	@Select("select * from sys_role where ro_id=#{ro_id}")
	Role isExist(Integer ro_id);
	@Insert("insert into sys_role (ro_id,ro_name,ro_remark,ro_status) value (#{ro_id},#{ro_name},#{ro_remark},'00')")
	int roleDoAdd(RoleDto dto);
	@Update("update sys_role set ro_name=#{ro_name},ro_remark=#{ro_remark} where ro_id=#{ro_id}")
	int roleDoUpdate(RoleDto dto);
	int roleDoStatus(RoleDto dto);
	@Delete("delete from sys_role where ro_id=#{ro_id}")
	int roledoDele(String co_id);
	int roledoDeles(@Param("ro_ids") String[] ro_ids);
	//List<Module> findRleRemarkList();
	@Select("select * from sys_module")
	List<Module> findModuleList();
	
	@Insert("insert into sys_rm (m_id,ro_id) values (#{param1},#{roid})")
	int roleAddModule( Integer m_id, @Param("roid")Integer ro_id);
	@Select("select m_id from sys_rm where ro_id=#{ro_id}")
	List<Integer> findModuleListById(Integer ro_id);
	@Delete("delete from sys_rm where m_id=#{mid} and ro_id=#{roid}")
	int roleReduceModule(@Param("mid")Integer mid, @Param("roid")Integer ro_id);
	@Delete("delete from sys_rm where ro_id=#{ro_id}")
	void roleDeletsModule(Integer ro_id);
	
	
}
