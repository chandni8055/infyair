package com.infosys.infyair.repository;

import com.infosys.infyair.Entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
