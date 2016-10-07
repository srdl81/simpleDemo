package com.ams.hack.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DurationService {

    String BASE_URL = "https://api.resrobot.se/v2/trip?";
    String API_KEY = "key=ff90d649-2b80-4bed-919d-cc672472a742&";
    String PARAMS = "originId=740000001&destId=740001587&passlist=0&date=2016-10-10&time=08:00&format=json";

    private RestTemplate restTemplate = new RestTemplate();

    public String fetchDuration(){
        String url = BASE_URL + API_KEY + PARAMS;
        return restTemplate.getForObject(url, String.class);
    }

}
