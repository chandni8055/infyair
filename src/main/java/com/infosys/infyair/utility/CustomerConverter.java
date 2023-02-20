package com.infosys.infyair.utility;

import com.infosys.infyair.Entity.CustomerEntity;
import com.infosys.infyair.dto.CustomerDTO;

public class CustomerConverter {

    public static CustomerDTO toDto(CustomerEntity customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();
        if(null != customerDTO.getCustomerId()) {
            customerDTO.setCustomerId(customerEntity.getId());
        }

        customerDTO.setFirstName(customerEntity.getFirstName());
        customerDTO.setLastName(customerEntity.getLastName());
        customerDTO.setAge(customerEntity.getAge());
        customerDTO.setGender(customerEntity.getGender());
        customerDTO.setMobile(customerEntity.getMobile());
        customerDTO.setCity(customerEntity.getCity());
        customerDTO.setEmail(customerEntity.getEmail());
        customerDTO.setPassword(customerEntity.getPass());
        customerDTO.setToken(customerEntity.getToken());

        return customerDTO;
    }

    public static CustomerEntity toEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(customerDTO.getCustomerId());
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setMobile(customerDTO.getMobile());
        customerEntity.setCity(customerDTO.getCity());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPass(customerDTO.getPassword());
        customerEntity.setToken(customerDTO.getToken());

        return customerEntity;
    }
}
