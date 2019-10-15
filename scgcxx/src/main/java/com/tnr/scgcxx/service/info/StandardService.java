package com.tnr.scgcxx.service.info;

import java.util.Map;


import com.tnr.scgcxx.dto.StandardDto;
import com.tnr.scgcxx.model.Standard;

public interface StandardService {

	Map<String, Object> getPage(StandardDto dto);

	Standard isExist(Integer standard_id);
	int exctStandardDoAdd(StandardDto dto);

	int exctStandardDoUpdate(StandardDto dto);

	int exctStandardStatus(StandardDto dto);

	int exctStandardDoDele(String standard_id);

	int exctStandardDelets(String[] standard_ids);

}
