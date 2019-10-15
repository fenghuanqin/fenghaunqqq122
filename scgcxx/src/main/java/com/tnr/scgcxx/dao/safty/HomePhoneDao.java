package com.tnr.scgcxx.dao.safty;

import java.util.List;

import com.tnr.scgcxx.dto.CurrUser;
import com.tnr.scgcxx.model.Module;

public interface HomePhoneDao {

	List<Module> findSomeMenu(CurrUser currUser);

}
