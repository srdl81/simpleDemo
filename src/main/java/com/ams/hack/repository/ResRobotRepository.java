package com.ams.hack.repository;

import com.ams.hack.dto.LocationResultDTO;
import com.ams.hack.dto.TripResultDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import static com.ams.hack.utils.URIBuilderUtils.*;

@Service
public class ResRobotRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResRobotRepository.class);
    private RestTemplate restTemplate = new RestTemplate();

    public TripResultDTO receiveTravelTimeByIds(String originId, String destinationId){
        String url = buildURLForIds(originId, destinationId);
        LOGGER.info(String.format("Request with url:%s", url));

        return restTemplate.getForObject(url, TripResultDTO.class);
    }

    public TripResultDTO receiveTravelTimeByCoordinates(String originCoordLat, String originCoordLong, String destCoordLat, String destCoordLong) {
        String url = buildURLForCoordinates(originCoordLat, originCoordLong, destCoordLat, destCoordLong);
        LOGGER.info(String.format("Request with url:%s", url));

        return restTemplate.getForObject(url, TripResultDTO.class);
    }

    public LocationResultDTO receiveLocations(String q) {
        String url = buildURLForLocation(q);
        LOGGER.info(String.format("Request with url:%s", url));

        return restTemplate.getForObject(url, LocationResultDTO.class);
    }

    public LocationResultDTO receiveNearbyStopsAndLocations(String originCoordLat, String originCoordLong) {
        String url = buildURLForLocationWithCoordinates(originCoordLat, originCoordLong);
        LOGGER.info(String.format("Request with url:%s", url));

        return restTemplate.getForObject(url, LocationResultDTO.class);
    }

}
