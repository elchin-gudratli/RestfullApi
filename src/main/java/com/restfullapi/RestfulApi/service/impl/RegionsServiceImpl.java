package com.restfullapi.RestfulApi.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.RestfulApi.dto.RegionsDTO;
import com.restfullapi.RestfulApi.entity.Regions;
import com.restfullapi.RestfulApi.repository.RegionsRepository;
import com.restfullapi.RestfulApi.service.RegionsService;

@Service
@Transactional
public class RegionsServiceImpl implements RegionsService{
	
	private final RegionsRepository regionsRepository;

	private final ModelMapper modelMapper;

	public RegionsServiceImpl(RegionsRepository regionsRepository,ModelMapper modelMapper) {
		this.regionsRepository = regionsRepository;
		this.modelMapper = modelMapper;

	}
	
	@Override
	public  ResponseEntity<List<Regions>> getRegionsList() {
		List<Regions> list = regionsRepository.findAll();
		if(list != null  && list.size() > 0){

			return ResponseEntity.ok(list);
		}
		else{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		 
	}

	@Override
	public Regions getById(Integer id) {
		return regionsRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<Regions> addRegions(RegionsDTO regionsDTO) {
		Regions region = new Regions();
		region.setName(regionsDTO.getName());
		region.setParent_id(regionsDTO.getParent_id());
		regionsRepository.save(region);
		return ResponseEntity.ok(region);
	}

	@Override
	public ResponseEntity<Regions> delete(Integer id) {
		Optional<Regions> regionsOptional= regionsRepository.findById(id);
		if (regionsOptional.isPresent()){
			regionsRepository.deleteById(id);
			return ResponseEntity.ok(regionsOptional.get());
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Regions> updateRegions(Integer id, RegionsDTO regionsDTO) {
		Regions regions = getById(id);
		if(regions != null) {
			if(regionsDTO.getName() != null) {
				regions.setName(regionsDTO.getName());
			}
			if(regionsDTO.getParent_id() != null) {
				regions.setParent_id(regionsDTO.getParent_id());
			}
			
		}
		regionsRepository.save(regions);
		return ResponseEntity.ok(regions);
	}

}
