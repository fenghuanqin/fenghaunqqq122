package com.tnr.scgcxx.controller.safty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.MenuDto;
import com.tnr.scgcxx.service.safty.HomeService;
import com.tnr.scgcxx.service.safty.LoginService;



@RestController
@RequestMapping("/safty/home")
public class HomeController {
	@Autowired
	private HomeService homeService;
	@GetMapping("/menu")
	public List<MenuDto> getMenus(){
		return homeService.getMenus();
	}
}
