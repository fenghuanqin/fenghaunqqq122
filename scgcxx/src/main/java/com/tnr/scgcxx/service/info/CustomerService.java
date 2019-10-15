package com.tnr.scgcxx.service.info;

import java.util.Map;

import com.tnr.scgcxx.dto.CustomerDto;
import com.tnr.scgcxx.model.Customer;

public interface CustomerService {

	Map<String, Object> getcusPage(CustomerDto dto);

	int exctCustomerDoAdd(CustomerDto dto);

	int exctCustomerDoUpdate(CustomerDto dto);

	int excutCustomerDelete(String cus_id);

	int exctCustomerDelets(String[] cus_ids);


	Customer isExist(Integer cus_id);

	int exctCustomerDoSure(CustomerDto dto);

	int exctCustomerDoStart(CustomerDto dto);

	int exctCustomerDoDisable(CustomerDto dto);

	int exctCustomerDoTombstone(CustomerDto dto);

	
	
}
