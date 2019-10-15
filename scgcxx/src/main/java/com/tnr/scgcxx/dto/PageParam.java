package com.tnr.scgcxx.dto;

public class PageParam {
	
	private Integer pageSize=3;//每页记录数
	private Integer pageNum=1;//当前页码号数
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
	
	
}
