package com.ams.hack.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TripDTO {

    @JsonProperty("LegList")
    private LegListDTO legListDTO;

    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LegListDTO getLegListDTO() {
        return legListDTO;
    }

    public void setLegListDTO(LegListDTO legListDTO) {
        this.legListDTO = legListDTO;
    }
}
