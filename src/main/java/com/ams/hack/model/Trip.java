package com.ams.hack.model;


public class Trip {

    private LegList legList = new LegList();
    private String duration;

    public LegList getLegList() {
        return legList;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
