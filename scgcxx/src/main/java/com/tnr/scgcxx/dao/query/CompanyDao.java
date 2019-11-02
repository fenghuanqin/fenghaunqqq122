package com.tnr.scgcxx.dao.query;

import java.util.List;

import com.tnr.scgcxx.dto.QueryDto;
import com.tnr.scgcxx.model.Query;


public interface CompanyDao {

	List<Query> findCompanyList(QueryDto dto);

}
