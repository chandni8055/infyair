package com.infosys.infyair.service;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;

public interface BookingService {

    BookingDTO addBooking(Long mobile, String password, BookingDTO bookingDTO) throws InvalidUserException, InfyAirException;
}
