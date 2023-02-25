package com.infosys.infyair.controller;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping("/booking")
    public ResponseEntity<BookingDTO> addBooking(@RequestHeader("username") Long mobile,
                                                 @RequestHeader("password") String password,
                                                 @RequestBody BookingDTO bookingDTO) throws InvalidUserException, InfyAirException {
        return new ResponseEntity<>(bookingService.addBooking(mobile, password, bookingDTO), HttpStatus.CREATED);

 }
}
