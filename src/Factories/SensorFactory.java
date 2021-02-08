package Factories;

import Observer.Subject;

public interface SensorFactory {
	public abstract Sensor produceSensors(String type,Subject s);
}
