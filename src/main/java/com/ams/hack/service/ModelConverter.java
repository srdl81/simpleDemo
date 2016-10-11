package com.ams.hack.service;


import com.ams.hack.dto.*;
import com.ams.hack.model.*;
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelConverter {

    protected TripResult convertToModel(TripResultDTO dto) {
        List<TripDTO> trips = dto.getTripDTO();

        TripResult tripResult = new TripResult();
        for (TripDTO tripDTO: trips){
            Trip trip = new Trip();
            String duration = tripDTO.getDuration();
            trip.setDurationTime(prettyPrint(duration));
            for (LegDTO legDTO: tripDTO.getLegListDTO().getLegDTOs()){
                trip.setDestination(covertDestinatonDTO(legDTO.getDestinationDTO()));
                trip.setOrigin(convertOriginDTO(legDTO.getOriginDTO()));
            }
            tripResult.getTrips().add(trip);
        }

        return tripResult;
    }

    private Origin convertOriginDTO(OriginDTO dto) {
        return new Origin(dto.getId(), dto.getName(), dto.getLatitude(), dto.getLongitude());
    }

    private Destination covertDestinatonDTO(DestinationDTO dto) {
         return new Destination(dto.getId(), dto.getName(), dto.getLatitude(), dto.getLongitude());
    }

    private String prettyPrint(String duration) {
        Period period = ISOPeriodFormat.standard().parsePeriod(duration);

        PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
                .printZeroAlways()
                .minimumPrintedDigits(1)
                .appendSeparator(" ")
                .appendHours()
                .appendSuffix("h")
                .appendSeparator(" ")
                .printZeroAlways()
                .minimumPrintedDigits(2)
                .appendMinutes()
                .appendSuffix(" min")
                .toFormatter();

        return periodFormatter.print(period);
    }
}
