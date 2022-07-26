package com.tnr.scgcxx.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QueryDto extends PageParam{
	private static final Logger LOG=LoggerFactory.getLogger(CustomerDto.class);
	private Integer company_id;
	private String process_cus;
	private String process_std;
	private Double product_num_One;
	private Double product_num_Two;
	private Double product_num_Three;
	private Double product_num_Other;
	private Double product_num_hege;
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getProcess_cus() {
		return process_cus;
	}
	public void setProcess_cus(String process_cus) {
		this.process_cus = process_cus;
	}
	public String getProcess_std() {
		return process_std;
	}
	public void setProcess_std(String process_std) {
		this.process_std = process_std;
	}
	public Double getProduct_num_One() {
		return product_num_One;
	}
	public void setProduct_num_One(Double product_num_One) {
		this.product_num_One = product_num_One;
	}
	public Double getProduct_num_Two() {
		return product_num_Two;
	}
	public void setProduct_num_Two(Double product_num_Two) {
		this.product_num_Two = product_num_Two;
	}
	public Double getProduct_num_Three() {
		return product_num_Three;
	}
	public void setProduct_num_Three(Double product_num_Three) {
		this.product_num_Three = product_num_Three;
	}
	public Double getProduct_num_Other() {
		return product_num_Other;
	}
	public void setProduct_num_Other(Double product_num_Other) {
		this.product_num_Other = product_num_Other;
	}
	public Double getProduct_num_hege() {
		return product_num_hege;
	}
	public void setProduct_num_hege(Double product_num_hege) {
		this.product_num_hege = product_num_hege;
	}
	
	@Override
	public String toString() {
		try {
			String json = new ObjectMapper().writeValueAsString(this);
			LOG.debug(this.getClass().getSimpleName()+"=>"+json);
			return json;
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	
}
