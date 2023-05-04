package GestioneIncendi.Sonda;

import java.util.*;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	public void notifyObservers() {
		this.getObservers().forEach(elem -> elem.update(this));
	}

	public List<Observer> getObservers() {
		return observers;
	}
	
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}
}
