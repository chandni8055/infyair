package com.infosys.infyair.service;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;

import java.util.List;

public interface BookingService {

    BookingDTO addBooking(Long mobile, String password, Integer customerId, BookingDTO bookingDTO) throws InvalidUserException, InfyAirException;

    List<BookingDTO> getBookingDetails(Long mobile, String password, Integer customerId) throws InvalidUserException, InfyAirException;

    BookingDTO getBookingDetailsById(Long mobile, String password, Integer customerId, Integer bookingId) throws InvalidUserException, InfyAirException;

    void deleteBookingById(Long mobile, String password, Integer customerId, Integer bookingId) throws InfyAirException, InvalidUserException;
}
