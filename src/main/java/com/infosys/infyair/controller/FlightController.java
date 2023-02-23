package com.infosys.infyair.controller;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    private FlightService flightService;
    @PostMapping(value = "/flight")
    public ResponseEntity<Object> addFlight(@RequestBody FlightDTO flightDTO){
        flightService.addFlight(flightDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   /* @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody CustomerDTO customerDTO) {

        customerService.register(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

}
