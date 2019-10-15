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

public interface RowclothDao {
	
	List<com.tnr.scgcxx.model.Process>  findRowclothList(ProcessDto dto);
	@Select("select * from bus_plan where plan_status='1'")
	List<Plan> getPlanList();
	@Select("select * from info_standard")
	List<Standard> findStandardList();
	@Select("select * from info_customer")
	List<Customer> findCustomer();
	@Select("select * from info_color")
	List<Color> findColor();
	
	Plan getOnePlan(Integer plan_id);
	int addProcess(@Param("process_id")Double process_id,@Param("group_num")Double group_num, @Param("dto")ProcessDto dto, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	Plan getOnePlanUp(Integer plan_id);
	//int updProcess(@Param("process_id")Double process_id, @Param("plan_id")Integer plan_id, @Param("process_cus")Integer process_cus, @Param("process_std")Integer process_std, @Param("process_color")Integer process_color,
			//@Param("process_num")Double process_num, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	int updProcess(@Param("process_id")Double process_id, @Param("plan")Plan plan, @Param("process_num")Double process_num, @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	@Update("update bus_process set process_status='05'where process_id=#{dto.process_id}")
	int updStatus(@Param("dto") ProcessDto dto);
	@Delete("delete from bus_process where process_id = #{process_id}") 
	int dele(Double process_id);
	int deletes(@Param("process_ids")Double[] process_ids);
	@Select("select count(process_id)from bus_process")
	Double getCount();
	@Select("SELECT COunt(process_id) from bus_process where plan_id=#{plan_id}")
	int selectPlanIdNum(Integer plan_id);
	
	
	 
	
	
}
