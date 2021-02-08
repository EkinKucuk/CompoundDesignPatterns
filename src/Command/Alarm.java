package Command;

import Singleton.Logger;

public class Alarm implements Receiver{

	@Override
	public void on() {
		Logger.getInstance().logToFile("Alarm is Activated");
		System.out.println("Alarm is Activated..");
	}

	@Override
	public void off() {
		Logger.getInstance().logToFile("Alarm is Deactivated");
		System.out.println("Alarm is Deactivated..");
	}

}
