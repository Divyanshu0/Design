package com.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification.dto.EmployeePojo;

public interface EmployeeDao extends JpaRepository<EmployeePojo, Integer>{
	
	EmployeePojo findByemail(String email);

}
