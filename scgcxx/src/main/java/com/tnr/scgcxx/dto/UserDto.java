package com.tnr.scgcxx.dto;

public class UserDto extends PageParam{
	private String u_id;
	private String u_name;
	private String u_pwd;
	private String u_status;
	private String u_pwdstr;
	
	public String getU_pwdstr() {
		return u_pwdstr;
	}
	public void setU_pwdstr(String u_pwdstr) {
		this.u_pwdstr = u_pwdstr;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_status() {
		return u_status;
	}
	public void setU_status(String u_status) {
		this.u_status = u_status;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
	
	
}
