package com.tnr.scgcxx.shiro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.Result;

@RestController
public class ShiroController {
	
	@RequestMapping("/loginTo")
	public Result toLoginUrl() {
		return Result.unLoggedResult("/safty/login/index.html");
		
	}
	
	@RequestMapping("/successTo")
	public Result toSuccessUrl() {		
		return Result.failResult("没有找到！","/safty/home/index.html");
	}
	

	@RequestMapping("/unauthorizedTo")
	public Result toUnauthorizedUrl() {
		return Result.failResult("您的权限不足！","/safty/error/index.html");
	}
}