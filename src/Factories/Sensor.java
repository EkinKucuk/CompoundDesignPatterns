package Factories;

import Command.Command;
import Observer.Observer;
import Observer.Subject;

public abstract class Sensor implements Observer {
	
	
	private String type;
	
	public abstract void setCommand(int slot,Command command);
	
	public Sensor(String type) {
		this.type= type;
	}

	@Override
	public String toString() {
		return type;
	}
	
}
