/**
 * 
 */
package com.beans;

/**
 * @author hoshang
 *
 */


public class Hotel {
	private int id;
	private String hotelName;
	private String location;
	private int rooms;
	private String city;
	private String state;
	private int price;
	
	public Hotel() {
		
	}
	public Hotel(int id, String hotelName, String location, int rooms, String city, String state, int price) {
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.rooms = rooms;
		this.city = city;
		this.state = state;
		this.price = price;
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
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/* 
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelName=" + hotelName + ", location=" + location + ", rooms=" + rooms
				+ ", city=" + city + ", state=" + state + ", price=" + price + "]";
	}
	
}
