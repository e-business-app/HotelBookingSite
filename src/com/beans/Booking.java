package com.beans;

public class Booking {
	private int id;
	private String customerName;
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public Booking(int id,String customerName) {
		this.id=id;
		this.customerName= customerName;
	}
	public Booking(String customerName) {
		this.customerName= customerName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerName=" + customerName + "]";
	}
	

}
