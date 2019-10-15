package com.tnr.scgcxx.service.safty;

import java.util.List;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.MenuDto;
public interface HomePhoneService {

	List<MenuDto> getMenus(CurrUser currUser);
	
}
