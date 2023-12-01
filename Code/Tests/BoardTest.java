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
        Points initialPoints = new Points(board.points.getValue());
        /*board.endGame();
        assertEquals("", 0, board.points.getValue());
        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED));
        board.put(0, tiles);
        assertEquals("", 0, board.points.getValue());
        board.finishRound();
        board.endGame();
        assertEquals("", 1, board.points.getValue());
        System.out.println(board.points.getValue());*/

        // не фунгуе почет бодов
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles = new ArrayList<>(Arrays.asList(Tile.BLUE));
        board.put(0, tiles);
        board.finishRound();
        System.out.println(board.points.getValue());
        tiles = new ArrayList<>(Arrays.asList(Tile.YELLOW));
        board.put(0, tiles);
        board.finishRound();
        System.out.println(board.points.getValue());
        tiles = new ArrayList<>(Arrays.asList(Tile.RED));
        board.put(0, tiles);
        board.finishRound();
        System.out.println(board.points.getValue());
        tiles = new ArrayList<>(Arrays.asList(Tile.BLACK));
        board.put(0, tiles);
        board.finishRound();
        System.out.println(board.points.getValue());
        tiles = new ArrayList<>(Arrays.asList(Tile.GREEN));
        board.put(0, tiles);
        board.finishRound();
        board.endGame();
        System.out.println(board.points.getValue());
        assertEquals("", 17, board.points.getValue());



    }
    @Test
    public void testBoardIntegrationWithPatterLine(){

    }
}
