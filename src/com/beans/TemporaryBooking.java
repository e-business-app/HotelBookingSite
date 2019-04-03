package com.beans;

public class TemporaryBooking {
	private int hotelId;
	private String startDate;
	private String endDate;
	private int rooms;
	private float price;
	private String hotelName;
	private String image;

	public TemporaryBooking() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param hotelId
	 * @param startDate
	 * @param endDate
	 * @param rooms
	 * @param price 
	 * @param image 
	 * @param hotelName 
	 */
	public TemporaryBooking(int hotelId,String hotelName,String image, String startDate, String endDate, int rooms, float price) {
		this.hotelId = hotelId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rooms = rooms;
		this.price=price;
		this.image=image;
		this.hotelName=hotelName;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TemporaryBooking [hotelId=" + hotelId + ", startDate=" + startDate + ", endDate=" + endDate + ", rooms="
				+ rooms + "]";
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	

}
