package com.uniquecaterer.service.rest.service;

import java.util.List;

import com.uniquecaterer.service.rest.data.CatererDto;

public interface CatererService {

	public CatererDto saveCaterer(CatererDto catererDto);
	
	public CatererDto findById(String id);
	
	public List<CatererDto> findByCityName(String cityName);
}
