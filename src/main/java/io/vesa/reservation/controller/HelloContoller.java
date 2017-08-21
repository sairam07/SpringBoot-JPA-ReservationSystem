package io.vesa.reservation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springhome")
public class HelloContoller {

	@RequestMapping("/hello")
	public String sayHello(){
		
		return "Hello Sairam, Spring Boot started and wants to say Hi! ";
	}
}
