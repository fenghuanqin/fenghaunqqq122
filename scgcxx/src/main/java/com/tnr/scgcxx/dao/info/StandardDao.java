package com.tnr.scgcxx.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.StandardDto;
import com.tnr.scgcxx.model.Standard;

public interface StandardDao {
	
	List<Standard> findStandardList(StandardDto dto);
	@Select("select * from info_standard where standard_id=#{standard_id}")
	Standard isExist(Integer standard_id);
	@Insert("insert into info_standard (standard_id,standard_name,standard_remark,standard_status) value (#{standard_id},#{standard_name},#{standard_remark},'00') ")
	int exctDoAdd(StandardDto dto);
	@Update("update info_standard set standard_name=#{standard_name},standard_remark=#{standard_remark} where standard_id=#{standard_id}")
	int exctDoUpda(StandardDto dto);

	int exctDoStatus(StandardDto dto);
	@Delete("delete from info_standard where standard_id=#{standard_id}")
	int exctDoDele(String standard_id);

	int exctDoDelets(@Param("standard_ids") String[] standard_ids);

}
