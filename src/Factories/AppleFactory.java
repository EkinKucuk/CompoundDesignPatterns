package Factories;

import Observer.Subject;

public class AppleFactory implements SensorFactory {

	@Override
	public Sensor produceSensors(String type,Subject s) {
		return new Apple(type,s);
	}

}
