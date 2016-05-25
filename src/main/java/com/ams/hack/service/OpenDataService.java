package com.ams.hack.service;

import com.ams.hack.DemoApplication;
import com.ams.hack.model.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenDataService {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    private String url = "http://api.arbetsformedlingen.se/af/v0/platsannonser/soklista/lan";
    private RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<Example> fetchVacenciesByCounty(){
        return restTemplate.exchange(url, HttpMethod.GET, getStringHttpEntity(), Example.class);
    }

    private HttpEntity<String> getStringHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "sv-SE");

        return new HttpEntity<String>("parameters", headers);
    }

}
