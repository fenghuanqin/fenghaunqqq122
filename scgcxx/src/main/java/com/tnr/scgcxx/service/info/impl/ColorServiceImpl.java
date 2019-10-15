package com.tnr.scgcxx.service.info.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tnr.scgcxx.dao.info.ColorDao;
import com.tnr.scgcxx.dto.ColorDto;
import com.tnr.scgcxx.model.Color;
import com.tnr.scgcxx.service.info.ColorService;
import com.tnr.scgcxx.util.Utils;
@Service
public class ColorServiceImpl implements ColorService {
	@Autowired
	private ColorDao colorDao;
	@Override
	public Map<String, Object> getColorPage(ColorDto dto) {
		//利用mybtis实现将分页对象得到 
		PageHelper.startPage(dto);//将页面的参数传至PageHeleper，告诉其开始分页。	
		List<Color> list = colorDao.findColorList(dto);//执行查询，根据参数将查询对象塞至集合里，
		PageInfo<Color> page = new PageInfo<Color>(list);//将list集合传至PageInfo。
		
		return Utils.convert2PageData(page);
	}
	@Override
	public Color isExist(Integer co_id) {
		
		return colorDao.isExist(co_id);
		
	}
	@Override
	public int exctColorDoAdd(ColorDto dto) {
		int n = colorDao.exctDoAdd(dto);
		return n;
	}
	@Override
	public int exctColorDoUpdate(ColorDto dto) {
		int n = colorDao.exctDoUpda(dto);
		return n;
	}
	@Override
	public int exctColorStatus(ColorDto dto) {
		System.out.println(dto);
		int n = colorDao.exctDoStatus(dto);
		System.out.println(dto);
		return n;
	}
	@Override
	public int exctColorDoDele(String co_id) {
		int n = colorDao.exctDoDele(co_id);
		return n;
	}
	@Override
	public int exctColorDelets(String[] co_ids) {
		int n = colorDao.exctDoDelets(co_ids);
		return n;	
		}

}
