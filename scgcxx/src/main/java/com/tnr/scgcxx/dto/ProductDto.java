package com.tnr.scgcxx.dto;

import com.tnr.scgc.base.Product_statusEnum;

public class ProductDto {
	
	private Double product_id;
	private Double process_id;
	private String product_cus;
	private String product_std;
	private String process_color;
	private String product_level;
	private Double product_num;
	private String product_status;
	private Double arrange_num;
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
	private Double check_num;
	private String check_date;
	private String check_person;
	private String process_status;
	public Double getCheck_num() {
		return check_num;
	}
	public void setCheack_num(Double check_num) {
		this.check_num = check_num;
	}
	public Double getArrange_num() {   
		return arrange_num;
	}
	public void setArrange_num(Double arrange_num) {
		this.arrange_num = arrange_num;
	}
	
	private Double check_numOne;
	private Double check_numTwo;
	private Double check_numThree;
	private Double check_numOther;
	public Double getCheck_numOne() {
		if(product_num==0) {
			check_numOne=product_num;
		}
		return check_numOne;
	}
	public void setCheck_numOne(Double check_numOne) {
		this.check_numOne = check_numOne;
	}
	public Double getCheck_numTwo() {
		if(product_num==0) {
			check_numTwo=product_num;
		}
		
		return check_numTwo;
	}
	public void setCheck_numTwo(Double check_numTwo) {
		this.check_numTwo = check_numTwo;
	}
	public Double getCheck_numThree() {
		if(product_num==0) {
			check_numThree=product_num;
		}
		return check_numThree;
	}
	public void setCheck_numThree(Double check_numThree) {
		this.check_numThree = check_numThree;
	}
	public Double getCheck_numOther() {
		if(product_num==0) {
			check_numOther=product_num;
		}
		return check_numOther;
	}
	public void setCheck_numOther(Double check_numOther) {
		this.check_numOther = check_numOther;
	}
	public Double getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Double product_id) {
		this.product_id = product_id;
	}
	public Double getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Double process_id) {
		this.process_id = process_id;
	}
	public String getProduct_cus() {
		return product_cus;
	}
	public void setProduct_cus(String product_cus) {
		this.product_cus = product_cus;
	}
	public String getProduct_std() {
		return product_std;
	}
	public void setProduct_std(String product_std) {
		this.product_std = product_std;
	}
	public String getProcess_color() {
		return process_color;
	}
	public void setProcess_color(String process_color) {
		this.process_color = process_color;
	}
	public String getProduct_level() {
		return product_level;
	}
	public void setProduct_level(String product_level) {
		this.product_level = product_level;
	}
	public Double getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Double product_num) {
		this.product_num = product_num;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public String getProduct_statusEnumName() {
		return Product_statusEnum.getName(product_status);
	}
	@Override
	public String toString() {
		return "ProductDto [product_id=" + product_id + ", process_id=" + process_id + ", product_cus=" + product_cus
				+ ", product_std=" + product_std + ", process_color=" + process_color + ", product_level="
				+ product_level + ", product_num=" + product_num + ", product_status=" + product_status
				+ ", arrange_num=" + arrange_num + ", check_num=" + check_num + ", check_date=" + check_date
				+ ", check_person=" + check_person + ", process_status=" + process_status + ", check_numOne="
				+ check_numOne + ", check_numTwo=" + check_numTwo + ", check_numThree=" + check_numThree
				+ ", check_numOther=" + check_numOther + "]";
	}
	
	
	
	
	

}
