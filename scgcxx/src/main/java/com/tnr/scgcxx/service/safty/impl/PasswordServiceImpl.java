package com.tnr.scgcxx.service.safty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnr.scgcxx.dao.safty.PasswordDao;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.PasswordUser;
import com.tnr.scgcxx.dto.Result;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.service.safty.PasswordService;
@Service
public class PasswordServiceImpl implements PasswordService {
	@Autowired
	private PasswordDao passwordDao;

	@Override
	public int exctUpdate(PasswordUser dto) {
		return passwordDao.updatePassword(dto);
		
	}
	

	

}
