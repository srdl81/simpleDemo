package com.ams.hack.controller;


import com.ams.hack.model.TripResult;
import com.ams.hack.service.TripService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Trip", description = "Calculate travel time")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @ApiOperation(value = "Receive duration by api-ids", nickname = "dasd", produces = "application/json",
    notes = "Älvsjö Station - Solna station " +
            "originId=740000789, " +
            "destinationId=740000759")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/duration/trip/ids", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody TripResult getDurationById(@RequestParam final String originId, @RequestParam final String destinationId) {
        return tripService.fetchTripByIds(originId, destinationId);
    }


    @ApiOperation(value = "Receive duration by coordinates.", nickname = "dasd", produces = "application/json",
            notes = "Älvsjö Station - Solna station " +
                    "(Älvsjö:" +
                    "latitude=59.278736," +
                    " longitude=18.011066)" +

                    " (Solna station:" +
                    " latitude=59.365104" +
                    " longitude=18.010041)")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/duration/trip/coordinates", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody TripResult getDurationByCoordinates(
            @RequestParam final String originCoordLat,
            @RequestParam final String originCoordLong,
            @RequestParam final String destCoordLat,
            @RequestParam final String destCoordLong) {
        return tripService.fetchTripByCoordinates(originCoordLat, originCoordLong, destCoordLat, destCoordLong);
    }

}
