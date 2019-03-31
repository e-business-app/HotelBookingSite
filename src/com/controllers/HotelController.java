package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.dao.ApplicationDao;
import com.beans.Hotel;

@ManagedBean(name = "HotelController", eager = true)
@SessionScoped
public class HotelController {
	private List<Hotel> hotels;
	public ApplicationDao dao;
	public HotelController() {
		System.out.println("Hotel Start");   
	}
	
	public List<Hotel> getHotels() {
		ApplicationDao dao=new ApplicationDao();
		return dao.allHotels();	
	}
	/*
	public HotelController() {
		hotels = new ArrayList<>();
	}
	public List<Hotel> getHotels() {
		return hotels;
	}
	
	public String Colossus() {
		return "HEYYEYEYYEYE";
	}
	public List<Hotel> viewHotels() {
		logger.info("Loading students");
		
		hotels.clear();

		try {
			
			// get all students from database
			hotels = dao.allHotels();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading students", exc);
			
		}
		return hotels;
	}
	
	*/
}
