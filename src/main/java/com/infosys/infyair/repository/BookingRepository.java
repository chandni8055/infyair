package com.infosys.infyair.repository;

import com.infosys.infyair.entity.BookingEntity;
import com.infosys.infyair.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

    List<BookingEntity> findAllByCustomerEntity(CustomerEntity customerEntity);

    Optional<BookingEntity> findByIdAndCustomerEntity(Integer bookingId, CustomerEntity customerEntity);


}
