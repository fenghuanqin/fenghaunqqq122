package com.tnr.scgcxx.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.CustomerDto;
import com.tnr.scgcxx.model.Customer;

public interface CustomerDao {

	
	List<Customer> findCusList(CustomerDto dto);
	@Insert("insert into info_customer(cus_id,cus_name,cus_remark,cus_status) value(#{cus_id},#{cus_name},#{cus_remark},'00')")
	int customerAdd(CustomerDto dto);
	@Update("update info_customer set cus_name=#{cus_name},cus_remark=#{cus_remark} where cus_id=#{cus_id}")
	int customerUpd(CustomerDto dto);
	@Delete("delete from info_customer where cus_id=#{cus_id}")
	int customerDel(String cus_id);
	int customerDelets(@Param("cus_ids") String[] cus_ids);
	@Select("select * from info_customer where cus_id=#{cus_id}")
	Customer isExct(Integer cus_id);
	@Update("update info_customer set cus_status='22' where cus_id=#{cus_id} and cus_status='00'")
	int customerDoSure(CustomerDto dto);
	@Update("update info_customer set cus_status='55' where cus_id=#{cus_id} and cus_status='22'")
	int customerDoStart(CustomerDto dto);
	@Update("update info_customer set cus_status='77' where cus_id=#{cus_id} and cus_status='55'")
	int customerDoDisable(CustomerDto dto);
	@Update("update info_customer set cus_status='55' where cus_id=#{cus_id} and cus_status='77'")
	int customerDoTombstone(CustomerDto dto);
	
	
}
