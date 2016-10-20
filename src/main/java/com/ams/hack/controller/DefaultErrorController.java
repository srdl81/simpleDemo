package com.ams.hack.controller;

import com.ams.hack.spring.handler.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;

@RestController
public class DefaultErrorController {

	@RequestMapping(value = ExceptionHandler.ERROR, produces = "application/json;charset=utf-8")
	String errorNotFound(HttpServletResponse response) {
		final int status = response.getStatus();
		return "{ \"code\": " + status + "," + "\"message\": \"" + HttpStatus.valueOf(status).getReasonPhrase() + "\" }";
	}
}

