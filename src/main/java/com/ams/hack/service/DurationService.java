package com.ams.hack.service;

import com.ams.hack.model.*;
import com.ams.hack.repository.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DurationService {

    @Autowired
    private DurationRepository repository;

    @Autowired
    private ModelConverter modelConverter;


    public TravelSummaries fetchDurationByIds(String originId, String destinationId) {
        TravelInfo travelInfo = repository.receiveTravelTimeByIds(originId, destinationId);
        return modelConverter.convertToModel(travelInfo);
    }

    public TravelSummaries fetchDurationByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        TravelInfo travelInfo = repository.receiveTravelTimeByCoordinates(originCoordLong, originCoordLat, destCoordLong, destCoordLat);

        return modelConverter.convertToModel(travelInfo);
    }

}
