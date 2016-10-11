package com.ams.hack.service;

import com.ams.hack.model.*;
import com.ams.hack.repository.DurationRepository;
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationService {

    @Autowired
    private DurationRepository repository;


    public TravelSummaries fetchDurationByIds(String originId, String destinationId) {
        TravelInfo travelInfo = repository.receiveTravelTimeByIds(originId, destinationId);
        return convertToModel(travelInfo);
    }

    public TravelSummaries fetchDurationByCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {
        TravelInfo travelInfo = repository.receiveTravelTimeByCoordinates(originCoordLong, originCoordLat, destCoordLong, destCoordLat);

        return convertToModel(travelInfo);
    }

    private TravelSummaries convertToModel(TravelInfo travelInfo) {
        List<Trip> trips = travelInfo.getTrip();

        TravelSummaries travelSummaries = new TravelSummaries();
        for (Trip trip: trips){
            TravelSummary summary = new TravelSummary();
            String duration = trip.getDuration();
            summary.setDurationTime(prettyPrint(duration));
            for (Leg leg: trip.getLegList().getLegs()){
                summary.setDestination(leg.getDestination());
                summary.setOrigin(leg.getOrigin());
            }
            travelSummaries.getTrips().add(summary);
        }

        return travelSummaries;
    }

    private String prettyPrint(String duration) {
        Period period = ISOPeriodFormat.standard().parsePeriod(duration);

        PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
                .printZeroAlways()
                .minimumPrintedDigits(1)
                .appendSeparator(" ")
                .appendHours()
                .appendSuffix(" h ")
                .appendSeparator("")
                .printZeroAlways()
                .minimumPrintedDigits(2)
                .appendMinutes()
                .appendSuffix(" min ")
                .toFormatter();

        return periodFormatter.print(period);
    }


}
