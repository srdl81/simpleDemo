package com.ams.hack.service;

import com.ams.hack.dto.TripResultDTO;
import com.ams.hack.model.*;
import com.ams.hack.repository.ResRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DurationService {

    @Autowired
    private ResRobotRepository repository;

    @Autowired
    private ModelConverter modelConverter;


    public TripResult fetchDurationByIds(String originId, String destinationId) {
        TripResultDTO dto = repository.receiveTravelTimeByIds(originId, destinationId);
        return modelConverter.convertToModel(dto);
    }

    public TripResult fetchDurationByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        TripResultDTO dto = repository.receiveTravelTimeByCoordinates(originCoordLong, originCoordLat, destCoordLong, destCoordLat);

        return modelConverter.convertToModel(dto);
    }

}
