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

    String BASE_URL = "https://api.resrobot.se/v2/trip?";
    String API_KEY = "key=ff90d649-2b80-4bed-919d-cc672472a742&";
    String PARAMS = "originId=740000001&destId=740001587&passlist=0&date=2016-10-10&time=08:00&format=json";

    private RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<Example> fetchVacenciesByCounty(){
        return restTemplate.exchange(url, HttpMethod.GET, getStringHttpEntity(), Example.class);
    }

    public String fetchDuration(){
        return restTemplate.getForObject(BASE_URL + API_KEY + PARAMS, String.class);
    }

    private HttpEntity<String> getStringHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "sv-SE");

        return new HttpEntity<String>("parameters", headers);
    }

}
