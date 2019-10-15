package com.tnr.scgcxx.service.info.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.info.StandardDao;
import com.tnr.scgcxx.dto.StandardDto;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.model.Standard;
import com.tnr.scgcxx.service.info.StandardService;
import com.tnr.scgcxx.util.Utils;
@Service
public class StandardServiceImpl implements StandardService {
	
	@Autowired
	private StandardDao standardDao;
	@Override
	public Map<String, Object> getPage(StandardDto dto) {
		PageHelper.startPage(dto);	
		List<Standard> list = standardDao.findStandardList(dto);
		PageInfo<Standard> page = new PageInfo<Standard>(list);
		return Utils.convert2PageData(page);
	}
	@Override
	public Standard isExist(Integer standard_id) {
		 return standardDao.isExist(standard_id);
	}
	@Override
	public int exctStandardDoAdd(StandardDto dto) {
		int n = standardDao.exctDoAdd(dto);
		return n;
	}
	@Override
	public int exctStandardDoUpdate(StandardDto dto) {
		int n = standardDao.exctDoUpda(dto);
		return n;
	}
	@Override
	public int exctStandardStatus(StandardDto dto) {
		int n = standardDao.exctDoStatus(dto);
		return n;
	}
	@Override
	public int exctStandardDoDele(String standard_id) {
		int n = standardDao.exctDoDele(standard_id);
		return n;
	}
	@Override
	public int exctStandardDelets(String[] standard_ids) {
		int n = standardDao.exctDoDelets(standard_ids);
		return n;	
	}
	
	
	
}
