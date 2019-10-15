package com.tnr.scgcxx.dao.info;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tnr.scgcxx.dto.ColorDto;
import com.tnr.scgcxx.model.Color;

public interface ColorDao {

	List<Color> findColorList(ColorDto dto);
	@Select("select * from info_color where co_id=#{co_id}")
	Color isExist(Integer co_id);
	@Insert("insert into info_color (co_id,co_name,co_remark,co_status) value (#{co_id},#{co_name},#{co_remark},'00') ")
	int exctDoAdd(ColorDto dto);
	@Update("update info_color set co_name=#{co_name},co_remark=#{co_remark} where co_id=#{co_id}")
	int exctDoUpda(ColorDto dto);
	int exctDoStatus(ColorDto dto);
	@Delete("delete from info_color where co_id=#{co_id}")
	int exctDoDele(String co_id);
	int exctDoDelets(@Param("co_ids")String[] co_ids);

}
