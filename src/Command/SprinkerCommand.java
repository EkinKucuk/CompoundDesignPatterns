package Command;

public class SprinkerCommand implements Command{
	
	Receiver sprinker;
	
	public SprinkerCommand(Receiver sprinker) {
		this.sprinker = sprinker;
	}
	
	@Override
	public void execute() {
		this.sprinker.on();
	}

	@Override
	public void undo() {
		this.sprinker.off();
	}

}
