package com.ams.hack.controller;


import com.ams.hack.model.Example;
import com.ams.hack.service.OpenDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "OpenData", description = "OpenData")
@RestController
public class OpenDataController {

    @Autowired
    private OpenDataService openDataService;

    @ApiOperation(value = "OpenData", nickname = "OpenData", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Example.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody ResponseEntity<Example> viewString() {
        return openDataService.fetchVacenciesByCounty();
    }

    @ApiOperation(value = "dasd", nickname = "dasd", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @RequestMapping(value = "/duration", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody String getDuration() {
        return openDataService.fetchDuration();
    }

}
