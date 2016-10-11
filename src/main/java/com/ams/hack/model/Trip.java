package com.ams.hack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip {

    @JsonProperty("LegList")
    private LegList legList;

    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LegList getLegList() {
        return legList;
    }

    public void setLegList(LegList legList) {
        this.legList = legList;
    }
}
