package com.ams.hack.service;

import com.ams.hack.repository.ResRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationService {

    @Autowired
    private ResRobotRepository repository;

    @Autowired
    private ModelConverter modelConverter;


    public String fetchLocations(String q) {
        String dto = repository.receiveLocations(q);
        return dto;
//        return modelConverter.convertToModel(dto);
    }

}
