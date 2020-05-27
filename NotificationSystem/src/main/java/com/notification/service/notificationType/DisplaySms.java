package com.notification.service.notificationType;

public class DisplaySms implements Observer{

	private long phoneNo;
	
	@Override
	public void update(String email, long phoneNo,String message,String event) {
		
		this.phoneNo = phoneNo;
		display();
	}

	private void display() {
		System.out.println("Sms send successfully to "+phoneNo);
		
	}




}
