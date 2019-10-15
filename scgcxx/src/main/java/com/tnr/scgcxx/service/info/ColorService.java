package com.tnr.scgcxx.service.info;

import java.util.Map;

import com.tnr.scgcxx.dto.ColorDto;
import com.tnr.scgcxx.model.Color;

public interface ColorService {

	Map<String, Object> getColorPage(ColorDto dto);

	Color isExist(Integer co_id);

	int exctColorDoAdd(ColorDto dto);

	int exctColorDoUpdate(ColorDto dto);

	int exctColorStatus(ColorDto dto);

	int exctColorDoDele(String co_id);

	int exctColorDelets(String[] co_ids);

}
