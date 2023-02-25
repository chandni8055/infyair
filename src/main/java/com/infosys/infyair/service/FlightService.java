package com.infosys.infyair.service;

import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.exception.InfyAirException;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    Integer addFlight(FlightDTO flightDTO);

    FlightDTO getFlightDetails(Integer id) throws InfyAirException;

    void updateFlight(Integer id, FlightDTO flightDTO) throws InfyAirException;

    List<FlightDTO> getAllFlightDetails(String source, String destination, LocalDate date);
}
