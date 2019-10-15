package com.tnr.scgcxx.service.safty.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.tnr.scgcxx.dao.safty.HomeDao;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.MenuDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.service.safty.HomeService;
@Service
public class HomeImpl implements HomeService {
	@Autowired
	private HomeDao homeDao;
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	@Override
	public List<MenuDto> getMenus(CurrUser currUser) {
		List<Module> moduleList = homeDao.findAllMenu(currUser);
		System.out.println("____________________________________");
		for(Module m : moduleList) {
			System.out.println(m.getM_name()+m.getM_id()+m.getM_url()+m.getP_id()+m.getP_name());
		}
		System.out.println("____________________________________");
		List<MenuDto> mainMenuDtoList = new ArrayList<MenuDto>();
		
		MenuDto currMainMenu = null;
		for(Module module : moduleList) {
			if(currMainMenu ==null || !currMainMenu.getMenuId().equals(module.getP_id())) {
				currMainMenu = new MenuDto();
				currMainMenu.setMenuId(module.getP_id());
				currMainMenu.setMenuName(module.getP_name());
				currMainMenu.setSubMenuList(new ArrayList<MenuDto>());
				mainMenuDtoList.add(currMainMenu);
			}
			 
			MenuDto subMenu=new MenuDto();
			subMenu.setMenuId(module.getM_id());
			subMenu.setMenuName(module.getM_name());
			subMenu.setMenuUrl(module.getM_url());
			currMainMenu.getSubMenuList().add(subMenu);
			
		
		}
		return mainMenuDtoList;
	}
	
	

}
