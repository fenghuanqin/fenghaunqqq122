package com.tnr.scgc.base;

public enum StatusEnum {
	
	未确定("00","未确定"),
	已确定("22","已确定"),
	已启动("55","已启动"),
	已禁用("77","已禁用"),
	逻辑删除("99","逻辑删除");
	
	
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
	
	
	StatusEnum(String code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(String code) {
		StatusEnum[] arr=StatusEnum.values();
		
		for(StatusEnum se : arr) {
			if(se.code.equals(code)) {
				return se.name;
			}
		}
		return null;
	}
}
