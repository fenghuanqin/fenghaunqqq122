package com.tnr.scgcxx.dao.plan;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.tnr.scgcxx.dto.PlanDto;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;

public interface PlanDao {

	List<Plan> findPageList(PlanDto dto);
	@Insert("insert into bus_plan (plan_id,standard_id,cus_id,co_id,plan_xh,plan_month,plan_num,plan_type,plan_date,plan_person,plan_status) values (#{dto.plan_id},#{dto.standard_id},#{dto.cus_id},#{dto.co_id},#{dto.plan_xh},#{dto.plan_month},#{dto.plan_num},#{dto.plan_type},#{currDate},#{currUserName},'0')")
	int add(@Param("dto")PlanDto dto,@Param("currDate")String currDate ,@Param("currUserName")String currUserName );
	@Update("update bus_plan set standard_id=#{dto.standard_id},cus_id=#{dto.cus_id},co_id=#{dto.co_id},plan_xh=#{dto.plan_xh},plan_month=#{dto.plan_month},plan_num=#{dto.plan_num},plan_type=#{dto.plan_type},plan_date=#{currDate},plan_person=#{currUserName} where plan_id=#{dto.plan_id}")
	int upd(@Param("dto")PlanDto dto,@Param("currDate")String currDate ,@Param("currUserName")String currUserName );
	@Select("select * from info_standard")
	List<Standard> findStandardList();
	@Select("select * from info_customer")
	List<Customer> findCustomer();
	@Select("select * from info_color")
	List<Color> findColor();
	@Update("update bus_plan set plan_status='1',plan_date=#{currDate},plan_person=#{currUserName} where plan_id=#{dto.plan_id}")
	int updstatus(@Param("dto")PlanDto dto,@Param("currDate")String currDate ,@Param("currUserName")String currUserName );
	@Delete("delete from bus_plan where plan_id=#{plan_id} ")
	int delePlan(Integer plan_id);
	int delesPlan(@Param("plan_ids") Integer[] plan_ids);
	//@Select("select * from info_standard where standard_id=#{standard_id}")
	//Standard findStandard(Integer standard_id);
	

}
