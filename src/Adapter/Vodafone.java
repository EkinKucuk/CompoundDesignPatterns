package Adapter;

import Singleton.Logger;

public class Vodafone {
	
	String msg;

	public Vodafone(String msg) {
		super();
		this.msg = msg;
	}
	
	protected String sendVodafoneSms() {
		Logger.getInstance().logToFile("Sms Notificiation with Vodafone : " + this.msg);
		System.out.println("Sms Notificiation With Vodafone : " + this.msg);
		return "Sms Notificiation with Vodafone : " + this.msg;
	}
	


}
