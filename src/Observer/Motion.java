package Observer;

import java.util.ArrayList;

public class Motion implements Subject {
	
	ArrayList<Observer> observers;
	
	public Motion() {
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
