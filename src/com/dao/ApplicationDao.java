package com.dao;

import java.util.ArrayList;
import com.beans.Booking;

import java.util.List;
import com.beans.Hotel;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
* <h1>Application Dao</h1>
* This class implements all the methods to access the PlayerInfo Table in the 
* Player Database
*
* @author  https://github.com/e-business-app
* @version 1.0
* @since   2019-01-31
*/

public class ApplicationDao {
	/**
	 * 
	 * Pass a String and search for players in the database which match the 
	 * fullname.
	 * 
	 * It will return all the players in the form of a list.
	 * 
	 * @param searchPlayer
	 * @return the list of Player Objects Found.
	 * 
	 */
	public List<Hotel> allHotels() {
		Hotel hotel=null;
		List <Hotel> hotels= new ArrayList<Hotel>();
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select * from Hotels";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				hotel=new Hotel();
				hotel.setId(set.getInt("id"));
				hotel.setCity(set.getString("city"));
				hotel.setHotelName(set.getString("hotelName"));
				hotel.setLocation(set.getString("location"));
				hotel.setPrice(set.getInt("price"));
				hotel.setRooms(set.getInt("rooms"));
				hotel.setState(set.getString("state"));
				hotel.setImage(set.getString("image"));
				hotels.add(hotel);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return hotels;
	}
	
	/**
	 * 
	 * Pass a String and search for specific Hotel in the database which matches the id
	 * 
	 * It will return the specific Hotel from the list.
	 * 
	 * @param id
	 * @return the list of Player Objects Found.
	 * 
	 */
	public List<Hotel> viewHotel(int id) {
		Hotel hotel=null;
		List <Hotel> hotels= new ArrayList<Hotel>();
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select * from Hotels where id="+id;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				hotel=new Hotel();
				hotel.setId(set.getInt("id"));
				hotel.setCity(set.getString("city"));
				hotel.setHotelName(set.getString("hotelName"));
				hotel.setLocation(set.getString("location"));
				hotel.setPrice(set.getInt("price"));
				hotel.setRooms(set.getInt("rooms"));
				hotel.setState(set.getString("state"));
				hotel.setImage(set.getString("image"));
				hotels.add(hotel);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return hotels;
	}
	/**
	 * 
	 * Check if hotels are available
	 * 
	 * @param rooms
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Hotel> checkAvailability(int rooms,String startDate,String endDate){
		Hotel hotel=null;
		List <Hotel> hotels= new ArrayList<Hotel>();
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "SELECT H.* FROM Hotel.hotels H WHERE H.id NOT IN ((SELECT TotalRooms.id AS hotelId FROM (SELECT HBD.hotelId,HBD.date,SUM(HBD.rooms) AS rooms FROM Hotel.BookingDays HBD WHERE HBD.date>='"+startDate+"' AND HBD.date<'"+endDate+"' GROUP BY HBD.hotelId, HBD.date) BookedRooms JOIN Hotel.Hotels TotalRooms ON TotalRooms.id = BookedRooms.hotelId WHERE (TotalRooms.rooms-BookedRooms.rooms)<"+rooms+") UNION (SELECT Hotels.id AS hotelId FROM Hotel.Hotels Hotels WHERE Hotels.rooms<"+rooms+"))";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				hotel=new Hotel();
				hotel.setId(set.getInt("id"));
				hotel.setCity(set.getString("city"));
				hotel.setHotelName(set.getString("hotelName"));
				hotel.setLocation(set.getString("location"));
				hotel.setPrice(set.getInt("price"));
				hotel.setRooms(set.getInt("rooms"));
				hotel.setState(set.getString("state"));
				hotel.setImage(set.getString("image"));
				hotels.add(hotel);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return hotels;
		
	}
	
	public int addBooking(Booking booking) {
		String query = "INSERT INTO Bookings (customerName,email,number) VALUES ('"+booking.getCustomerName()+"','"+booking.getEmail()+"',"+booking.getNumber()+")";
		Connection connection = DBConnection.getConnectionToDatabase();
		int id=0;
		try {
			PreparedStatement statement = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS);
			int result = statement.executeUpdate();
			if (result == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id=(int) generatedKeys.getLong(1);
	                System.out.println(id);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return id;
	}

	public int addBookingDay(String date, int hotelId, float price, int rooms, int bookingId) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO BookingDays (bookingId,rooms,date,hotelId,price) VALUES ('"+bookingId+"','"+rooms+"','"+date+"','"+hotelId+"','"+price+"')";
		Connection connection = DBConnection.getConnectionToDatabase();
		int id=0;
		try {
			PreparedStatement statement = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS);
			int result = statement.executeUpdate();
			if (result == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id=(int) generatedKeys.getLong(1);
	                System.out.println(id);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	

}
