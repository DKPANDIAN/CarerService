package com.uniquecaterer.service.rest.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.uniquecaterer.service.rest.data.CatererDataFactory;
import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.repo.CatererRepository;
import com.uniquecaterer.service.rest.service.CatererService;

@Service
public class CatererServiceImpl implements CatererService {

	private static final Logger logger = LoggerFactory.getLogger(CatererServiceImpl.class);

	@Autowired
	private CatererRepository catererRepository;
	
	@Autowired
	CatererDataFactory catererDataFactory;

	@Override
	public CatererDto saveCaterer(CatererDto catererDto) {
		
		Caterer entity = catererDataFactory.getCatererEntity(catererDto);
		
		if (!ObjectUtils.isEmpty(entity)) {

			if (StringUtils.isEmpty(entity.getId())) {
				entity = catererRepository.save(entity);
			} else {
				entity = catererRepository.insert(entity);
			}
			logger.debug("CatererServiceImpl::saveCaterer() processed entity for id {}", entity.getId());
			catererDto.setId(entity.getId());
			return catererDto;
		}
		logger.debug("CatererServiceImpl::saveCaterer() failed with entity {} ", entity);
		return null;
	}

	@Override
	public CatererDto findById(String id) {

		CatererDto catererDto = null;

		if (StringUtils.isNotEmpty(id)) {
			Optional<Caterer> optionCaterer = catererRepository.findById(id);

			if (optionCaterer.isPresent()) {
				Caterer caterer = optionCaterer.get();
				catererDto = catererDataFactory.getCatererDto(caterer);
			}
		}
		logger.debug("CatererServiceImpl::findById() processed & return {}", Objects.isNull(catererDto));
		return catererDto;
	}

	@Override
	public List<CatererDto> findByCityName(String cityName) {

		List<Caterer> caterers = null;
		List<CatererDto> catererDtos=null;
		int count = 0;

		if (StringUtils.isNotEmpty(cityName)) {
			caterers = catererRepository.findByLocationCityName(cityName);
			if (!CollectionUtils.isEmpty(caterers)) {
				count = caterers.size();
				catererDtos = caterers.stream().map(cater->{
					return catererDataFactory.getCatererDto(cater);
				}).collect(Collectors.toList());
			}
		}

		logger.debug("CatererServiceImpl::findByCityName() processed & return {} records ", count);

		return catererDtos;
	}

}
