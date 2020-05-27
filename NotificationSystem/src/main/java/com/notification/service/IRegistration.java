package com.notification.service;



import com.notification.dto.EmployeePojo;


public interface IRegistration {
	
	void registration(EmployeePojo emp);
	

	EmployeePojo getUserByUsername(String email);
	


}
