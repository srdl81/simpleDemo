package com.ams.hack.service;

import com.ams.hack.dto.TripResultDTO;
import com.ams.hack.model.*;
import com.ams.hack.repository.ResRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripService {

    @Autowired
    private ResRobotRepository repository;

    @Autowired
    private ModelConverter modelConverter;


    public TripResult fetchTripByIds(String originId, String destinationId) {
        TripResultDTO dto = repository.receiveTravelTimeByIds(originId, destinationId);

        return modelConverter.convertToModel(dto);
    }

    public TripResult fetchTripByCoordinates(String originCoordLat, String originCoordLong, String destCoordLat, String destCoordLong) {
        TripResultDTO dto = repository.receiveTravelTimeByCoordinates(originCoordLat, originCoordLong, destCoordLat, destCoordLong);

        return modelConverter.convertToModel(dto);
    }

}
