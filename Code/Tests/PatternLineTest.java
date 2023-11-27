package Code.Tests;

import Code.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PatternLineTest {
    @Test
    public void patternLineTest(){
        ArrayList<Tile> usedTiles = new ArrayList<>();
        ArrayList<Points> pointPattern = new ArrayList<Points>();
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(2));
        pointPattern.add(new Points(2));
        Floor floor = new Floor(usedTiles, pointPattern);
        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.BLACK, Tile.BLUE, Tile.GREEN, Tile.YELLOW));
        WallLine wallLine = new WallLine(tiles);
        PatternLine patternLine = new PatternLine(5, floor, wallLine);
        ArrayList<Tile> tiles1 = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED, Tile.RED));
        patternLine.put(tiles1);

        assertEquals("Line is not full.", patternLine.isLineFull(), false);
        ArrayList<Tile> tiles2 = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED));
        patternLine.put(tiles2);
        assertEquals("Line should be full.", patternLine.isLineFull(), true);
        patternLine.resetLine();
        ArrayList<Tile> tiles3 = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED, Tile.RED,Tile.RED,Tile.YELLOW));
        patternLine.put(tiles3);
        assertEquals("Line shouldn`t be full, another color.", patternLine.isLineFull(), false);

        patternLine.resetLine();
        ArrayList<Tile> tiles4 = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED));
        patternLine.put(tiles4);
        Points points1 = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 0, points1.getValue());
        ArrayList<Tile> tiles5 = new ArrayList<>(Arrays.asList(Tile.RED,Tile.RED, Tile.YELLOW));
        patternLine.put(tiles5);
        Points points2 = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 0, points2.getValue());
        ArrayList<Tile> tiles6 = new ArrayList<>(Arrays.asList(Tile.RED));
        patternLine.put(tiles6);
        Points points3 = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 0, points3.getValue());
        ArrayList<Tile> tiles7 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED));
        patternLine.put(tiles7);
        Points points4 = patternLine.finishRound();
        assertEquals("Player shouldn`t get any points", 1, points4.getValue());

    }
}
