package com.ams.hack.controller;


import com.ams.hack.model.Example;
import com.ams.hack.service.OpenDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenDataController {

    @Autowired
    private OpenDataService openDataService;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody ResponseEntity<Example> viewString() {

        return openDataService.fetchVacenciesByCounty();

    }

}
