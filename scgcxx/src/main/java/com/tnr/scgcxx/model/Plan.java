package com.tnr.scgcxx.model;

import java.util.Date;

import com.tnr.scgc.base.PlanStatusEnum;
import com.tnr.scgc.base.StatusEnum;
import com.tnr.scgc.base.TypeEnum;

public class Plan {
	
	
	
	private Integer plan_id;//计划编号
	private Integer standard_id;//产品规格编号
	private Integer cus_id;//客户编号
	private Integer co_id;//花色号编号
	private Integer plan_xh;//生产顺序号
	private String plan_month;//计划生产月份
	private Double plan_num;//计划产量
	private Integer plan_type;//产品类型
	private Date plan_date;//计划下达日期
	private String plan_person;//计划下达人
	private Integer plan_status;//计划状态
	private String standard_name;
	private String cus_name;
	private String co_name;
	
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Integer getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(Integer standard_id) {
		this.standard_id = standard_id;
	}
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public Integer getCo_id() {
		return co_id;
	}
	public void setCo_id(Integer co_id) {
		this.co_id = co_id;
	}
	public Integer getPlan_xh() {
		return plan_xh;
	}
	public void setPlan_xh(Integer plan_xh) {
		this.plan_xh = plan_xh;
	}
	public String getPlan_month() {
		return plan_month;
	}
	public void setPlan_month(String plan_month) {
		this.plan_month = plan_month;
	}
	public Double getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(Double plan_num) {
		this.plan_num = plan_num;
	}
	public Integer getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(Integer plan_type) {
		this.plan_type = plan_type;
	}
	public Date getPlan_date() {
		return plan_date;
	}
	public void setPlan_date(Date plan_date) {
		this.plan_date = plan_date;
	}
	public String getPlan_person() {
		return plan_person;
	}
	public void setPlan_person(String plan_person) {
		this.plan_person = plan_person;
	}
	public Integer getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(Integer plan_status) {
		this.plan_status = plan_status;
	}
	
	public String getStatusName() {
		return PlanStatusEnum.getName(plan_status.toString());
	}
	public String getPlanTypeName() {
		
			return TypeEnum.getName(plan_type.toString());
	
	}
	
	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", standard_id=" + standard_id + ", cus_id=" + cus_id + ", co_id=" + co_id
				+ ", plan_xh=" + plan_xh + ", plan_month=" + plan_month + ", plan_num=" + plan_num + ", plan_type="
				+ plan_type + ", plan_date=" + plan_date + ", plan_person=" + plan_person + ", plan_status="
				+ plan_status + ", standard_name=" + standard_name + ", cus_name=" + cus_name + ", co_name=" + co_name
				+ "]";
	}
	
	
}
