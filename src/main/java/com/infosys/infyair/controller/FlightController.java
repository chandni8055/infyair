package com.infosys.infyair.controller;

import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    private FlightService flightService;
    @PostMapping(value = "/flight")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO){
        flightService.addFlight(flightDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/flight/{id}")
    public ResponseEntity<Object> updateFlight(@PathVariable Integer id, @RequestBody FlightDTO flightDTO) throws InfyAirException {
        flightService.updateFlight(id, flightDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/flight/{id}")
    public ResponseEntity<FlightDTO> getFlightDetails(@PathVariable Integer id)throws InfyAirException {
        FlightDTO flightDetails = flightService.getFlightDetails(id);
        return new ResponseEntity<>(flightDetails,HttpStatus.OK);
    }

    @GetMapping(value = "/flight")
    public ResponseEntity<List<FlightDTO>> getAllFlightDetails(@RequestParam("src") String source,
                                                               @RequestParam("dest") String destination,
                                                               @RequestParam("date") LocalDate date) throws InfyAirException {
        List<FlightDTO> allFlightDetails = flightService.getAllFlightDetails(source, destination, date);
        return new ResponseEntity<>(allFlightDetails,HttpStatus.OK);
    }

}
