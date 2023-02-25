package com.infosys.infyair.repository;

import com.infosys.infyair.entity.FlightEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends CrudRepository<FlightEntity,Integer> {

    List<FlightEntity> findBySourceAndDestinationAndDojBetween(String source, String destination, LocalDateTime start, LocalDateTime end);
}
