package Factories;

import Adapter.SMS;
import Adapter.Vodafone;
import Adapter.VodafoneAdapter;
import Command.Command;
import Observer.Motion;
import Observer.Smoke;
import Observer.Subject;
import Singleton.Logger;

public class Samsung extends Sensor {

	private Command[] commands;
	private Subject subject;
	private SMS sms;
	private String type;
	private int size;

	public Samsung(String type,Subject s) {
		super(type);
		this.type = type;
		this.commands = new Command[2];
		sms = new VodafoneAdapter(new Vodafone(type));
		this.subject = s;
		subject.registerObserver(this);
		this.size=0;
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
		if (slot <= commands.length) {
			commands[slot] = command;
			size++;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void executeCommands() {
		
		for (int i=0;i<size;i++) {
			
			commands[i].execute();
			
		}  
	}

}
