package Code.Tests;

import Code.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static Code.FinishRoundResult.GAME_FINISHED;
import static Code.FinishRoundResult.NORMAL;
import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private UsedTyles usedTyles;

    @Before
    public void setUp(){
        usedTyles = new UsedTyles();
        board = new Board(usedTyles);
    }
    @Test
    public void testFinishRoundAndPut() {
        ArrayList<Tile> list =  new ArrayList<>(Arrays.asList(Tile.RED));
        board.put(0, list);
        assertEquals("Game shouldn`t be finished", NORMAL, board.finishRound());
        ArrayList<Tile> list1 =  new ArrayList<>(Arrays.asList(Tile.BLUE));
        board.put(0, list1);
        board.finishRound();
        ArrayList<Tile> list2 =  new ArrayList<>(Arrays.asList(Tile.GREEN));
        board.put(0, list2);
        board.finishRound();
        ArrayList<Tile> list3 =  new ArrayList<>(Arrays.asList(Tile.BLACK));
        board.put(0, list3);
        board.finishRound();
        ArrayList<Tile> list4 =  new ArrayList<>(Arrays.asList(Tile.YELLOW));
        board.put(0, list4);
        board.finishRound();
        assertEquals("Game should be finished", GAME_FINISHED, board.finishRound());


    }

    @Test
    public void testDestinationExists(){
        assertTrue("It is possible to put tiles on patternline with index 0.", board.destinationExists(0));
        assertFalse("There is no patternline with index 5", board.destinationExists(5));
    }

    @Test
    public void testEndGame() {

        // если 0 wallLine полностью собранна (+2б из FinalPointsCalculation)
//        ArrayList<Tile> tiles = new ArrayList<>();
//        tiles = new ArrayList<>(Arrays.asList(Tile.BLUE));
//        board.put(0, tiles);
//        board.finishRound();
//
//        tiles = new ArrayList<>(Arrays.asList(Tile.YELLOW));
//        board.put(0, tiles);
//        board.finishRound();
//
//        tiles = new ArrayList<>(Arrays.asList(Tile.RED));
//        board.put(0, tiles);
//        board.finishRound();
//
//        tiles = new ArrayList<>(Arrays.asList(Tile.BLACK));
//        board.put(0, tiles);
//        board.finishRound();
//
//        tiles = new ArrayList<>(Arrays.asList(Tile.GREEN));
//        board.put(0, tiles);
//        board.finishRound();
//
//        board.endGame();
//        assertEquals("", 17, board.points.getValue());

        // если собранны все камни синего цвета (+10б из FinalPointsCalculation)
        ArrayList<Tile> blueTiles;

        blueTiles = new ArrayList<>();
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        board.put(1, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>();
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        board.put(2, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>();
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        board.put(3, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>();
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        blueTiles.add(Tile.BLUE);
        board.put(4, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>(Arrays.asList(Tile.BLUE));
        board.put(0, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>(Arrays.asList(Tile.YELLOW));
        board.put(0, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>(Arrays.asList(Tile.RED));
        board.put(0, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>(Arrays.asList(Tile.BLACK));
        board.put(0, blueTiles);
        board.finishRound();

        blueTiles = new ArrayList<>(Arrays.asList(Tile.GREEN));
        board.put(0, blueTiles);
        board.finishRound();


        board.endGame();
        assertEquals("", 33, board.points.getValue());

    }
    @Test
    public void testBoardIntegrationWithPatterLine(){


    }
}
