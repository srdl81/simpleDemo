package com.ams.hack.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TripResultDTO {

    @JsonProperty("Trip")
    private List<TripDTO> tripDTO = new ArrayList<>();


    public List<TripDTO> getTripDTO() {
        return tripDTO;
    }

    public void setTripDTO(List<TripDTO> tripDTO) {
        this.tripDTO = tripDTO;
    }
}
