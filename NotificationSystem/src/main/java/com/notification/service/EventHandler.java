package com.notification.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notification.dao.EmployeeDao;
import com.notification.dto.EmployeePojo;
import com.notification.service.notificationType.DisplayEmail;
import com.notification.service.notificationType.DisplayPortal;
import com.notification.service.notificationType.DisplaySms;
import com.notification.service.notificationType.UpdateNotification;


@Service
public class EventHandler implements IEventHandler {

	@Autowired
	EmployeeDao empObj;
	
	
	List<EmployeePojo> data;
	public void dataUpdate(List<EmployeePojo> data ) {
		this.data = empObj.findAll();
	}
	
	@Override
	public boolean notification(String event,String message) {
		
		dataUpdate(data);
		UpdateNotification updateMessage = new UpdateNotification();
		DisplayPortal portal = new DisplayPortal();
		DisplaySms sms = new DisplaySms();
		DisplayEmail email = new DisplayEmail();
				
		switch (event) {
		case "event":
			for (EmployeePojo employeePojo : data) {
			updateMessage.registerObserver(portal);
			updateMessage.registerObserver(email);
			updateMessage.dataChanged(employeePojo.getEmail(),employeePojo.getPhoneNo(),message,event);
			updateMessage.unregisterObserver(portal);
			updateMessage.unregisterObserver(email);
			}return true;
			
		case "urgentHelp":
			for (EmployeePojo employeePojo : data) {
			updateMessage.registerObserver(email);
			updateMessage.registerObserver(sms);
			updateMessage.dataChanged(employeePojo.getEmail(),employeePojo.getPhoneNo(),message,event);
			updateMessage.unregisterObserver(sms);
			updateMessage.unregisterObserver(email);
			}return true;
		
		case "holiday":
			for (EmployeePojo employeePojo : data) {
			updateMessage.registerObserver(portal);
			updateMessage.dataChanged(employeePojo.getEmail(),employeePojo.getPhoneNo(),message,event);
			updateMessage.unregisterObserver(portal);
			}return true;
			
		case "news":
			for (EmployeePojo employeePojo : data) {
			updateMessage.registerObserver(email);
			updateMessage.registerObserver(portal);
			updateMessage.dataChanged(employeePojo.getEmail(),employeePojo.getPhoneNo(),message,event);
			updateMessage.unregisterObserver(email);
			updateMessage.unregisterObserver(portal);
			}return true;
		
		case "policy":
			for (EmployeePojo employeePojo : data) {
			updateMessage.registerObserver(email);
			updateMessage.registerObserver(portal);
			updateMessage.dataChanged(employeePojo.getEmail(),employeePojo.getPhoneNo(),message,event);
			updateMessage.unregisterObserver(portal);
			updateMessage.unregisterObserver(email);
			}return true;
		default:
			return false;
		}


	}
}
