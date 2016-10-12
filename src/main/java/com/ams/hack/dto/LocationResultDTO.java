package com.ams.hack.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class LocationResultDTO {

    @JsonProperty("StopLocation")
    private List<LocationDTO> locationDTOs = new ArrayList<>();

    public List<LocationDTO> getLocationDTOs() {
        return locationDTOs;
    }
}
