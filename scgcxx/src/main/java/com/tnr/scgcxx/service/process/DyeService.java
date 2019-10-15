package com.tnr.scgcxx.service.process;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Plan;
import com.tnr.scgcxx.model.Standard;

public interface DyeService {

	Map<String, Object> getDye(ProcessDto dto);
	
	List<Plan> getPlan();

	List<Standard> getStandardList();

	List<Customer> getCustomer();

	List<Color> getColor();

	Plan getOnePlan(Integer plan_id);

	Result exctAdd(ProcessDto dto, String currDate, String currUserName);

	

	Plan getOnePlanUp(Integer plan_id);

	Result exctUpd(ProcessDto dto, String currDate, String currUserName);

	Result exctUpdStatus(ProcessDto dto, String currDate, String currUserName);

	Result exctDele(Double process_id);

	Result exctDeletes(Double[] process_ids);
	

	
}
