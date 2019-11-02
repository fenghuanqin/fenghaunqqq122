package com.tnr.scgcxx.service.query;

import java.util.Map;

import com.tnr.scgcxx.dto.QueryDto;

public interface CompanyService {

	Map<String, Object> getCompany(QueryDto dto);

}
