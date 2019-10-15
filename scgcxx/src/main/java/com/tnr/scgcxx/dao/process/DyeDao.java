package com.tnr.scgcxx.dao.process;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Process;
import com.tnr.scgcxx.model.Standard;

public interface DyeDao {
	
	List<com.tnr.scgcxx.model.Process>  findDyeList(ProcessDto dto);
	
	
	@Select("select * from bus_plan")
	List<Plan> getPlanList();
	@Select("select * from info_standard")
	List<Standard> findStandardList();
	@Select("select * from info_customer")
	List<Customer> findCustomer();
	@Select("select * from info_color")
	List<Color> findColor();
	
	Plan getOnePlan(Integer plan_id);
	int addProcess(@Param("dto")ProcessDto dto, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	Plan getOnePlanUp(Integer plan_id);
	//int updProcess(@Param("process_id")Double process_id, @Param("plan_id")Integer plan_id, @Param("process_cus")Integer process_cus, @Param("process_std")Integer process_std, @Param("process_color")Integer process_color,
			//@Param("process_num")Double process_num, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	int updProcess(@Param("process_id")Double process_id, @Param("plan")Plan plan, @Param("process_num")Double process_num, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	@Update("update bus_process set dye_num=#{dto.dye_num},dye_date=#{currDate},dye_person=#{currUserName},process_status='15'where process_id=#{dto.process_id}")
	int updStatus(@Param("dto")ProcessDto dto,  @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	@Delete("delete from bus_process where process_id = #{process_id}") 
	int dele(Double process_id);
	int deletes(@Param("process_ids")Double[] process_ids);
	
	
	
}
