package de.htwg.se.util.observer;

/**
 * Created by Tamara on 13.11.2015.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Observable  {

    protected List<IObserver> subscribers = new LinkedList<>();

    public void addObserver(IObserver s) {
        subscribers.add(s);
    }

    public void removeObserver(IObserver s) {
        subscribers.remove(s);
    }

    public void removeAllObservers() {
        subscribers.clear();
    }

    public void notifyObservers() {
        for ( Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
            IObserver observer = iter.next();
            observer.update();
        }
    }
}

