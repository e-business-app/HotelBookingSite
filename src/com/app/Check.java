package com.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Check {
   private String message = "Hello World!";
	
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
}