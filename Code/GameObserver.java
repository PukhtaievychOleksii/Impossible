package Code;

import Code.Interfaces.ObserverInterface;
import Code.Interfaces.WatcherInterface;

import java.util.ArrayList;

public class GameObserver implements ObserverInterface {
    private ArrayList<WatcherInterface> watchers;

    public GameObserver() {
        this.watchers = new ArrayList<>();
    }

    public void notifyEverybody(String state) {
        for (WatcherInterface watcher : watchers) {
            watcher.notify(state);
            System.out.println(state);
        }
    }

    @Override
    public void registerObserver(WatcherInterface watcher) {
        watchers.add(watcher);
    }

    @Override
    public void canselObserver(WatcherInterface watcher) {
        watchers.remove(watcher);
    }

}
