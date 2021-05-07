package com.restfullapi.RestfulApi.service;

import org.springframework.http.ResponseEntity;

import com.restfullapi.RestfulApi.dto.RegionsDTO;
import com.restfullapi.RestfulApi.entity.Regions;

import java.util.List;

public interface RegionsService {

	ResponseEntity<List<Regions>> getRegionsList();
	
	Regions getById(Integer id);
	
	ResponseEntity<Regions> addRegions(RegionsDTO regionsDTO);
	
	ResponseEntity<Regions> delete(Integer id);
	
	ResponseEntity<Regions> updateRegions(Integer id, RegionsDTO regionsDTO);

}
