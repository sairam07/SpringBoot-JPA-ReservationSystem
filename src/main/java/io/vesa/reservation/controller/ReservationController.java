package io.vesa.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vesa.reservation.model.ReservationTable;
import io.vesa.reservation.service.ReservationService;

@RestController
@RequestMapping("/app/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("")
	public List<ReservationTable> findAll(){
		System.out.println("At Reservation Find All");
		return reservationService.findAll();
	}
	
	@RequestMapping("/{date}")
	public List<ReservationTable> findByDate(@PathVariable String date){
		System.out.println("At Reservation FindByDate");
		return reservationService.findByDate(date);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{cust_id}")
	public ReservationTable addTable(@RequestBody ReservationTable table, @PathVariable int cust_id ){
		System.out.println("At add Table" +cust_id);
		reservationService.addTable(table,cust_id);
		return table;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{cust_id}")
	public ReservationTable updateTable(@RequestBody ReservationTable table, @PathVariable int cust_id ){
		System.out.println("At update Table" +cust_id);
		reservationService.updateTable(table,cust_id);
		return table;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{cust_id}")
	public void deleteTable(@PathVariable int cust_id){
		System.out.println("At delete table");
		reservationService.deleteTable(cust_id);	
	}
	

}
