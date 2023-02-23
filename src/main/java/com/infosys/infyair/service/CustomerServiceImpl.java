package com.infosys.infyair.service;

import com.infosys.infyair.entity.CustomerEntity;
import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.repository.CustomerRepository;
import com.infosys.infyair.utility.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Integer register(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerConverter.toEntity(customerDTO);
        return customerRepository.save(customerEntity).getId();
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




    /*public boolean login(LoginDTO loginDTO) {
        Boolean flag=false;
        logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
        Optional<Customer> cust;
        cust=custRepo.findById(loginDTO.getPhoneNo());
        if(cust.isPresent() && cust.get() != null && cust.get().getPassword().equals(loginDTO.getPassword())) {
            flag= true;
        }
        return flag;
    }*/
}
