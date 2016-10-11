package com.ams.hack.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class LegListDTO {

    @JsonProperty("Leg")
    private List<LegDTO> legDTOs = new ArrayList<>();

    public List<LegDTO> getLegDTOs() {
        return legDTOs;
    }

    public void setLegDTOs(List<LegDTO> legDTOs) {
        this.legDTOs = legDTOs;
    }
}
