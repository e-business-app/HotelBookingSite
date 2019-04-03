package com.controllers;

import com.beans.TemporaryBooking;
import com.beans.Hotel;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "TemporaryBookingController", eager = true)
@SessionScoped
public class TemporaryBookingController {
	private List<TemporaryBooking> temporaryBookings;
	public TemporaryBookingController() {
		temporaryBookings = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the temporaryBookings
	 */
	public List<TemporaryBooking> getTemporaryBookings() {
		return temporaryBookings;
	}
	/**
	 * @param temporaryBookings the temporaryBookings to set
	 */
	public void setTemporaryBookings(List<TemporaryBooking> temporaryBookings) {
		this.temporaryBookings = temporaryBookings;
	}
	
	public String addTemporaryBookings(int hotelId, String hotelName, String image, String startDate, String endDate, int rooms,float price) {
		TemporaryBooking temporaryBooking= new TemporaryBooking(hotelId,hotelName,image,startDate,endDate,rooms,price);
		
		this.temporaryBookings.add(temporaryBooking);
		return "book";
	}
	

}
