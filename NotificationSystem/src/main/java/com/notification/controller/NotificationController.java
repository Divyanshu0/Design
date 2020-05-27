package com.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notification.service.IEventHandler;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class NotificationController {

	@Autowired
	IEventHandler event;
	
	@RequestMapping(method = RequestMethod.GET,value = "/notify/{eventType}/{message}")
	public boolean notification(@PathVariable String eventType,@PathVariable String message) {
		
		return event.notification(eventType,message);
	}
}
