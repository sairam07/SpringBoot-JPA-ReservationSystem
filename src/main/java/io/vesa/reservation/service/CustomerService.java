package io.vesa.reservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vesa.reservation.model.Customer;
import io.vesa.reservation.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepository;
	
	/*private ArrayList<Customer> custList = new ArrayList<Customer>(Arrays.asList(
			new Customer(1, "Sai", "Ram"),
			new Customer(2, "Venkata", "Ram")
			));*/
	

	public List<Customer> findAll() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(custList::add);
		
		return custList;
		
	}

	public Customer getCustomer(int id) {
		
		//return custList.parallelStream().filter(c -> c.getCust_id()==id).findFirst().get();
		return null;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	
}
