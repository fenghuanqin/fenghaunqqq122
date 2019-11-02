package com.tnr.scgcxx.service.query.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.query.CompanyDao;
import com.tnr.scgcxx.dto.CustomerDto;
import com.tnr.scgcxx.dto.QueryDto;
import com.tnr.scgcxx.model.Query;
import com.tnr.scgcxx.service.query.CompanyService;
import com.tnr.scgcxx.util.Utils;
@Service
@CacheConfig(cacheNames="company")
public class CompanyImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	//Customer应当是可序列化类
    @Cacheable(key="targetClass +'.'+ methodName+'(' + #p0 +')'")
	@Override
	public Map<String, Object> getCompany(QueryDto dto) {
		System.out.println("进入业务层");
		PageHelper.startPage(dto);//pageHeleper开始分页
		System.out.println("pageHeleper开始分页");
		List<Query> list=companyDao.findCompanyList(dto);//执行查询，将查询结果塞至集合
		System.out.println("执行查询，将查询结果塞至集合");
		PageInfo<Query> page=new PageInfo<Query>(list);//将list集合传至pageInfo		
		return Utils.convert2PageData(page);
	}
	
}
