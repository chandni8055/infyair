package com.infosys.infyair.repository;

import com.infosys.infyair.entity.FlightEntity;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<FlightEntity,Integer> {
}
