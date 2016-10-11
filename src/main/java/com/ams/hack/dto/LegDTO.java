package com.ams.hack.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LegDTO {

    @JsonProperty("Origin")
    private OriginDTO originDTO;

    @JsonProperty("Destination")
    private DestinationDTO destinationDTO;

    public OriginDTO getOriginDTO() {
        return originDTO;
    }

    public void setOriginDTO(OriginDTO originDTO) {
        this.originDTO = originDTO;
    }

    public DestinationDTO getDestinationDTO() {
        return destinationDTO;
    }

    public void setDestinationDTO(DestinationDTO destinationDTO) {
        this.destinationDTO = destinationDTO;
    }
}
