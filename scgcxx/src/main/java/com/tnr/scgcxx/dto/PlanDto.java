package com.tnr.scgcxx.dto;




public class PlanDto extends PageParam {

	private Integer plan_id;//计划编号
	private Integer standard_id;//产品规格编号
	private Integer cus_id;//客户编号
	private Integer co_id;//花色号编号
	private Integer plan_xh;//生产顺序号
	private String plan_month;//计划生产月份
	private Double plan_num;//计划产量
	private Integer plan_type;//产品类型
	private String plan_date;//计划下达日期
	private String plan_person;//计划下达人
	private Integer plan_status;//计划状态
	private String plan_month_year;
	private String plan_month_month;
	private String plan_date_start; 
	private Double group_num;
	public String getPlan_date_start() {
		return plan_date_start;
	}
	public void setPlan_date_start(String plan_date_start) {
		this.plan_date_start = plan_date_start;
	}
	public String getPlan_date_end() {
		return plan_date_end;
	}
	public void setPlan_date_end(String plan_date_end) {
		this.plan_date_end = plan_date_end;
	}
	private String plan_date_end;
	/*
	 * private Date plan_date_start; private Date plan_date_end;
	 * 
	 * public Date getPlan_date_start() { return plan_date_start; } public void
	 * setPlan_date_start(Date plan_date_start) { this.plan_date_start =
	 * plan_date_start; } public Date getPlan_date_end() { return plan_date_end; }
	 * public void setPlan_date_end(Date plan_date_end) { this.plan_date_end =
	 * plan_date_end; }
	 */
	
	//	private DateRange[] plan_dates;
//	
//	
//	
//	
//	
//	public Date[] getPlan_dates() {
//		return plan_dates;
//	}
//	
//	public Date getStartDate() {
//		if(plan_dates!=null&&plan_dates.length>0) {
//			return plan_dates[0];
//		}
//		return null;
//	}
//	
//
//	public Date getEndDate() {
//		if(plan_dates!=null&&plan_dates.length>1) {
//			return plan_dates[1];
//		}
//		return null;
//	}
//	
//	public void setPlan_dates(Date[] plan_dates) {
//		this.plan_dates = plan_dates;
//	}
	public Double getGroup_num() {
		return group_num;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public String getPlan_month_year() {
		return plan_month_year;
	}
	public void setPlan_month_year(String plan_month_year) {
		this.plan_month_year = plan_month_year;
	}
	public String getPlan_month_month() {
		return plan_month_month;
	}
	public void setPlan_month_month(String plan_month_month) {
		this.plan_month_month = plan_month_month;
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
		if(plan_month_year !=null && plan_month_year!="" && plan_month_month !=null && plan_month_month!="") {
			StringBuilder builder=new StringBuilder();
			builder.append(plan_month_year).append("-").append(plan_month_month);
			return  builder.toString();
		}
		else {
			return plan_month;
		}
			
		
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
	
	public String getPlan_person() {
		return plan_person;
	}
	public void setPlan_person(String plan_person) {
		this.plan_person = plan_person;
	}
	public String getPlan_date() {
		return plan_date;
	}
	public void setPlan_date(String plan_date) {
		this.plan_date = plan_date;
	}
	public Integer getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(Integer plan_status) {
		this.plan_status = plan_status;
	}
	/*
	 * @Override public String toString() { return "PlanDto [plan_id=" + plan_id +
	 * ", standard_id=" + standard_id + ", cus_id=" + cus_id + ", co_id=" + co_id +
	 * ", plan_xh=" + plan_xh + ", plan_month=" + plan_month + ", plan_num=" +
	 * plan_num + ", plan_type=" + plan_type + ", plan_date=" + plan_date +
	 * ", plan_person=" + plan_person + ", plan_status=" + plan_status +
	 * ", plan_month_year=" + plan_month_year + ", plan_month_month=" +
	 * plan_month_month + ", plan_date_start=" + plan_date_start +
	 * ", plan_date_end=" + plan_date_end + "]"; }
	 */
	@Override
	public String toString() {
		return "PlanDto [plan_id=" + plan_id + ", standard_id=" + standard_id + ", cus_id=" + cus_id + ", co_id="
				+ co_id + ", plan_xh=" + plan_xh + ", plan_month=" + plan_month + ", plan_num=" + plan_num
				+ ", plan_type=" + plan_type + ", plan_date=" + plan_date + ", plan_person=" + plan_person
				+ ", plan_status=" + plan_status + ", plan_month_year=" + plan_month_year + ", plan_month_month="
				+ plan_month_month + ", plan_date_start=" + plan_date_start + ", plan_date_end=" + plan_date_end + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
