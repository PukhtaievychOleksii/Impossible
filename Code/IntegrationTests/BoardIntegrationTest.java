package Code.IntegrationTests;

import Code.Source.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static Code.Source.FinishRoundResult.GAME_FINISHED;
import static Code.Source.FinishRoundResult.NORMAL;
import static org.junit.Assert.*;

public class BoardIntegrationTest {

    @Test
    public void testFinishRoundAndPut() {
        //create board
        UsedTyles usedTyles = new UsedTyles();
        Board board = new Board(usedTyles);
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
        //create board
        UsedTyles usedTyles = new UsedTyles();
        Board board = new Board(usedTyles);

        assertTrue("It is possible to put tiles on patternline with index 0.", board.destinationExists(0));
        assertFalse("There is no patternline with index 5", board.destinationExists(5));
    }

    @Test
    public void testBoardIntegrationWithFPC() {
        //create board
        UsedTyles usedTyles = new UsedTyles();
        Board board = new Board(usedTyles);
        //test integration through endGame()
        ArrayList<Tile> presentTiles;
        Tile workingTile = Tile.GREEN;

        presentTiles = new ArrayList<>();
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        board.put(1, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>();
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        board.put(2, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>();
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        board.put(3, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>();
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        board.put(4, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>(Arrays.asList(Tile.RED));
        board.put(0, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>(Arrays.asList(Tile.BLACK));
        board.put(0, presentTiles);
        board.finishRound();

        presentTiles = new ArrayList<>(Arrays.asList(Tile.GREEN));
        board.put(0, presentTiles);
        board.finishRound();


        board.endGame();
        assertEquals("", 20, board.points.getValue());

    }

    @Test
    public void testBoardIntegrationWithPatterLine(){
        //create board
        UsedTyles usedTyles = new UsedTyles();
        Board board = new Board(usedTyles);
        int workingIndex = 2;
        ArrayList<Tile> presentTiles = new ArrayList<>();
        presentTiles.add(Tile.GREEN);
        presentTiles.add(Tile.GREEN);

        board.put(workingIndex, presentTiles);

        ArrayList<PatternLine> patternLines = board.getPatterLines();
        int count = patternLines.get(workingIndex).getPresentTyles().size();
        String color = patternLines.get(workingIndex).getPresentTyles().get(0).toString();

        assertEquals("Present tiles must be " + workingIndex, count, 2);
        assertEquals("The tiles type must be green", "G", color);
    }

    @Test
    public void testBoardIntegrationWithWallLine(){
        //create Board
        UsedTyles usedTyles = new UsedTyles();
        Board board = new Board(usedTyles);

        int workingIndex = 4;
        Tile workingTile = Tile.GREEN;
        //check integration
        ArrayList<Tile> presentTiles = new ArrayList<>();
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        presentTiles.add(workingTile);
        board.put(workingIndex, presentTiles);
        board.finishRound();

        //create WallLines
        ArrayList<WallLine> wallLines = board.getWallLines();
        WallLine wallLine = wallLines.get(workingIndex);
        boolean isTilePresent = false;
        Tile presentTile = Tile.STARTING_PLAYER;
        for(Optional<Tile> tile: wallLine.getTiles()){
            if(tile.isPresent()){
                isTilePresent = true;
                presentTile = tile.get();
                break;
            }
        }

        assertTrue("Tile was not moved to Wall",isTilePresent);
        assertEquals("The wrong tile was moved to Wall",presentTile, workingTile);
    }
}
