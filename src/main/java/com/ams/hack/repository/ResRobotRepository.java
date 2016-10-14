package com.ams.hack.repository;

import com.ams.hack.dto.LocationResultDTO;
import com.ams.hack.dto.TripResultDTO;
import com.ams.hack.utils.GeneralDateUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.ams.hack.utils.GeneralDateUtils.*;

@Service
public class ResRobotRepository {

    private static final String TRIP = "trip?";
    private static final String LOCATION = "location.name.json?";
    private static final String NEARBY_STOPS = "location.nearbystops.json?";
    private static final String BASE_URL = "https://api.resrobot.se/v2/";
    private static final String API_KEY = "key=ff90d649-2b80-4bed-919d-cc672472a742";

    private RestTemplate restTemplate = new RestTemplate();

    public TripResultDTO receiveTravelTimeByIds(String originId, String destinationId){
        String url = getURL(originId, destinationId);
        return restTemplate.getForObject(url, TripResultDTO.class);
    }

    private String getURL(String originId, String destinationId) {

        String date = calculateNextBusinessDate(LocalDate.now());
        return BASE_URL + TRIP + API_KEY + "&originId=" + originId + "&destId=" + destinationId + "&passlist=0&date=" + date+ "&time=07:30&format=json";
    }

    public TripResultDTO receiveTravelTimeByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        String date = calculateNextBusinessDate(LocalDate.now());
        String url = BASE_URL + TRIP + API_KEY + "&originCoordLong=" + originCoordLong + "&originCoordLat=" + originCoordLat + "&destCoordLong=" + destCoordLong + "&destCoordLat=" + destCoordLat + "&passlist=0&date=" + date + "&time=07:30&format=json";
        return restTemplate.getForObject(url, TripResultDTO.class);
    }

    public LocationResultDTO receiveLocations(String q) {
        String url = BASE_URL + LOCATION + API_KEY + "&input=" + q;
        return restTemplate.getForObject(url, LocationResultDTO.class);
    }

    public LocationResultDTO receiveNearbyStopsAndLocations(String originCoordLat, String originCoordLong) {
        String url = BASE_URL + NEARBY_STOPS + API_KEY + "&originCoordLat=" + originCoordLat + "&originCoordLong=" + originCoordLong;

        return restTemplate.getForObject(url, LocationResultDTO.class);
    }

}
