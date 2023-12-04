package Code.Source;

import Code.Interfaces.ObserverInterface;

import java.util.ArrayList;

public class GameObserver implements ObserverInterface {
<<<<<<< HEAD:Code/Source/GameObserver.java
    private ArrayList<WatcherInterface> watchers;

=======

    private ArrayList<ObserverInterface> observers;
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/GameObserver.java
    public GameObserver() {
        this.observers = new ArrayList<>();
    }

    public void notifyEverybody(String state) {
        for (ObserverInterface observer : observers) {
             System.out.println(state);
        }
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void canselObserver(ObserverInterface observer) {
        observers.remove(observer);
    }
}
