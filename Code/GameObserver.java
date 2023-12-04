package Code;

import Code.Interfaces.ObserverInterface;

import java.util.ArrayList;

public class GameObserver implements ObserverInterface {

    private ArrayList<ObserverInterface> observers;
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
