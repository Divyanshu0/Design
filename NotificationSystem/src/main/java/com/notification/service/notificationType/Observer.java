package com.notification.service.notificationType;

public interface Observer {

	void update(String email, long phoneNo,String message,String event);

}
