package com.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "SuccessController", eager = true)
@SessionScoped
public class SuccessController {

	private static String successMessage;
	public SuccessController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}
	/**
	 * @param successMessage the successMessage to set
	 */
	public static void setSuccessMessage(String message) {
		successMessage = message;
	}
}
