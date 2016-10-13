package com.ams.hack.service;

import com.ams.hack.dto.LocationResultDTO;
import com.ams.hack.model.LocationResult;
import com.ams.hack.repository.ResRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationService {

    @Autowired
    private ResRobotRepository repository;

    @Autowired
    private ModelConverter modelConverter;

    public LocationResult fetchLocations(String q) {
        LocationResultDTO dto = repository.receiveLocations(q);

        return modelConverter.convertToModel(dto);
    }

    public LocationResult fetchStationsAndStopsBy(String latitude, String longitude) {
        LocationResultDTO dto = repository.receiveNearbyStopsAndLocations(latitude, longitude);

        return modelConverter.convertToModel(dto);
    }
}
