package Command;

import Adapter.SMS;
import Adapter.Turkcell;

public class AlarmCommand implements Command {
	
	Receiver alarm;
	
	public AlarmCommand(Receiver alarm) {
		this.alarm = alarm;
	}

	@Override
	public void execute() {
		this.alarm.on();
		
	}

	@Override
	public void undo() {
		this.alarm.off();
	}

}
