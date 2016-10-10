package com.ams.hack.service;

import com.ams.hack.model.TravelInfo;
import com.ams.hack.repository.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurationService {

    @Autowired
    private DurationRepository repository;

    public TravelInfo fetchDurationByIds(String originId, String destinationId) {
        return repository.receiveTravelTimeByIds(originId, destinationId);
    }

    public TravelInfo fetchDurationByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        return repository.receiveTravelTimeByCoordinates(originCoordLong, originCoordLat, destCoordLong, destCoordLat);
    }


}
