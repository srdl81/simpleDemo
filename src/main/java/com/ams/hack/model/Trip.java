package com.ams.hack.model;


public class Trip {

    private LegList legList = new LegList();
    private String durationTime;

    public LegList getLegList() {
        return legList;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }
}
