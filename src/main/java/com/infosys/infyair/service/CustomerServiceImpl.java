package com.infosys.infyair.service;

import com.infosys.infyair.entity.CustomerEntity;
import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.repository.CustomerRepository;
import com.infosys.infyair.utility.CustomerConverter;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Integer register(CustomerDTO customerDTO) throws InfyAirException {
        CustomerEntity customerEntity = CustomerConverter.toEntity(customerDTO);
        CustomerEntity saveCustomer;
        try {
            saveCustomer = customerRepository.save(customerEntity);
        } catch (Exception exception) {
            throw new InfyAirException("Mobile number or Email id already exists");
        }

        return saveCustomer.getId();
    }

    @Override
    public CustomerDTO checkLogin(Long mobile, String password) throws InvalidUserException {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findByMobile(mobile);

        if(customerEntityOptional.isPresent()
                && customerEntityOptional.get() != null
                && customerEntityOptional.get().getPass().equals(password)) {

            return CustomerConverter.toDto(customerEntityOptional.get());
        }
        throw new InvalidUserException("Username and password don't match");
    }
}
