package com.infosys.infyair.service;

import com.infosys.infyair.entity.FlightEntity;
import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.repository.FlightRepository;
import com.infosys.infyair.utility.FlightConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

   @Override
    public Integer addFlight(FlightDTO flightDTO) {
        FlightEntity flightEntity = FlightConverter.toEntity(flightDTO);
        return flightRepository.save(flightEntity).getId();
    }

    @Override
    public FlightDTO getFlightDetails(Integer id) throws InfyAirException {
       Optional<FlightEntity> flightEntityOptional = flightRepository.findById(id);
       if(flightEntityOptional.isPresent()){
           return FlightConverter.toDto(flightEntityOptional.get());
       }
        throw new InfyAirException("NO.DETAILS.FOUND");
    }

    @Override
    public void updateFlight(Integer id, FlightDTO flightDTO) throws InfyAirException {
       Optional<FlightEntity> flightEntityOptional = flightRepository.findById(id);
       if(flightEntityOptional.isPresent()) {
           FlightEntity flightEntity = FlightConverter.toEntity(flightDTO);
           flightEntity.setId(id);

           flightRepository.save(flightEntity);
       } else {
           throw new InfyAirException("Flight not found");
       }
    }

    @Override
    public List<FlightDTO> getAllFlightDetails(String source, String destination, LocalDate date) {
        List<FlightEntity> bySourceAndDestination =
                flightRepository.findBySourceAndDestinationAndDojBetween(
                        source,
                        destination,
                        date.atStartOfDay(),
                        date.plusDays(1).atStartOfDay()
                );

        return bySourceAndDestination
                .stream()
                .map(FlightConverter::toDto)
                .toList();

    }


}
