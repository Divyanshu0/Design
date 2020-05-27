package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notification.dao.EmployeeDao;
import com.notification.dao.NotificationDao;
import com.notification.dto.EmployeePojo;
import com.notification.dto.NotificationPojo;


@Service
public class Notification implements INotification{

	@Autowired
	NotificationDao empObj;
	
	NotificationPojo notiy;

	@Override
	public void notification(String eventType, String message) {
		notiy.setMessage(message);
		notiy.setEventType(eventType);
		System.out.println(notiy);
		empObj.save(notiy);
		
	} 
	
	

	
	
}
