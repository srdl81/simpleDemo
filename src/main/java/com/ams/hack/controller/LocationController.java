package com.ams.hack.controller;

import com.ams.hack.model.LocationResult;
import com.ams.hack.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Location", description = "Receive locations and nearby stops and stations")
@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "Receive location suggestions", nickname = "location", produces = "application/json;charset=utf-8", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/location/{location}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody LocationResult getLocationSuggestions(@PathVariable(value = "location") String location) {

        return locationService.fetchLocations(location);
    }

    @ApiOperation(value = "Find stations and stops near a coordinate", nickname = "location", produces = "application/json;charset=utf-8", notes = "")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/location/nearbystops", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody LocationResult getStationsAndStopsByCoordinates(  @RequestParam final String latitude,
                                                                           @RequestParam final String longitude) {

        return locationService.fetchStationsAndStopsBy(latitude, longitude);
    }
}
