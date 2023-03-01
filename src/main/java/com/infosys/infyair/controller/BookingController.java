package com.infosys.infyair.controller;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.dto.FlightDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/{customerId}/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping
    public ResponseEntity<BookingDTO> addBooking(@RequestHeader("username") Long mobile,
                                                 @RequestHeader("password") String password,
                                                 @PathVariable("customerId") Integer customerId,
                                                 @RequestBody BookingDTO bookingDTO) throws InvalidUserException, InfyAirException {
        return new ResponseEntity<>(bookingService.addBooking(mobile, password, customerId, bookingDTO), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookingDetails(@RequestHeader("username") Long mobile,
                                                                 @RequestHeader("password") String password,
                                                                 @PathVariable("customerId") Integer customerId) throws InvalidUserException, InfyAirException {
        List<BookingDTO> bookingDTOList = bookingService.getBookingDetails(mobile, password , customerId);
        return new ResponseEntity<>(bookingDTOList, HttpStatus.OK);
    }

    @GetMapping("{bookingId}")
    public ResponseEntity<BookingDTO> getBookingDetails(@RequestHeader("username") Long mobile,
                                                          @RequestHeader("password") String password,
                                                          @PathVariable("customerId") Integer customerId,
                                                          @PathVariable Integer bookingId) throws InvalidUserException, InfyAirException {
        BookingDTO bookingDetails = bookingService.getBookingDetailsById(mobile, password, customerId,bookingId);
        return new ResponseEntity<>(bookingDetails,HttpStatus.OK);
    }

    @DeleteMapping("{bookingId}")
    public ResponseEntity deleteBookingById(@RequestHeader("username") Long mobile,
                                              @RequestHeader("password") String password,
                                              @PathVariable("customerId") Integer customerId,
                                              @PathVariable Integer bookingId) throws InvalidUserException, InfyAirException {
     bookingService.deleteBookingById(mobile, password, customerId , bookingId);
     return new ResponseEntity<>(HttpStatus.OK);



    }


    /*@DeleteMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyBankException {
        customerService.deleteCustomer(customerId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }*/

}
