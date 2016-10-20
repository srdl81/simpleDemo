package com.ams.hack.spring.handler;

import com.ams.hack.dto.ResponseErrorDTO;
import com.ams.hack.model.ResponseError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Maps different exceptions to http responses
 */
@ControllerAdvice
public class ExceptionHandler implements ErrorController {
    public static final String ERROR = "/error";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler({NoSuchElementException.class})
    public @ResponseBody
    ResponseError notFound(Exception e) {
        logger.debug("404: {}", e.getMessage(), e);
        return new ResponseError(404, "Not found");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({HttpClientErrorException.class})
    public @ResponseBody
    ResponseError badRequest(HttpClientErrorException exception) {
        String responseString = exception.getResponseBodyAsString();
        ResponseErrorDTO errorDTO = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            errorDTO = mapper.readValue(responseString, ResponseErrorDTO.class);
        } catch (IOException e) {
            logger.error("could not read/map errorDTO message value: {}", responseString, e);
        }

        logger.error("400: {}", errorDTO.getErrorText(), exception);
        return new ResponseError(400, String.format("Bad request: %s", errorDTO.getErrorText()));
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public @ResponseBody
    ResponseError internalServerError(HttpServletRequest request, Exception exception) {
        final String exceptionId = UUID.randomUUID().toString();
        logger.warn("500: id: {}, url: {}, message: {}, ", exceptionId, request.getRequestURI(), exception.getMessage(), exception);
        return new ResponseError(500, "id: " + exceptionId + ", message: " + exception.getMessage());
    }

    @Override
    public String getErrorPath() {
        return ERROR;
    }
}
