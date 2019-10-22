package com.tnr.scgcxx.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tnr.scgc.base.TypeEnum;

public class ProcessDto extends PageParam{
	
	
	private Double process_id;
	private Integer plan_id;
	private Double plan_num;//计划产量
	public Double getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(Double plan_num) {
		this.plan_num = plan_num;
	}
	private String process_cus;
	private String process_std;
	private String process_color;
	private String plan_type;
	
	public String getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}
	public String getPlan_typeName(String plan_type) {
		return TypeEnum.getName(plan_type);
	}
	private Double group_num;
	private String group_date;
	private String group_person;
	private Double pretreat_num;
	private String pretreat_date;
	private String pretreat_person;
	private Double dye_num;
	private String dye_date;
	private String dye_person;
	private Double print_num;
	private String print_date;
	private String print_person;
	private Double arrange_num;
	private String arrange_date;
	private String arrange_person;
	private Double check_num;
	private String check_date;
	private String check_person;
	private String process_status;
	//补充
	private Integer co_id;
	private String co_name;
	private Integer cus_id;
	private String cus_name;
	private Integer standard_id;
	private String standard_name;
	//再补充
	private Double product_numOne;
	private Double product_numTwo;
	private Double product_numThree;
	private Double product_numOther;
	
	
	public Double getProduct_numOne() {
		return product_numOne;
	}
	public void setProduct_numOne(Double product_numOne) {
		this.product_numOne = product_numOne;
	}
	public Double getProduct_numTwo() {
		return product_numTwo;
	}
	public void setProduct_numTwo(Double product_numTwo) {
		this.product_numTwo = product_numTwo;
	}
	public Double getProduct_numThree() {
		return product_numThree;
	}
	public void setProduct_numThree(Double product_numThree) {
		this.product_numThree = product_numThree;
	}
	public Double getProduct_numOther() {
		return product_numOther;
	}
	public void setProduct_numOther(Double product_numOther) {
		this.product_numOther = product_numOther;
	}
	public void setCheck_num(Double check_num) {
		this.check_num = check_num;
	}
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
	public Double getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Double process_id) {
		this.process_id = process_id;
	}
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
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
	public String getProcess_color() {
		return process_color;
	}
	public void setProcess_color(String process_color) {
		this.process_color = process_color;
	}
	
	
	public Double getGroup_num() {
		return group_num;
	}
	public void setGroup_num(Double group_num) {
		this.group_num = group_num;
	}
	public String getGroup_date() {
		return group_date;
	}
	public void setGroup_date(String group_date) {
		this.group_date = group_date;
	}
	public String getGroup_person() {
		return group_person;
	}
	public void setGroup_person(String group_person) {
		this.group_person = group_person;
	}
	public Double getPretreat_num() {
		return pretreat_num;
	}
	public void setPretreat_num(Double pretreat_num) {
		this.pretreat_num = pretreat_num;
	}
	public String getPretreat_date() {
		
		return pretreat_date;
	}
	public void setPretreat_date(String pretreat_date) {
		this.pretreat_date = pretreat_date;
	}
	public String getPretreat_person() {
		return pretreat_person;
	}
	public void setPretreat_person(String pretreat_person) {
		this.pretreat_person = pretreat_person;
	}
	public Double getDye_num() {
		return dye_num;
	}
	public void setDye_num(Double dye_num) {
		this.dye_num = dye_num;
	}
	public String getDye_date() {
		
		return dye_date;
		
	}
	public void setDye_date(String dye_date) {
		this.dye_date = dye_date;
	}
	public String getDye_person() {
		return dye_person;
	}
	public void setDye_person(String dye_person) {
		this.dye_person = dye_person;
	}
	public Double getPrint_num() {
		return print_num;
	}
	public void setPrint_num(Double print_num) {
		this.print_num = print_num;
	}
	public String getPrint_date() {
		
		return print_date;
	}
	public void setPrint_date(String print_date) {
		this.print_date = print_date;
	}
	public String getPrint_person() {
		return print_person;
	}
	public void setPrint_person(String print_person) {
		this.print_person = print_person;
	}
	public Double getArrange_num() {
		return arrange_num;
	}
	public void setArrange_num(Double arrange_num) {
		this.arrange_num = arrange_num;
	}
	public String getArrange_date() {
		
		return arrange_date;
	}
	public void setArrange_date(String arrange_date) {
		this.arrange_date = arrange_date;
	}
	public String getArrange_person() {
		return arrange_person;
	}
	public void setArrange_person(String arrange_person) {
		this.arrange_person = arrange_person;
	}
	public Double getCheck_num() {
		return check_num;
	}
	public void setCheck_num(Double check_numOne,Double check_numTwo,Double check_numThree,Double check_numOther) {
		this.check_num = check_numOne+check_numTwo+check_numThree+check_numOther;
	}
	public String getCheck_date() {
		
		return check_date;
	}
	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	public String getCheck_person() {
		return check_person;
	}
	public void setCheck_person(String check_person) {
		this.check_person = check_person;
	}
	public String getProcess_status() {
		return process_status;
	}
	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}
	
	
	@Override
	public String toString() {
		return "ProcessDto [process_id=" + process_id + ", plan_id=" + plan_id + ", plan_num=" + plan_num
				+ ", process_cus=" + process_cus + ", process_std=" + process_std + ", process_color=" + process_color
				+ ", group_num=" + group_num + ", group_date=" + group_date + ", group_person=" + group_person
				+ ", pretreat_num=" + pretreat_num + ", pretreat_date=" + pretreat_date + ", pretreat_person="
				+ pretreat_person + ", dye_num=" + dye_num + ", dye_date=" + dye_date + ", dye_person=" + dye_person
				+ ", print_num=" + print_num + ", print_date=" + print_date + ", print_person=" + print_person
				+ ", arrange_num=" + arrange_num + ", arrange_date=" + arrange_date + ", arrange_person="
				+ arrange_person + ", check_num=" + check_num + ", check_date=" + check_date + ", check_person="
				+ check_person + ", process_status=" + process_status + ", co_id=" + co_id + ", co_name=" + co_name
				+ ", cus_id=" + cus_id + ", cus_name=" + cus_name + ", standard_id=" + standard_id + ", standard_name="
				+ standard_name + "]";
	}
	
	
	
	
	
	
}
