package com.restfullapi.RestfulApi.controller;

import com.restfullapi.RestfulApi.dto.RegionsDTO;
import com.restfullapi.RestfulApi.entity.Regions;
import com.restfullapi.RestfulApi.service.RegionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionsController {
    private RegionsService regionsService;

    public RegionsController(RegionsService regionsService) {
        this.regionsService = regionsService;

    }

    @RequestMapping(value = {"/getAllRegions"}, method= RequestMethod.GET)
    public ResponseEntity<List<Regions>> getAllRegions(){
        return regionsService.getRegionsList();
    }
    @RequestMapping(value = {"/addRegions"}, method= RequestMethod.POST)
    public ResponseEntity<Regions> addRegionsPost(@RequestBody RegionsDTO regionsDTO){
        return regionsService.addRegions(regionsDTO);
    }
    @RequestMapping(value = {"/deleteRegions/{id}"}, method= RequestMethod.DELETE)
    public ResponseEntity<Regions> deleteRegions(@PathVariable Integer id){
        return regionsService.delete(id);
    }
    @RequestMapping(value = {"/updateRegions/{id}"}, method= RequestMethod.PUT)
    public ResponseEntity<Regions> updateRegions(@PathVariable Integer id, @RequestBody RegionsDTO regionsDTO){
        return regionsService.updateRegions(id, regionsDTO);
    }
}
