package com.tnr.scgcxx.service.safty.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tnr.scgcxx.dao.safty.LoginDao;
import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.exception.BusinessException;
import com.tnr.scgcxx.exception.SysException;
import com.tnr.scgcxx.model.User;
import com.tnr.scgcxx.service.safty.LoginService;
@Service
public class LoginImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	@Override
	public CurrUser login(UserDto dto) throws SysException, BusinessException {
		User user;
		try {
			user = loginDao.findUser(dto);
		} catch (Exception e) {
			throw new SysException("系统错误",e);
		}
		
		if(user==null) {
			throw new BusinessException("用户名或密码错误");
		}
		CurrUser currUser=new CurrUser();
		currUser.setUserId(user.getU_id());
		currUser.setUserName(user.getU_name());
		return currUser;
	}

}
