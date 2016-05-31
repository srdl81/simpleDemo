package com.ams.hack.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}
