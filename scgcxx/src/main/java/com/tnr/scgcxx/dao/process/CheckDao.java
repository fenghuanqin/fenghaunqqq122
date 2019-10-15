package com.tnr.scgcxx.dao.process;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.ProductDto;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Process;
import com.tnr.scgcxx.model.Product;
import com.tnr.scgcxx.model.Standard;

public interface CheckDao {
	
	List<com.tnr.scgcxx.model.Process>  findCheckList(ProcessDto dto);
	
	
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
	@Update("update bus_process set check_num=#{dto.check_num},check_date=#{currDate},check_person=#{currUserName},process_status='30'where process_id=#{dto.process_id}")
	int updStatusOn(@Param("dto")ProductDto dto,  @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	@Update("update bus_process set check_num=#{dto.check_num},check_date=#{currDate},check_person=#{currUserName},process_status='35'where process_id=#{dto.process_id}")
	int updStatusAfter(@Param("dto")ProductDto dto,  @Param("currDate")String currDate, @Param("currUserName")String currUserName);
	@Delete("delete from bus_process where process_id = #{process_id}") 
	int dele(Double process_id);
	int deletes(@Param("process_ids")Double[] process_ids);

	@Insert("insert into bus_product\r\n" + 
			"	(product_id,process_id,product_cus,product_std,process_color,product_level,product_num,product_status) \r\n" + 
			"	values (#{product_idOne},#{dto.process_id},#{dto.process_cus},#{dto.process_std},#{dto.process_color},'01',0,'30'),\r\n" + 
			"		   (#{product_idTwo},#{dto.process_id},#{dto.process_cus},#{dto.process_std},#{dto.process_color},'02',0,'30'),\r\n" + 
			"		   (#{product_idThree},#{dto.process_id},#{dto.process_cus},#{dto.process_std},#{dto.process_color},'03',0,'30'),\r\n" + 
			"		   (#{product_idOther},#{dto.process_id},#{dto.process_cus},#{dto.process_std},#{dto.process_color},'04',0,'30')")
	int addProduct(@Param("product_idOne")Double product_idOne, @Param("product_idTwo")Double product_idTwo, @Param("product_idThree")Double product_idThree, @Param("product_idOther")Double product_idOther, @Param("dto")ProcessDto dto);
 
	//@Select("select * from bus_product where process_id=#{dto.process_id}")
	List<Product> selectProduct(@Param("dto")ProcessDto dto);

	@Update("update bus_product set product_num=#{dto.product_num},product_status='30'where process_id=#{dto.process_id}")
	int upStatusOna(ProductDto dto);
	
}
