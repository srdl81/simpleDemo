package com.ams.hack.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TripResultDTO {

    @JsonProperty("Trip")
    private List<TripDTO> tripDTOs = new ArrayList<>();


    public List<TripDTO> getTripDTOs() {
        return tripDTOs;
    }

}
