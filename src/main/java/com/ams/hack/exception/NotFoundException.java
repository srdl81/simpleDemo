package com.ams.hack.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Duration time could not be fetched.")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String originId, String destinationId) {
        super(String.format("Duration time could not be found with originId '%s' destinationId '%s'", originId, destinationId));
    }

}
