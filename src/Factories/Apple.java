package Factories;

import Adapter.SMS;
import Adapter.Turkcell;
import Command.Command;
import Observer.Motion;
import Observer.Smoke;
import Observer.Subject;
import Singleton.Logger;

public class Apple extends Sensor {
	

	private Command[] commands;
	private Subject subject;
	private SMS sms;
	private String type;
	private int size;
	
	public Apple(String type,Subject s) {
		super(type);
		commands = new Command[2];
		sms = new Turkcell(type);
		this.subject = s;
		this.size = 0;
		this.type = type;
		subject.registerObserver(this);
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " Sensor";
	}


	@Override
	public void update() {
		System.out.println(type + " is detected");
		Logger.getInstance().logToFile(type + " is detected");
		this.executeCommands();
		sms.sendSms();
	}


	@Override
	public void setCommand(int slot, Command command) {
		if(slot <= commands.length) {
			commands[slot] = command;
			size++;
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
public void executeCommands() {
		
		for (int i=0;i<size;i++) {
			
			commands[i].execute();
			
		}  
	}
	

}
