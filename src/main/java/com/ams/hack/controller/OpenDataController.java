package com.ams.hack.controller;


import com.ams.hack.model.Example;
import com.ams.hack.service.OpenDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "OpenData", description = "OpenData")
@RestController
public class OpenDataController {

    @Autowired
    private OpenDataService openDataService;

    @ApiOperation(value = "OpenData", nickname = "OpenData", produces = "application/json")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody ResponseEntity<Example> viewString() {

        return openDataService.fetchVacenciesByCounty();

    }

}
