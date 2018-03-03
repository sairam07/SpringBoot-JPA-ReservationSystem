package io.vesa.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vesa.reservation.model.Customer;
import io.vesa.reservation.model.ReservationTable;
import io.vesa.reservation.repository.CustomerRepo;
import io.vesa.reservation.repository.TableRespository;

@Service
public class ReservationService {
	
	@Autowired
	private TableRespository tableRepository;
	@Autowired
	private CustomerRepo customerRepository;

	public List<ReservationTable> findAll() {
		ArrayList<ReservationTable> tableList = new ArrayList<ReservationTable>();
		tableRepository.findAll().forEach(tableList::add);
		return tableList;
	}

	public List<ReservationTable> findByDate(String date) {
		ArrayList<ReservationTable> tableList = new ArrayList<ReservationTable>();
		tableRepository.findByDate(date).forEach(tableList::add);
		return tableList;
	}

	public ReservationTable addTable(ReservationTable table, int cust_id) {
		table.setStatus("OCCUPIED");
		table.setCustId(cust_id);
		tableRepository.save(table);
		Customer customer = customerRepository.findOne(cust_id);
		customer.setStatus("RESERVED");
		customerRepository.save(customer);
		return table;
	}

	public ReservationTable updateTable(ReservationTable table, int cust_id) {
		ReservationTable tableUpdated =tableRepository.findByCustId(cust_id);
		if(!table.getTable_name().isEmpty()) tableUpdated.setTable_name(table.getTable_name());
		else if (!table.getTime().isEmpty()) tableUpdated.setTime(table.getTime());
		else if (!table.getDate().isEmpty()) tableUpdated.setDate(table.getDate());
		tableRepository.save(tableUpdated);
		Customer customer = customerRepository.findOne(cust_id);
		customer.setStatus("RESERVED");
		customerRepository.save(customer);
		return tableUpdated;
		
	}

	public void deleteTable(int cust_id) {
		// TODO Auto-generated method stub
		System.out.println("At Deleting");
		ReservationTable table =tableRepository.findByCustId(cust_id);
		tableRepository.delete(table);
		customerRepository.delete(cust_id);
	}
	
	

}
