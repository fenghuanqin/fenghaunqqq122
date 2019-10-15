package com.tnr.scgc.base;

public enum Product_levelEnum {
	
	未确定("01","一等品"),
	已确定("02","二等品"),
	已启动("03","三等品"),
	已禁用("04","等外品");
	
	
	
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
	
	
	Product_levelEnum(String code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(String code) {
		Product_levelEnum[] arr=Product_levelEnum.values();
		
		for(Product_levelEnum se : arr) {
			if(se.code.equals(code)) {
				return se.name;
			}
		}
		return null;
	}
}
