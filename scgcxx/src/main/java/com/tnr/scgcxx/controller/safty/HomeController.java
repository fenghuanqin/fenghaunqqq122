package com.tnr.scgcxx.controller.safty;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgc.base.Contstants;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.MenuDto;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.service.safty.HomeService;
import com.tnr.scgcxx.service.safty.LoginService;



@RestController
@RequestMapping("/safty/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	@GetMapping("/menu")
	public List<MenuDto> getMenus(){
		CurrUser currUser = (CurrUser)SecurityUtils.getSubject().getPrincipal();
		/*
		 * CurrUser currUser =(CurrUser)
		 * session.getAttribute(Contstants.SESSION_ATTR_NAME_CURR_USER);
		 */
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(currUser);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return homeService.getMenus(currUser);
	}
	@GetMapping("/currUser")
	public CurrUser getCurrUser() {
		/*
		 * CurrUser currUser =(CurrUser)
		 * session.getAttribute(Contstants.SESSION_ATTR_NAME_CURR_USER); return
		 * currUser;
		 */
		
		return (CurrUser)SecurityUtils.getSubject().getPrincipal();
	}
	@DeleteMapping("/logout")
	public Result logout() {
		try {
			SecurityUtils.getSubject().logout();
			return Result.successResult("您已经退出系统");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failResult("退出失败");
		}
	}
}
