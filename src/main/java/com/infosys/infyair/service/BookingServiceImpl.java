package com.infosys.infyair.service;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.entity.BookingEntity;
import com.infosys.infyair.entity.CustomerEntity;
import com.infosys.infyair.entity.FlightEntity;
import com.infosys.infyair.entity.PassengerEntity;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.repository.BookingRepository;
import com.infosys.infyair.repository.CustomerRepository;
import com.infosys.infyair.repository.FlightRepository;
import com.infosys.infyair.utility.BookingConverter;
import com.infosys.infyair.utility.PassengerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Override
    public BookingDTO addBooking(Long mobile, String password, Integer customerId, BookingDTO bookingDTO) throws InvalidUserException, InfyAirException {

        customerService.checkLogin(mobile, password);

        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerId);
        if(optionalCustomerEntity.isEmpty()) {
            throw new InfyAirException("User does not exist");
        }

        Optional<FlightEntity> optionalFlightEntity = flightRepository.findById(bookingDTO.getFlightId());
        if(optionalFlightEntity.isEmpty()) {
            throw new InfyAirException("Flight does not exist");
        }

        BookingEntity bookingEntity = BookingConverter.toEntity(bookingDTO);

        //set booking customer
        bookingEntity.setCustomerEntity(optionalCustomerEntity.get());

        //set booking flight
        bookingEntity.setFlightEntity(optionalFlightEntity.get());

        //set booking passenger
        List<PassengerEntity> passengerEntities = bookingDTO
                .getPassengerDTOList()
                .stream()
                .map(PassengerConverter::toEntity)
                .toList();

        passengerEntities.forEach(passengerEntity -> passengerEntity.setCustomerEntity(optionalCustomerEntity.get()));

        bookingEntity.setPassengers(passengerEntities);

        bookingEntity = bookingRepository.save(bookingEntity);
        bookingDTO.setId(bookingEntity.getId());

        return bookingDTO;

    }

    @Override
    public List<BookingDTO> getBookingDetails(Long mobile, String password, Integer customerId) throws InvalidUserException, InfyAirException {
        customerService.checkLogin(mobile, password);

        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerId);

        if(optionalCustomerEntity.isEmpty()) {
            throw new InfyAirException("User does not exist");
        }

        List<BookingEntity> allByCustomerEntity = bookingRepository.findAllByCustomerEntity(optionalCustomerEntity.get());

        return allByCustomerEntity.stream()
                .map(BookingConverter::toDto)
                .toList();
    }

    @Override
    public BookingDTO getBookingDetailsById(Long mobile, String password, Integer customerId, Integer bookingId) throws InvalidUserException, InfyAirException {
        customerService.checkLogin(mobile, password);

        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerId);

        if(optionalCustomerEntity.isEmpty()) {
            throw new InfyAirException("User does not exist");
        }

        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findByIdAndCustomerEntity(bookingId, optionalCustomerEntity.get());

        if(optionalBookingEntity.isEmpty()) {
            throw new InfyAirException("Booking does not exist");
        }

        return BookingConverter.toDto(optionalBookingEntity.get());


    }

    @Override
    public void deleteBookingById(Long mobile, String password, Integer customerId, Integer bookingId) throws InfyAirException, InvalidUserException {
        customerService.checkLogin(mobile, password);

        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerId);

        if(optionalCustomerEntity.isEmpty()) {
            throw new InfyAirException("User does not exist");
        }

        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findByIdAndCustomerEntity(bookingId, optionalCustomerEntity.get());

        if(optionalBookingEntity.isEmpty()) {
            throw new InfyAirException("Booking does not exist");
        }

        bookingRepository.deleteById(bookingId);
    }
}