package com.notification.service.notificationType;

import org.springframework.beans.factory.annotation.Autowired;

import com.notification.dao.NotificationDao;
import com.notification.service.Notification;

public class DisplayPortal implements Observer{

	private String email;
	private String message;
	private String event;
	
	@Autowired
	NotificationDao notify;
	
	Notification notification;
	@Override
	public void update(String email, long phoneNo,String message,String event) {
		this.email = email;
		this.event=event;
		this.message=message;
		
	
		display();
		
		
	}

	

	private void display() {
		System.out.println(event+message);
		
		notification.notification(event, message);
		System.out.println("Message send successfully to "+event);
		
	}

}
