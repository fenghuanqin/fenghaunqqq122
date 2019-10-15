package com.tnr.scgcxx.model;

import com.tnr.scgc.base.StatusEnum;

public class Color {
	

	private Integer co_id;
	private String co_name;
	private String co_remark;
	private String co_status;
	
	public Integer getco_id() {
		return co_id;
	}
	public void setco_id(Integer co_id) {
		this.co_id = co_id;
	}
	public String getco_name() {
		return co_name;
	}
	public void setco_name(String co_name) {
		this.co_name = co_name;
	}
	public String getco_remark() {
		return co_remark;
	}
	public void setco_remark(String co_remark) {
		this.co_remark = co_remark;
	}
	public String getco_status() {
		return co_status;
	}
	public void setco_status(String co_status) {
		this.co_status = co_status;
	}
	public String getstatusName() {
		return StatusEnum.getName(co_status);
	}
}
