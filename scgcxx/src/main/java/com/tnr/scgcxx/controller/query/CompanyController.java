package com.tnr.scgcxx.controller.query;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnr.scgcxx.dto.ProcessDto;
import com.tnr.scgcxx.dto.QueryDto;
import com.tnr.scgcxx.service.process.ArrangeService;
import com.tnr.scgcxx.service.query.CompanyService;

@RestController
@RequestMapping("/query/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@GetMapping("/sele")
	public Map<String,Object> getarrange(QueryDto dto){
		/*
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 * System.out.println(dto.toString());
		 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 */
		System.out.println("进入控制器");
		return companyService.getCompany(dto);
	}
}
