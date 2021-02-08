package Factories;

import Observer.Subject;

public class SamsungFactory implements SensorFactory{

	@Override
	public Sensor produceSensors(String type,Subject s) {
		return new Samsung(type,s);
	}

}
