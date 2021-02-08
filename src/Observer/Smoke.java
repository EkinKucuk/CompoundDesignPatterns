package Observer;

import java.util.ArrayList;

public class Smoke implements Subject {
	
	ArrayList<Observer> observers;
	
	
	public Smoke() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(observers.indexOf(o));
	}

	@Override
	public void notifyObservers() {
		for (int i = 0 ; i < observers.size() ; i ++) {
			observers.get(i).update();
		}
	}
	
	
}
