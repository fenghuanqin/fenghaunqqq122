package com.tnr.scgcxx.service.process;

import java.util.List;
import java.util.Map;

import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;

public interface RawclothService {

	Map<String, Object> getRawcloth(ProcessDto dto);
	
	List<Plan> getPlan();

	List<Standard> getStandardList();

	List<Customer> getCustomer();

	List<Color> getColor();

	Plan getOnePlan(Integer plan_id);

	Result exctAdd(ProcessDto dto, String currDate, String currUserName);

	Result exctUpd(ProcessDto dto, String currDate, String currUserName);

	Plan getOnePlanUp(Integer plan_id);

	Result exctUpdStatus(ProcessDto dto);

	Result exctDele(Double process_id);

	Result exctDeletes(Double[] process_ids);

	


}
