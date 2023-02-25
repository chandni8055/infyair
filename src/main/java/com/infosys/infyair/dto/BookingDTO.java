package com.infosys.infyair.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDTO {
    private Integer id;
    private Integer customerId;
    private Integer flightId;
    private Integer paymentId;
    private LocalDateTime bookingTime;
    private Integer numberOfSeat;
    private String pnr;
    List<PassengerDTO> passengerDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Integer numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public List<PassengerDTO> getPassengerDTOList() {
        return passengerDTOList;
    }

    public void setPassengerDTOList(List<PassengerDTO> passengerDTOList) {
        this.passengerDTOList = passengerDTOList;
    }
}
