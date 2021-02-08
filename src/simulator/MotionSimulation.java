package simulator;

import Command.*;
import Factories.AppleFactory;
import Factories.SamsungFactory;
import Factories.Sensor;
import Factories.SensorFactory;
import Observer.Motion;
import Singleton.Logger;
import Observer.*;

public class MotionSimulation implements Simulation {
	Subject motion;
	SensorFactory appleFactory;
	SensorFactory SamsungFactory;
	Sensor appleMotionSensor;
	Sensor SamsungMotionSensor;
	Receiver alarm;
	Command alarmCmd;

	public MotionSimulation() {
		motion = new Motion();
		//appleFactory = new AppleFactory();
		SamsungFactory = new SamsungFactory();
	}

	@Override
	public void createSensors() {
		//appleMotionSensor = appleFactory.produceSensors("motion", motion);
		SamsungMotionSensor = SamsungFactory.produceSensors("motion", motion);
		
	}

	@Override
	public void createReceiver() {
		alarm = new Alarm();
		
	}
	
	@Override
	public void simulate() {
		this.createSensors();
		this.createReceiver();
		alarmCmd =  new AlarmCommand(alarm);
		//appleMotionSensor.setCommand(0, alarmCmd);
		SamsungMotionSensor.setCommand(0, alarmCmd);
         motion.notifyObservers();
        Logger.getInstance().logToFile("#--------------------------------------#");
     	System.out.println("#--------------------------------------#");
		
	}

	@Override
	public void undo() {
		alarmCmd.undo();
	}


}
