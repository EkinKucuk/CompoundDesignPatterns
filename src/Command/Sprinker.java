package Command;

import Singleton.Logger;

public class Sprinker implements Receiver{

	@Override
	public void on() {
		Logger.getInstance().logToFile("Sprinker is Activated");
		System.out.println("Sprinker is Activated..");
	}

	@Override
	public void off() {
		Logger.getInstance().logToFile("Sprinker is Deactivated");
		System.out.println("Sprinker is Deactivated..");
	}
}
