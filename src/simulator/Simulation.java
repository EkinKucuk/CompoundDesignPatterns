package simulator;

public interface Simulation {
	public void createSensors();
	public void createReceiver();
	public void simulate();
	public void undo();

}
