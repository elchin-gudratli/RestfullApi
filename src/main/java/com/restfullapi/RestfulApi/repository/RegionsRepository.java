package com.restfullapi.RestfulApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfullapi.RestfulApi.entity.Regions;



@Repository
public interface RegionsRepository extends JpaRepository<Regions,Integer>{
	
	List<Regions> findAll();
	
	Regions getById(Integer id);
	

}
