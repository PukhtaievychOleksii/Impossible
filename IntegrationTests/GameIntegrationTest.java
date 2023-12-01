package IntegrationTests;

import Code.Game;
import Code.GameObserver;
import IntegrationTests.HelpClasses.TestUser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GameIntegrationTest {

    @Test
    public void testIntegrationWithGameObserver(){
        //create Game
        final int numOfPlayers = 3;
        Game game =  new Game(numOfPlayers,new String[]{"Player1", "Player2", "Player3"});
        //create GameObserver
        GameObserver gameObserver = new GameObserver();
        ArrayList<TestUser> users = new ArrayList<>();
        for(int i = 0; i < numOfPlayers; i++){
            TestUser user = new TestUser("begin");
            users.add(user);
            gameObserver.registerObserver(user);
        }
        //test Integration
        game.setGameObserver(gameObserver);
        game.endGame();
        for(TestUser user: users){
            assertTrue("Someone wasn't notified",user.isNotified());
        }

    }

    @Test
    public void testIntegrationWithBoard(){

    }

    @Test
    public void testIntegrationWithTableArea(){

    }

    @Test
    public void testIntegrationWithBag(){

    }
}
