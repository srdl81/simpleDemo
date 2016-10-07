package com.ams.hack.controller;


import com.ams.hack.service.DurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    public @ResponseBody String getDuration() {
        return durationService.fetchDuration();
    }

}
