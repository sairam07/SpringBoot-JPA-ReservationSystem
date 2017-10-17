package io.vesa.reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class ReservationTable {
	
	@Id
	private int custId;
	private String table_name;
	private String status;
	private String time;
	private String date;
	
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int cust_id) {
		this.custId = cust_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Tab [ status=" + status + ", cust_id=" + custId + ", date=" + date + "]";
	}
	
	
}
