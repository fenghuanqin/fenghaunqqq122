package com.tnr.scgcxx.controller.safty;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.Contstants;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.exception.BusinessException;
import com.tnr.scgcxx.exception.SysException;
import com.tnr.scgcxx.service.safty.LoginService;

@RestController
@RequestMapping("/safty/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/hell")
	public String sayHello() {
		return "大家好!!";
	}
	@PostMapping("/user")
	public Result execLogin(@RequestBody UserDto dto,HttpSession session) {
		//此处返回一个当前用户
		try {
			CurrUser currUser= loginService.login(dto);
			session.setAttribute(Contstants.SESSION_ATTR_NAME_CURR_USER, currUser);
			
			return Result.successResult("登录成功");
			
		} catch (BusinessException e) {
			
			return Result.failResult(e.getMessage());
		} catch (SysException e) {
			
			return Result.failResult("系统维护中"+e.getMessage());
		}
	}
}
