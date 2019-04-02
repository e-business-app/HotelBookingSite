package com.dao;

import java.util.ArrayList;

import java.util.List;
import com.beans.Hotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public List<Hotel> checkAvailability(int rooms,String startDate,String endDate){
		Hotel hotel=null;
		List <Hotel> hotels= new ArrayList<Hotel>();
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "SELECT H.* FROM Hotel.hotels H WHERE H.id NOT IN (SELECT TotalRooms.id AS hotelId FROM (SELECT HBD.hotelId,HBD.date,SUM(HBD.rooms) AS rooms FROM Hotel.BookingDays HBD WHERE HBD.date>='"+startDate+"' AND HBD.date<'"+endDate+"' GROUP BY HBD.hotelId, HBD.date) BookedRooms JOIN Hotel.Hotels TotalRooms ON TotalRooms.id = BookedRooms.hotelId WHERE (TotalRooms.rooms-BookedRooms.rooms)<"+rooms+")";
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

}
