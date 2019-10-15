package com.tnr.scgcxx.service.plan;

import java.util.List;
import java.util.Map;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.PlanDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.model.Standard;

public interface PlanService {

	Map<String, Object> getPlanPage(PlanDto dto);

	Result planAdd(PlanDto dto, String currDate, String currUserName);

	Result planUpd(PlanDto dto, String currDate, String currUserName);

	List<Standard> getStandardList();

	List<Customer> getCustomer();

	List<Color> getColor();

	Result planPerform(PlanDto dto, String currDate, String currUserName);

	Result exctDele(Integer plan_id);

	Result exctDeles(Integer[] plan_ids);

}
