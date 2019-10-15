package com.tnr.scgcxx.shiro.shiroServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.User;
import com.tnr.scgcxx.shiro.ShiroService;
import com.tnr.scgcxx.shiro.dao.ShiroDao;
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
@Service
public class ShiroServiceImpl implements ShiroService {
	@Autowired
	private ShiroDao shiroDao;
	@Override
	public List<Module> getModulesOfUser(String userId) {
		
		return shiroDao.findModuleOfUser(userId);
	}

	@Override
	public User getUser(String userId) {
		
		return shiroDao.findUser(userId);
	}

	@Override
	public List<Module> getAllSubModules() {
		
		return shiroDao.findAllSubModules();
	}

}
