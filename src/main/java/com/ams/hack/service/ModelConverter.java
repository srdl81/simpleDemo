package com.ams.hack.service;


import com.ams.hack.dto.*;
import com.ams.hack.model.*;
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelConverter {

    protected TripResult convertToModel(TripResultDTO dto) {
        List<TripDTO> trips = dto.getTripDTOs();

        TripResult tripResult = new TripResult();
        for (TripDTO tripDTO : trips) {
            Trip trip = new Trip();
            String duration = tripDTO.getDuration();
            trip.setDurationTime(prettyPrint(duration));

            for (LegDTO legDTO : tripDTO.getLegListDTO().getLegDTOs()) {
                Leg leg = new Leg();
                leg.setDestination(covertDestinatonDTO(legDTO.getDestinationDTO()));
                leg.setOrigin(convertOriginDTO(legDTO.getOriginDTO()));
                trip.getLegList().getLegs().add(leg);
            }
            tripResult.getTrips().add(trip);
        }

        return tripResult;
    }

    public LocationResult convertToModel(LocationResultDTO resultDTO) {

        List<Location> locations = resultDTO.getLocationDTOs()
                .stream()
                .map(locationDTO -> createLocation(locationDTO))
                .collect(Collectors.toList());

        LocationResult model = new LocationResult();
        model.getLocations().addAll(locations);

        return model;
    }

    private Location createLocation(LocationDTO locationDTO) {
        return LocationBuilder.aLocation()
                .withId(locationDTO.getId())
                .withName(locationDTO.getName())
                .withCoordinates(new Coordinates(locationDTO.getLat(), locationDTO.getLon()))
                .build();
    }

    private Origin convertOriginDTO(OriginDTO dto) {
        return new Origin(dto.getId(), dto.getName(), new Coordinates(dto.getLatitude(), dto.getLongitude()));
    }

    private Destination covertDestinatonDTO(DestinationDTO dto) {
        return new Destination(dto.getId(), dto.getName(), new Coordinates(dto.getLatitude(), dto.getLongitude()));
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
