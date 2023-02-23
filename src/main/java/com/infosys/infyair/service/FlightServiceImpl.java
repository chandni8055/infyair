package com.infosys.infyair.service;

import com.infosys.infyair.entity.FlightEntity;
import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.repository.FlightRepository;
import com.infosys.infyair.utility.FlightConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

   @Override
    public Integer addFlight(FlightDTO flightDTO) {
        FlightEntity flightEntity = FlightConverter.toEntity(flightDTO);
        return flightRepository.save(flightEntity).getId();
    }


/*
    @Override
    public Integer register(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerConverter.toEntity(customerDTO);
        return customerRepository.save(customerEntity).getId();
    }*/
}
