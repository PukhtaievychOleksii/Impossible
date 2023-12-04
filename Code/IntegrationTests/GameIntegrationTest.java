package Code.IntegrationTests;

import Code.IntegrationTests.HelpClasses.TestUser;
import Code.Source.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
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
        //create Game
        Game game = new Game();
        //create Board
        ArrayList<Board> boards = game.getBoards();
        //test Integration
        boolean isTakeCorrect = true;
        //correct take
        for(int i = 0; i < boards.size(); i++){
            int correct_destination = 4;
            isTakeCorrect = game.take(i,i + 1,0, correct_destination);
            assertTrue("Take should be but was not accomplished", isTakeCorrect);
            Board board = boards.get(i);
            assertFalse("Tiles were not put on the Board with right input",board.areLinesEmpty());
        }

        game = new Game();
        boards = game.getBoards();
        //incorrect take
        for(int i = 0; i < boards.size(); i++){
            final int incorrect_destination = 1000;
            isTakeCorrect = game.take(i,i,0, incorrect_destination);
            assertTrue("Take should be but was not accomplished",isTakeCorrect);
            Board board = boards.get(i);
            assertTrue("Incorrect take added to Lines",board.areLinesEmpty());
            Floor floor = board.getFloor();
            assertFalse("Floor was empty after incorrect take", floor.isEmpty());
        }
    }

    @Test
    public void testIntegrationWithTableArea(){
        //create Game
        Game game = new Game();
        //create TableArea
        TableArea tableArea = game.getTableArea();
        //test integration
        final int sourceId = 1;
        boolean isTakeCorrect;
        //correct input
        TyleSource tyleSource = tableArea.getTyleSource(sourceId);
        int initialSize = tyleSource.getSourceTiles().size();
        isTakeCorrect = game.take(0, sourceId, 0, 0);
        assertTrue("Incorrect take with correct input", isTakeCorrect);
        int currentSize = tyleSource.getSourceTiles().size();
        assertTrue("Tiles were not taken from the source", initialSize > currentSize);
        //incorrect input
        final int incorrectSourceId = 1000;
        isTakeCorrect = game.take(0, incorrectSourceId, 0, 0);
        assertFalse("Tiles were taken with incorrect input",isTakeCorrect);
    }

    @Test
    public void testIntegrationWithBag(){
        //create Game
        Game game = new Game();
        //create Bag
        Bag bag = game.getBag();

        int initialSize = bag.sizeOfBag();
        game.startNewRound();
        int currentSize = bag.sizeOfBag();
        assertTrue("Tiles were not taken from Bag on Restart", initialSize > currentSize);
    }
}
