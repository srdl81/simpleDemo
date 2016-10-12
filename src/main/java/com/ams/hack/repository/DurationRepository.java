package com.ams.hack.repository;

import com.ams.hack.dto.TripResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DurationRepository {

    String BASE_URL = "https://api.resrobot.se/v2/trip?";
    String API_KEY = "key=ff90d649-2b80-4bed-919d-cc672472a742";

    private RestTemplate restTemplate = new RestTemplate();

    public TripResultDTO receiveTravelTimeByIds(String originId, String destinationId){
        String url = getURL(originId, destinationId);
        return restTemplate.getForObject(url, TripResultDTO.class);
    }

    private String getURL(String originId, String destinationId) {
        return BASE_URL + API_KEY + "&originId=" + originId + "&destId=" + destinationId + "&passlist=0&date=2016-10-12&time=09:19&format=json";
    }

    public TripResultDTO receiveTravelTimeByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        String url = BASE_URL + API_KEY + "&originCoordLong=" + originCoordLong + "&originCoordLat=" + originCoordLat + "&destCoordLong=" + destCoordLong + "&destCoordLat=" + destCoordLat + "&passlist=0&date=2016-10-10&time=08:00&format=json";
        return restTemplate.getForObject(url, TripResultDTO.class);
    }
}
