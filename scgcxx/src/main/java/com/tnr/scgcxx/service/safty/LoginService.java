package com.tnr.scgcxx.service.safty;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.dto.UserDto;
import com.tnr.scgcxx.exception.BusinessException;
import com.tnr.scgcxx.exception.SysException;

public interface LoginService {
	CurrUser login(UserDto dto)throws SysException,BusinessException;

}
