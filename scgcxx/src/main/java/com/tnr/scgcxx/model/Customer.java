package com.tnr.scgcxx.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnr.scgc.base.StatusEnum;
import com.tnr.scgcxx.dto.CustomerDto;

import jdk.internal.jline.internal.Log;

public class Customer implements java.io.Serializable{
	private static final Logger LOG=LoggerFactory.getLogger(CustomerDto.class);
	private Integer cus_id;
	private String cus_name;
	private String cus_remark;
	private String cus_status;

	
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_remark() {
		return cus_remark;
	}
	public void setCus_remark(String cus_remark) {
		this.cus_remark = cus_remark;
	}
	public String getCus_status() {
		return cus_status;
	}
	public void setCus_status(String cus_status) {
		this.cus_status = cus_status;
	}
	
	public String getStatusName() {
		return StatusEnum.getName(cus_status);
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
		return "{cus_id:"+cus_id+",cus_name:"+cus_name+",cus_remark:"+cus_remark+",cus_status:"+cus_status+"}";
	}
}
