package com.notification.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.notification.service.IRegistration;
import com.notification.dto.EmployeePojo;
import com.notification.dto.NotificationPojo;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	IRegistration subscribe; 
	
	

	@RequestMapping(method = RequestMethod.POST,value = "/registration")
	public Boolean registration(@RequestBody EmployeePojo emp) {
		subscribe.registration(emp);
		return true;	
	}
		
	@RequestMapping(method = RequestMethod.GET, value ="/login/{email}")
	public EmployeePojo getUserByUsername(@PathVariable String email) {
		
		return subscribe.getUserByUsername(email);
	}
	
	
	public List<NotificationPojo> getmessage(){
		return null;	
	}
	
}
