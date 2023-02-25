package com.infosys.infyair.utility;

import com.infosys.infyair.dto.PassengerDTO;
import com.infosys.infyair.entity.PassengerEntity;

public class PassengerConverter {

    public static PassengerDTO toDto(PassengerEntity passengerEntity) {
        PassengerDTO passengerDTO =  new PassengerDTO();
        passengerDTO.setId(passengerEntity.getId());
        passengerDTO.setFirstName(passengerEntity.getFirstName());
        passengerDTO.setLastName(passengerEntity.getLastName());
        passengerDTO.setAge(passengerEntity.getAge());
        passengerDTO.setGender(passengerEntity.getGender());
        passengerDTO.setMobile(passengerEntity.getMobile());
        return passengerDTO;
    }

    public static PassengerEntity toEntity(PassengerDTO passengerDTO) {
        PassengerEntity passengerEntity =  new PassengerEntity();

        if(null != passengerDTO.getId()) {
            passengerEntity.setId(passengerDTO.getId());
        }

        passengerEntity.setFirstName(passengerDTO.getFirstName());
        passengerEntity.setLastName(passengerDTO.getLastName());
        passengerEntity.setAge(passengerDTO.getAge());
        passengerEntity.setGender(passengerDTO.getGender());
        passengerEntity.setMobile(passengerDTO.getMobile());

        return passengerEntity;
    }
}
