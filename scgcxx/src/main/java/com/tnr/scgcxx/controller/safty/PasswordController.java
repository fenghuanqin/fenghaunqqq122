package com.tnr.scgcxx.controller.safty;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.Contstants;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.PasswordUser;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.service.safty.PasswordService;
@RestController
@RequestMapping("/safty/password")
public class PasswordController {
	@Autowired
	private PasswordService pwdService;
	
	
	@PutMapping("/update")
	public Result exctUpdate(@RequestBody PasswordUser dto,HttpSession session) {
		/*
		 * System.out.println("----------------------------------------------------");
		 * 
		 * System.out.println(session);
		 * System.out.println(session.getAttribute(Contstants.
		 * SESSION_ATTR_NAME_CURR_USER));
		 * System.out.println(session.getAttribute(Contstants.
		 * SESSION_ATTR_NAME_CURR_USER).getClass());
		 * System.out.println("<<<<<<<<<<<<<"); System.out.println(currUser);
		 * System.out.println(currUser.getUserId());
		 */
		CurrUser currUser =(CurrUser)
				SecurityUtils.getSubject().getPrincipal();
		System.out.println(dto);
		System.out.println(dto.getU_id());
		System.out.println("————————————————————————");
		System.out.println(currUser.getUserId());
		if(dto.getU_id().equals(currUser.getUserId())) {
			
			if(dto.getU_pwd().equals(dto.getU_pwdstr())) {
				int n = pwdService.exctUpdate(dto);
				System.out.println("密码修改成功");
				return Result.successResult("密码修改成功");
			}
			else {
				System.out.println("两次密码输入不一致");
				return Result.failResult("两次密码输入不一致");
				
			}
			
		}
		
		else {
			System.out.println("账号输入错误");
			return Result.failResult("账号输入错误");
		}
		
	}

}
