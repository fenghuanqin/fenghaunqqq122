package com.tnr.scgcxx.service.info.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.info.CustomerDao;
import com.tnr.scgcxx.dto.CustomerDto;
import com.tnr.scgcxx.model.Customer;
import com.tnr.scgcxx.service.info.CustomerService;
import com.tnr.scgcxx.util.Utils;





@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerDao customerDao;
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	@Override
	public Map<String, Object> getcusPage(CustomerDto dto) {
		/*
		 * PageInfo<Customer> page =Utils.createPageInfo( dto, ()->{ return
		 * customerDao.findCusList(dto);} ); 
		 * return Utils.convert2PageData(page);
		 */
		return Utils.createPageMap(
				dto,
				()->{ return
						  customerDao.findCusList(dto);});
				
	}
	
	
	
	
	@Override
	public int exctCustomerDoAdd(CustomerDto dto) {
		int n =customerDao.customerAdd(dto);
		return n;
	}
	@Override
	public int exctCustomerDoUpdate(CustomerDto dto) {
		int n = customerDao.customerUpd(dto);
		return n;
	}
	@Override
	public int excutCustomerDelete(String cus_id) {
		int n = customerDao.customerDel(cus_id);
		return n;
	}
	@Override
	public int exctCustomerDelets(String[] cus_ids) {
		int n = customerDao.customerDelets(cus_ids);
		return n;
	}
	
	@Override
	public Customer isExist(Integer cus_id) {
		Customer cus=customerDao.isExct(cus_id);
		return cus;
	}
	
	@Override
	public int exctCustomerDoSure(CustomerDto dto) {
		int n = customerDao.customerDoSure(dto);
		return n;
	}
	@Override
	public int exctCustomerDoStart(CustomerDto dto) {
		int n = customerDao.customerDoStart(dto);
		return n;
	}
	@Override
	public int exctCustomerDoDisable(CustomerDto dto) {
		int n = customerDao.customerDoDisable(dto);
		return n;
	}
	@Override
	public int exctCustomerDoTombstone(CustomerDto dto) {
		int n = customerDao.customerDoTombstone(dto);
		return n;
	}
	
	
	
	 

}
