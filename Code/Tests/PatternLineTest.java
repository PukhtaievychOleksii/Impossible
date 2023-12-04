package Code.Tests;

import Code.Source.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PatternLineTest {
    @Test
    public void patternLineTest(){
        //create PatternLine
        UsedTyles usedTiles = new UsedTyles();
        ArrayList<Points> pointPattern = new ArrayList<Points>();
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(2));
        pointPattern.add(new Points(2));
        Floor floor = new Floor(usedTiles, pointPattern);
        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.BLACK, Tile.BLUE, Tile.GREEN, Tile.YELLOW));
        WallLine wallLine = new WallLine(tiles);
        PatternLine patternLine = new PatternLine(5, floor, wallLine, usedTiles);

        tiles = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED, Tile.RED));
        patternLine.put(tiles);

        assertEquals("Line shouldn't be full.", patternLine.isLineFull(), false);
        tiles = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED));
        patternLine.put(tiles);
        assertEquals("Line should be full.", patternLine.isLineFull(), true);

        patternLine.resetLine();

        tiles = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED, Tile.YELLOW));
        patternLine.put(tiles);
        Points points = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 0, points.getValue());
        tiles = new ArrayList<>(Arrays.asList(Tile.RED));
        patternLine.put(tiles);
        points = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 0, points.getValue());

    }
}
