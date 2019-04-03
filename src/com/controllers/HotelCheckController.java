package com.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.beans.Hotel;
import com.dao.ApplicationDao;

@ManagedBean(name = "HotelCheckController", eager = true)
@SessionScoped  
public class HotelCheckController {  
private String startDate;  
private String endDate;
private long diffDate;
private int rooms;
private int days;
private boolean bookingSelected;
private List<Hotel> hotels;
	public HotelCheckController() {
		System.out.println("Check Rooms Available");
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the diffDate
	 */
	public long getDiffDate() {
		return diffDate;
	}
	/**
	 * @param diffDate the diffDate to set
	 */
	public void setDiffDate(long diffDate) {
		this.diffDate = diffDate;
	}
	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	/**
	 * @return the hotels
	 */
	public List<Hotel> getHotels() {
		return hotels;
	}
	/**
	 * @param hotels the hotels to set
	 */
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}  
    /**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}
	/**
	 * 
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}
	/**
	 * @return the bookingSelected
	 */
	public boolean isBookingSelected() {
		return bookingSelected;
	}
	/**
	 * @param bookingSelected the bookingSelected to set
	 */
	public void setBookingSelected(boolean bookingSelected) {
		this.bookingSelected = bookingSelected;
	}
	/**
	 * 
	 * @return
	 * 
	 */
	public String runDatabaseCall(){
    	System.out.print("Run your db query and return available hotels");
    	ApplicationDao dao=new ApplicationDao();
    	try {
    	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    	LocalDate startDateFormat = LocalDate.parse(this.startDate, formatter);
    	LocalDate endDateFormat = LocalDate.parse(this.endDate, formatter);
    	this.diffDate=endDateFormat.toEpochDay()-startDateFormat.toEpochDay();
    	if(this.diffDate<=0 || this.rooms<=0) {
    		this.hotels=null;
    		return "error in search";
    	}
    	}catch(Exception e) {
    		this.diffDate=0;
    	}
    	this.hotels=dao.checkAvailability(this.rooms, this.startDate, this.endDate);
    	return "hotels found";
    }
}  