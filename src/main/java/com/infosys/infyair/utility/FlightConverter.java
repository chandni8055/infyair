package com.infosys.infyair.utility;

import com.infosys.infyair.entity.FlightEntity;

import com.infosys.infyair.dto.FlightDTO;

public class FlightConverter {
    public static FlightEntity toEntity(FlightDTO flightDTO){
        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setId(flightDTO.getId());
        flightEntity.setCompany(flightDTO.getCompany());
        flightEntity.setFlightNumber(flightDTO.getFlightNumber());
        flightEntity.setDoj(flightDTO.getDoj());
        flightEntity.setSource(flightDTO.getSource());
        flightEntity.setDestination(flightDTO.getDestination());
        flightEntity.setDuration(flightDTO.getDuration());
        flightEntity.setPrice(flightDTO.getPrice());
        flightEntity.setAvailableSeat(flightDTO.getAvailableSeat());

        return flightEntity;
    }
}
