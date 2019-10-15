package com.tnr.scgcxx.service.safty.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tnr.scgcxx.dao.safty.HomePhoneDao;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.MenuDto;
import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.service.safty.HomePhoneService;
@Service
public class HomePhoneImpl implements HomePhoneService {
	@Autowired
	private HomePhoneDao homePhoneDao;
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	@Override
	public List<MenuDto> getMenus(CurrUser currUser) {
		List<Module> moduleList = homePhoneDao.findSomeMenu(currUser);
		System.out.println("____________________________________");
		for(Module m : moduleList) {
			System.out.println(m.getM_name()+m.getM_id()+m.getM_url());
		}
		System.out.println("____________________________________");
		List<MenuDto> mainMenuDtoList = new ArrayList<MenuDto>();
		
		MenuDto currMainMenu = null;
		for(Module module : moduleList) {
			if(currMainMenu ==null || !currMainMenu.getMenuId().equals(module.getM_id())) {
				currMainMenu = new MenuDto();
				currMainMenu.setMenuId(module.getM_id());
				currMainMenu.setMenuName(module.getM_name());
				//currMainMenu.setSubMenuList(new ArrayList<MenuDto>());
				currMainMenu.setMenuUrl(module.getM_url());
				mainMenuDtoList.add(currMainMenu);
			}
		}
		return mainMenuDtoList;
		
	}

}
