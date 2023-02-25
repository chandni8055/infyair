package com.infosys.infyair.utility;

import com.infosys.infyair.dto.BookingDTO;
import com.infosys.infyair.entity.BookingEntity;

public class BookingConverter {
    public static BookingEntity toEntity(BookingDTO bookingDTO){
        BookingEntity bookingEntity = new BookingEntity();

        if(null != bookingDTO.getId()) {
            bookingEntity.setId(bookingDTO.getId());
        }
        bookingEntity.setBookingTime(bookingDTO.getBookingTime());
        bookingEntity.setNumberOfSeat(bookingDTO.getNumberOfSeat());

        return bookingEntity;
    }

    public static BookingDTO toDto(BookingEntity bookingEntity){
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(bookingEntity.getId());
        bookingDTO.setBookingTime(bookingEntity.getBookingTime());
        bookingDTO.setNumberOfSeat(bookingEntity.getNumberOfSeat());
        bookingDTO.setPnr(bookingEntity.getPnr());

        return bookingDTO;
    }

}
