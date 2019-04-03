package com.beans;
import java.util.Date;

public class BookingDay {
	private int id;
	private int bookingId;
	private int rooms;
	private Date date;
	private int hotelId;
	private float price;
	
	public BookingDay() {
		
	}
	/**
	 * @param id
	 * @param bookingId
	 * @param rooms
	 * @param date
	 * @param hotelId
	 * @param price 
	 */
	public BookingDay(int id, int bookingId, int rooms, Date date, int hotelId, float price) {
		this.id = id;
		this.bookingId = bookingId;
		this.rooms = rooms;
		this.date = date;
		this.hotelId = hotelId;
		this.price=price;
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
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookingDay [id=" + id + ", bookingId=" + bookingId + ", rooms=" + rooms + ", date=" + date
				+ ", hotelId=" + hotelId + ", price=" + price + "]";
	}

}
