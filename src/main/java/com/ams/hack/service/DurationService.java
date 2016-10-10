package com.ams.hack.service;

import com.ams.hack.model.TravelInfo;
import com.ams.hack.repository.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurationService {

    @Autowired
    private DurationRepository repository;

    public TravelInfo fetchDuration(String originId, String destinationId) {
        return repository.receiveTravelTime(originId, destinationId);
    }


}
