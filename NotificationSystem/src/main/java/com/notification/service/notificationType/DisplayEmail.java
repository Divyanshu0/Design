package com.notification.service.notificationType;

public class DisplayEmail implements Observer {

	private String email;
	
	@Override
	public void update(String email, long phoneNo,String message,String event) {
		this.email = email;
		display();
		
	}

	private void display() {
		System.out.println("\n Email successfully send to "+email);
		
	}
	

}
