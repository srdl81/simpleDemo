package com.ams.hack.controller;


import com.ams.hack.model.TravelInfo;
import com.ams.hack.service.DurationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "PlatsbankenLabz", description = "PlatsbankenLabz")
@RestController
public class DurationController {

    @Autowired
    private DurationService durationService;

    @ApiOperation(value = "dasd", nickname = "dasd", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @RequestMapping(value = "/duration", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody TravelInfo getDuration(@RequestParam final String originId, @RequestParam final String destinationId) {
        return durationService.fetchDuration(originId, destinationId);
    }

}
