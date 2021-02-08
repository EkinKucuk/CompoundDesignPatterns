package Adapter;

public class VodafoneAdapter implements SMS {

	Vodafone sms;
	
	public VodafoneAdapter(Vodafone sms) {
		this.sms = sms;
	}

	@Override
	public String sendSms() {
		return sms.sendVodafoneSms();
	}

	


}
