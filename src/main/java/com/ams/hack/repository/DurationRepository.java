package com.ams.hack.repository;

import com.ams.hack.model.TravelInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DurationRepository {

    String BASE_URL = "https://api.resrobot.se/v2/trip?";
    String API_KEY = "key=ff90d649-2b80-4bed-919d-cc672472a742&";
    String PARAMS = "originId=740000001&destId=740001587&passlist=0&date=2016-10-10&time=08:00&format=json";

    private RestTemplate restTemplate = new RestTemplate();

    public TravelInfo receiveTravelTime(String originId, String destinationId){
        String url = BASE_URL + API_KEY + PARAMS;
        return restTemplate.getForObject(url, TravelInfo.class);
    }
}
