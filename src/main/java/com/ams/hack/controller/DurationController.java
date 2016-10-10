package com.ams.hack.controller;


import com.ams.hack.model.TravelInfo;
import com.ams.hack.service.DurationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Duration", description = "Calculate travel time")
@RestController
public class DurationController {

    @Autowired
    private DurationService durationService;

    @ApiOperation(value = "Receive duration by api-ids", nickname = "dasd", produces = "application/json",
    notes = "Stockholm Centralstation - Malmö Centralstation " +
            "originId=740000001, destinationId=740000004 ")
    @ApiResponses(value = {  @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/duration/trip/ids", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody TravelInfo getDurationById(@RequestParam final String originId, @RequestParam final String destinationId
    ) {
        return durationService.fetchDurationByIds(originId, destinationId);
    }


    @ApiOperation(value = "Receive duration by coordinates.", nickname = "dasd", produces = "application/json",
            notes = "Stockholm Centralstation - Malmö Centralstation " +
                    "originCoordLong=18.058151, originCoordLat=59.330136" +
                    "destCoordLong=13.00091, destCoordLat=55.609456")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/duration/trip/coordinates", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody TravelInfo getDurationByCoordinates(
            @RequestParam final String originCoordLong,
            @RequestParam final String originCoordLat,
            @RequestParam final String destCoordLong,
            @RequestParam final String destCoordLat
    ) {
        return durationService.fetchDurationByCoordinates(originCoordLong, originCoordLat, destCoordLong, destCoordLat);
    }

}
