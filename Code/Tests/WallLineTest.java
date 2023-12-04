package Code.Tests;


import Code.Source.Points;
import Code.Source.Tile;
import Code.Source.WallLine;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallLineTest {
    @Test
    public void testCanPutTile() {
        ArrayList<Tile> tileTypesSequence = new ArrayList<>(Arrays.asList(Tile.BLUE, Tile.YELLOW, Tile.BLACK, Tile.RED,Tile.GREEN));
        WallLine wallLine = new WallLine(tileTypesSequence);
        //test RED
        assertTrue(wallLine.canPutTile(Tile.RED));
        wallLine.putTile(Tile.RED);
        assertFalse(wallLine.canPutTile(Tile.RED));
        //test GREEN
        assertTrue(wallLine.canPutTile(Tile.GREEN));
        wallLine.putTile(Tile.GREEN);
        assertFalse(wallLine.canPutTile(Tile.GREEN));    }

    @Test
    public void testPutTile() {
        ArrayList<Tile> tileTypesSequence = new ArrayList<>();
        tileTypesSequence.add(Tile.GREEN);
        tileTypesSequence.add(Tile.BLACK);
        tileTypesSequence.add(Tile.YELLOW);

        //test cross
        WallLine wallLine = new WallLine(tileTypesSequence);

        WallLine upWall = new WallLine(tileTypesSequence);
        wallLine.setUpWall(upWall);

        WallLine downWall = new WallLine(tileTypesSequence);
        wallLine.setDownWall(downWall);

        upWall.putTile(Tile.BLACK);
        downWall.putTile(Tile.BLACK);
        wallLine.putTile(Tile.GREEN);
        wallLine.putTile(Tile.YELLOW);

        Points totalPoints = wallLine.putTile(Tile.BLACK);
        assertEquals(6, totalPoints.getValue(), "Wrong points calculation");
        //test vertical line
        wallLine = new WallLine(tileTypesSequence);

        upWall = new WallLine(tileTypesSequence);
        wallLine.setUpWall(upWall);

        downWall = new WallLine(tileTypesSequence);
        wallLine.setDownWall(downWall);

        upWall.putTile(Tile.GREEN);
        downWall.putTile(Tile.GREEN);

        totalPoints = wallLine.putTile(Tile.GREEN);
        assertEquals(3, totalPoints.getValue(), "Wrong points calculation");

    }

}
