package com.infosys.infyair.repository;

import com.infosys.infyair.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByMobile(Long mobile);
}
