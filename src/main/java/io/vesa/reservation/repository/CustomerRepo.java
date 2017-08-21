package io.vesa.reservation.repository;

import org.springframework.data.repository.CrudRepository;

import io.vesa.reservation.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
