package com.tnr.scgcxx.model;

import com.tnr.scgc.base.Product_statusEnum;

public class Product {
	
	private Double product_id;
	private Double process_id;
	private String product_cus;
	private String product_std;
	private String process_color;
	private String product_level;
	private Double product_num;
	private String product_status;
	//private Double product_numSum;
	
	

	private Double arrange_num;
	public Double getArrange_num() {
		
		return arrange_num;
	}
	public void setArrange_num(Double arrange_num) {
		this.arrange_num = arrange_num;
	}
	
	//补充
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
		return "Product [product_id=" + product_id + ", process_id=" + process_id + ", product_cus=" + product_cus
				+ ", product_std=" + product_std + ", process_color=" + process_color + ", product_level="
				+ product_level + ", product_num=" + product_num + ", product_status=" + product_status + "]";
	}
	

}
