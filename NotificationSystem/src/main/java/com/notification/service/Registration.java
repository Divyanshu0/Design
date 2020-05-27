package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notification.dao.EmployeeDao;
import com.notification.dto.EmployeePojo;


@Service
public class Registration implements IRegistration{

	@Autowired
	EmployeeDao empObj; 
	
	
	@Override
	public void registration(EmployeePojo emp) {	
		empObj.save(emp);	
	}
	
	
	@Override
	public EmployeePojo getUserByUsername(String email) {
		return empObj.findByemail(email);
	}
	
	

	
	
}
