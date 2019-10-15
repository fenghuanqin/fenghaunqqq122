package com.tnr.scgcxx.shiro;

import java.util.List;

import com.tnr.scgcxx.model.Module;
import com.tnr.scgcxx.model.User;

public interface ShiroService {
	
	/**
	 * 根据当前用户得到其所具有的权限（不包含登录、退出、主页面、密码修改子模块）
	 * @param userId
	 * @return
	 */

	List<Module> getModulesOfUser(String userId);
	/**
	 * 根据用户ID得到当前用户
	 * @param userId
	 * @return
	 */
	User getUser(String userId);
	/**
	 * 得到所有权限（不包含登录、退出、主页面、密码修改子模块）
	 * @param userId
	 * @return
	 */
	List<Module> getAllSubModules();

}
