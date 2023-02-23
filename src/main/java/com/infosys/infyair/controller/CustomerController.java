package com.infosys.infyair.controller;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.exception.InvalidUserException;
import com.infosys.infyair.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody CustomerDTO customerDTO) {

        customerService.register(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/login")
    public CustomerDTO login(@RequestHeader("username") Long mobile, @RequestHeader("password") String password) throws InvalidUserException {

        return customerService.checkLogin(mobile, password);
    }

}
