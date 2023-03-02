package com.infosys.infyair.service;

import com.infosys.infyair.dto.CustomerDTO;
import com.infosys.infyair.exception.InfyAirException;
import com.infosys.infyair.exception.InvalidUserException;

public interface CustomerService {
    Integer register(CustomerDTO customerDTO) throws InfyAirException;

    CustomerDTO checkLogin(Long mobile, String password) throws InvalidUserException;
}
