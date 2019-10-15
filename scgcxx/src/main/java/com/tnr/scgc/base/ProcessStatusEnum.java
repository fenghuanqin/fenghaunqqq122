package com.tnr.scgc.base;

public enum ProcessStatusEnum {
	
	未投坯("00","未投坯"),
	已投坯("05","已投坯"),
	已前处理("10","已前处理"),
	已染色("15","已染色"),
	已印花("20","已印花"),
	已整理("25","已整理"),
	质检中("30","质检中"),
	已质检("35","已质检"),
	包装中("40","包装中"),
	已包装("50","已包装"),
	已部分入库("55","已部分入库"),
	已入库("60","已入库"),
	已部分交货 ("65","已部分交货"),
	已交货 ("70","已交货");
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String code; 
	private String name;
	
	
	ProcessStatusEnum(String code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(String code) {
		ProcessStatusEnum[] arr=ProcessStatusEnum.values();
		
		for(ProcessStatusEnum se : arr) {
			if(se.code.equals(code)) {
				return se.name;
			}
		}
		return null;
	}
}
