package com.ams.hack.service;


import com.ams.hack.dto.*;
import com.ams.hack.model.*;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ModelConverter {

    public TripResult convertToModel(TripResultDTO resultDTOs) {
        return TripBuilder.aTrip()
                .withOrigin(fetchOrigin(resultDTOs))
                .withDestination(fetchDestination(resultDTOs))
                .withDuration(fetchDuration(resultDTOs))
                .build();
    }

    public LocationResult convertToModel(LocationResultDTO resultDTO) {
        return new LocationResult(
                resultDTO.getLocationDTOs().stream()
                        .map(locationDTO -> createLocation(locationDTO))
                        .collect(Collectors.toList())
        );
    }

    private Origin fetchOrigin(TripResultDTO resultDTO) {
        List<LegDTO> legDTOs = resultDTO.getTripDTOs().stream().findFirst().get().getLegListDTO().getLegDTOs();
        OriginDTO dto = getFirst(legDTOs).getOriginDTO();

        return new Origin(dto.getId(), dto.getName(), new Coordinates(dto.getLatitude(), dto.getLongitude()));
    }

    private Destination fetchDestination(TripResultDTO resultDTO) {
        List<LegDTO> legDTOs = resultDTO.getTripDTOs().stream().findFirst().get().getLegListDTO().getLegDTOs();
        DestinationDTO dto = getLast(legDTOs).getDestinationDTO();

        return new Destination(dto.getId(), dto.getName(), new Coordinates(dto.getLatitude(), dto.getLongitude()));
    }

    private String fetchDuration(TripResultDTO resultDTOs) {
        return resultDTOs.getTripDTOs().stream()
                .map(dto -> dto.getDuration())
                .sorted()
                .findFirst()
                .get();
    }

    private LegDTO getFirst(List<LegDTO> legs) {
        return legs.stream()
                .findFirst()
                .get();
    }

    private LegDTO getLast(List<LegDTO> legs) {
        return legs.stream()
                .filter(Objects::nonNull)
                .reduce((a, b) -> b)
                .get();
    }

    private Location createLocation(LocationDTO locationDTO) {
        return LocationBuilder.aLocation()
                .withId(locationDTO.getId())
                .withName(locationDTO.getName())
                .withCoordinates(new Coordinates(locationDTO.getLat(), locationDTO.getLon()))
                .build();
    }

    public static String prettyPrint(String duration) {
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
