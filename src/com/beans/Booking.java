package com.beans;

public class Booking {
	private int id;
	private String customerName;
	private String email;
	private int number;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public Booking(String customerName, String email, int number) {
		this.customerName= customerName;
		this.email=email;
		this.number=number;
	}
	public Booking(int id,String customerName, String email, int number) {
		this.id=id;
		this.customerName= customerName;
		this.email=email;
		this.number=number;
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
