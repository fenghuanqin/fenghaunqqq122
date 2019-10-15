package com.tnr.scgcxx.dto;

public class ColorDto extends PageParam{
	
	private Integer co_id;
	private String co_name;
	private String co_remark;
	private String co_status;
	
	
	public Integer getCo_id() {
		return co_id;
	}


	public void setCo_id(Integer co_id) {
		this.co_id = co_id;
	}


	public String getCo_name() {
		return co_name;
	}


	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}


	public String getCo_remark() {
		return co_remark;
	}


	public void setCo_remark(String co_remark) {
		this.co_remark = co_remark;
	}


	public String getCo_status() {
		return co_status;
	}


	public void setCo_status(String co_status) {
		this.co_status = co_status;
	}


	@Override
	public String toString() {
		return "ColorDto [co_id=" + co_id + ", co_name=" + co_name + ", co_remark=" + co_remark + ", co_status="
				+ co_status + "]";
	}
	
	
	
	
}
