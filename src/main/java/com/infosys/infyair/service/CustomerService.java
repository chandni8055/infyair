package com.infosys.infyair.service;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.exception.InvalidUserException;

import java.security.NoSuchAlgorithmException;

public interface CustomerService {
    Integer register(CustomerDTO customerDTO);

    CustomerDTO checkLogin(Long mobile, String password) throws InvalidUserException;
}
