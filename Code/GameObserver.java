package Code;

import Code.Interfaces.ObserverInterface;

public class GameObserver implements ObserverInterface {

    public void notifyEverybody(String state) {
        System.out.println(state);
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
    }

    @Override
    public void canselObserver(ObserverInterface observer) {

    }
}
