package io.vesa.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.vesa.reservation.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.status is NOT NULL")
	List<Customer> findByStatus();

}
