package com.infosys.infyair.controller;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Environment environment;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody CustomerDTO customerDTO){

        Integer customerId = customerService.register(customerDTO);
        String successMessage = environment.getProperty("API.REGISTER_SUCCESS") + customerId;
        return new ResponseEntity<>(successMessage , HttpStatus.CREATED);
    }

}
