package com.tnr.scgc.base;

public enum PlanStatusEnum {
	
	未下达("0","未下达"),
	已下达("1","已下达");
	
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
	
	
	PlanStatusEnum(String code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(String code) {
		PlanStatusEnum[] arr=PlanStatusEnum.values();
		
		for(PlanStatusEnum se : arr) {
			if(se.code.equals(code)) {
				return se.name;
			}
		}
		return null;
	}
}
