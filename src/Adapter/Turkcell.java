package Adapter;

import Singleton.Logger;

public class Turkcell implements SMS {
	
	protected String msg;
	

	public Turkcell(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String sendSms() {
		Logger.getInstance().logToFile("Sms Notificiation With Turkcell : " + this.msg);
		System.out.println("Sms Notificiation With Turkcell : " + this.msg);
		return "Sms Notificiation With Turkcell : " + this.msg;
		
	}

}
