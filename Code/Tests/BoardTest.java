package Code.Tests;

import Code.Board;
import Code.Tile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static Code.FinishRoundResult.GAME_FINISHED;
import static Code.FinishRoundResult.NORMAL;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void testBoard() {
        Board board = new Board();
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
}
