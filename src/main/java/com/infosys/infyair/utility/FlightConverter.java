package com.infosys.infyair.utility;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.entity.CustomerEntity;
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

    public static FlightDTO toDto(FlightEntity flightEntity){
        FlightDTO flightDTO = new FlightDTO();
        if(null != flightEntity.getId()) {
            flightDTO.setId(flightEntity.getId());
        }

        flightDTO.setCompany(flightEntity.getCompany());
        flightDTO.setFlightNumber(flightEntity.getFlightNumber());
        flightDTO.setDoj(flightEntity.getDoj());
        flightDTO.setSource(flightEntity.getSource());
        flightDTO.setDestination(flightEntity.getDestination());
        flightDTO.setDuration(flightEntity.getDuration());
        flightDTO.setPrice(flightEntity.getPrice());
        flightDTO.setAvailableSeat(flightEntity.getAvailableSeat());
        return flightDTO;
    }

}
