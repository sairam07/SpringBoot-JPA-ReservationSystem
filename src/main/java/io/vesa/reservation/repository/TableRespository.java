package io.vesa.reservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.vesa.reservation.model.ReservationTable;

public interface TableRespository extends CrudRepository<ReservationTable, Integer>{

	public List<ReservationTable> findByDate(String date);
	public ReservationTable findByCustId(int cust_id);
}
