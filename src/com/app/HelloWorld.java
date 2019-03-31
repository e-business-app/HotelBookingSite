package com.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {
   private Check messageBean;
   private String message;
   
   public HelloWorld() {
      System.out.println("HelloWorld started!");   
   }
   
   public String getMessage() {
      
      if(messageBean != null) {
         message = messageBean.getMessage();
      }       
      return message;
   }
   
   public void setMessageBean(Check message) {
      this.messageBean = message;
   }
}