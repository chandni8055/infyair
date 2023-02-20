package com.infosys.infyair.service;

import com.infosys.infyair.Entity.CustomerEntity;
import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.repository.CustomerRepository;
import com.infosys.infyair.utility.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Integer register(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerConverter.toEntity(customerDTO);
        return customerRepository.save(customerEntity).getId();
    }
}
