package com.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification.dto.EmployeePojo;
import com.notification.dto.NotificationPojo;

public interface NotificationDao extends JpaRepository<NotificationPojo, Integer> {

}
