/**
 * 
 */
package com.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.beans.TemporaryBooking;
import com.dao.ApplicationDao;
import com.beans.Booking;
import com.beans.BookingDay;
import com.controllers.SuccessController;
/**
 * @author hoshang
 *
 */
@ManagedBean(name = "BookingController", eager = true)
@SessionScoped
public class BookingController {
	private List<BookingDay> BookingDays;
	private String customerName;
	private String email;
	private int number;
	
	public BookingController() {
		setBookingDays(new ArrayList<>());
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the bookingDays
	 */
	public List<BookingDay> getBookingDays() {
		return BookingDays;
	}
	/**
	 * @param bookingDays the bookingDays to set
	 */
	public void setBookingDays(List<BookingDay> bookingDays) {
		this.BookingDays = bookingDays;
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
	
	public String addBookings(List<TemporaryBooking> temporaryBookings,HotelController hotelController) {
		int i=0;
		ApplicationDao dao=new ApplicationDao();
		int bookingId=0;
		if(temporaryBookings.size()>0) {
			Booking booking=new Booking(this.customerName,this.email,this.number);
			bookingId=dao.addBooking(booking);
		}else {
			return "Nothing to Book";
		}
		while (i < temporaryBookings.size()) {
			System.out.println(temporaryBookings.get(i));
			TemporaryBooking temporaryBooking=temporaryBookings.get(i);
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
	    	LocalDate startDate = LocalDate.parse(temporaryBooking.getStartDate(), formatter);
	    	LocalDate endDate = LocalDate.parse(temporaryBooking.getEndDate(), formatter);
	    	for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
	    	{
	    		String dateStringified=date.toString();
	    	    dao.addBookingDay(dateStringified,temporaryBooking.getHotelId(),temporaryBooking.getPrice(),temporaryBooking.getRooms(),bookingId);
	    	}
			i++;
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	            .getExternalContext().getSession(false);
	    session.invalidate();
	    String successMessage="Last Booking made by: "+customerName+"! Successfully Booked your booking ID for reference is #"+bookingId;
	    SuccessController.setSuccessMessage(successMessage); 
		return "home";
		
	}

}
