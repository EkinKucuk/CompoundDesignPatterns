package simulator;

import Command.Command;
import Command.Receiver;
import Command.Sprinker;
import Command.SprinkerCommand;
import Factories.AppleFactory;
import Factories.SamsungFactory;
import Factories.Sensor;
import Factories.SensorFactory;
import Observer.Smoke;
import Observer.Subject;
import Singleton.Logger;

public class FireSimulation implements Simulation{
	Subject smoke;
	SensorFactory appleFactory;
	SensorFactory samsungFactory;
	Sensor appleSmokeSensor;
	Sensor samsungSmokeSensor;
	Receiver sprinker;
	Command sprinkerCmd;
	public FireSimulation() {
		smoke = new Smoke();
	    appleFactory = new AppleFactory();
	    //samsungFactory = new SamsungFactory();
	}
	@Override
	public void createSensors() {
		appleSmokeSensor = new AppleFactory().produceSensors("smoke", smoke);
		//samsungSmokeSensor = new SamsungFactory().produceSensors("smoke", smoke);
		
	}
	@Override
	public void createReceiver() {
		
		sprinker = new Sprinker();
	}
	@Override
	public void simulate() {
		this.createSensors();
		this.createReceiver();
		sprinkerCmd = new SprinkerCommand(sprinker);
		appleSmokeSensor.setCommand(0,sprinkerCmd);
		//samsungSmokeSensor.setCommand(0, sprinkerCmd);
		smoke.notifyObservers();
		
		Logger.getInstance().logToFile("#--------------------------------------#");
		System.out.println("#--------------------------------------#");
	}
	@Override
	public void undo() {
		sprinkerCmd.undo();
		
	}
	

	

}
