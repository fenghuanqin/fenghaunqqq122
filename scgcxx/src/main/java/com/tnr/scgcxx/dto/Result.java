package com.tnr.scgcxx.dto;

public class Result {
	
	public static Result successResult() {
		return new Result(true,null,null);
	}
	
	public static Result successResult(String message) {
		return new Result(true,message,null);
	}
	
	public static Result successResult(String message,Object data) {
		return new Result(true,message,data);
	}
	
	public static Result failResult() {
		return new Result(false,null,null);
	}
	
	public static Result failResult(String message) {
		return new Result(false,message,null);
	}
	
	public static Result failResult(String message,Object data) {
		return new Result(false,message,data);
	}
	
	
	public static Result unLoggedResult(String url) {
		return new Result(url);
	}
	
	private boolean logined;
	private String url;
	
	private boolean success;
	private String message;
	private Object data;
	
	
	private Result(boolean success, String message, Object data) {
		super();
		this.logined=true;
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	private Result(String url) {
		super();
		this.logined=false;
		this.url=url;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public boolean isLogined() {
		return logined;
	}

	public String getUrl() {
		return url;
	}
	
	
	
	

}
