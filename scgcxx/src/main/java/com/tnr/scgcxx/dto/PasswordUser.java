package com.tnr.scgcxx.dto;

public class PasswordUser {
	private String u_id;
	private String u_pwd;
	private String u_pwdstr;
	
	
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pwdstr() {
		return u_pwdstr;
	}
	public void setU_pwdstr(String u_pwdstr) {
		this.u_pwdstr = u_pwdstr;
	}
	@Override
	public String toString() {
		return "PasswordUser [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_pwdstr=" + u_pwdstr + "]";
	}


}
