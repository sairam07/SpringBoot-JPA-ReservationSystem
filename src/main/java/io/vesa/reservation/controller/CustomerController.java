package io.vesa.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vesa.reservation.model.Customer;
import io.vesa.reservation.service.CustomerService;


@RestController
@RequestMapping("/app")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@RequestMapping("/{id}")
	public Customer findOne(@PathVariable int id){
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/customer")
	public void addTopic(@RequestBody Customer customer){
		System.out.println("At add Topic");
		customerService.addCustomer(customer);	
	}


}
