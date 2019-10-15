package com.tnr.scgc.base;

public enum TypeEnum {
	
	白色产品("1","白色产品"),
	染色产品("2","染色产品"),
	无底色印花产品("3","无底色印花产品"),
	有底色印花产品("4","有底色印花产品");
	
	
	
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
	
	
	TypeEnum(String code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(String code) {
		TypeEnum[] arr=TypeEnum.values();
		
		for(TypeEnum se : arr) {
			if(se.code.equals(code)) {
				return se.name;
			}
		}
		return null;
	}
}
