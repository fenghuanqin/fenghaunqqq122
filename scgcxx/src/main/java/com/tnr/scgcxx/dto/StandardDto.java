package com.tnr.scgcxx.dto;

public class StandardDto extends PageParam {
	
	private Integer standard_id;
	private String standard_name;
	private String standard_remark;
	private String standard_status;
	
	
	public Integer getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(Integer standard_id) {
		this.standard_id = standard_id;
	}
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
	public String getStandard_remark() {
		return standard_remark;
	}
	public void setStandard_remark(String standard_remark) {
		this.standard_remark = standard_remark;
	}
	public String getStandard_status() {
		return standard_status;
	}
	public void setStandard_status(String standard_status) {
		this.standard_status = standard_status;
	}
	
	
	

}
