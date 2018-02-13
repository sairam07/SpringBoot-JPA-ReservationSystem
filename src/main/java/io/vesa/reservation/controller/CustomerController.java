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

@CrossOrigin(origins = "https://venad-web-server.herokuapp.com")
@RestController
@RequestMapping("/app/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("")
	public List<Customer> findAll(){
		System.out.println("At find All");
		return customerService.findAll();
	}
	
	@RequestMapping("/{id}")
	public Customer findCustomer(@PathVariable int id){
		System.out.println("At Find By Id" +id);
		return customerService.getCustomer(id);
	}
	
	@RequestMapping("/status")
	public List<Customer> findStatus(){
		System.out.println("At find by status");
		return customerService.getCustomerStatus();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="")
	public Customer addCustomer(@RequestBody Customer customer){
		System.out.println("At add Customer");
		customerService.addCustomer(customer);	
		return customer;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="")
	public Customer updateCustomer(@RequestBody Customer customer){
		System.out.println("At update Customer");
		customerService.updateCustomer(customer);
		return customer;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteCustomer(@PathVariable int id){
		System.out.println("At delete customer");
		customerService.deleteCustomer(id);	
	}


}
