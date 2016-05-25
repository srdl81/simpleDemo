package com.ams.hack.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class Simple {


    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public @ResponseBody String viewString() {
        return "Simple";
    }

}
