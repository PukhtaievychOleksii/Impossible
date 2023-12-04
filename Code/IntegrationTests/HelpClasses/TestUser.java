package Code.IntegrationTests.HelpClasses;

import Code.Interfaces.WatcherInterface;

public class TestUser implements WatcherInterface {
    private String state;
    private boolean isNotified;

    public TestUser(String startState){
        state = startState;
        isNotified = false;
    }

    @Override
    public void notify(String newState) {
        state = newState;
        isNotified = true;
    }

    public boolean isNotified(){
        return isNotified;
    }
}
