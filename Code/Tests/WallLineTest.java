package Code.Tests;


import Code.Points;
import Code.Tile;
import Code.WallLine;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallLineTest {
    @Test
    public void testCanPutTile() {
        ArrayList<Tile> tileTypesSequence = new ArrayList<>(Arrays.asList(Tile.RED,Tile.GREEN, Tile.BLUE, Tile.YELLOW, Tile.BLACK));
        WallLine wallLine = new WallLine(tileTypesSequence);

        assertTrue(wallLine.canPutTile(Tile.RED));
        wallLine.putTile(Tile.RED);
        assertFalse(wallLine.canPutTile(Tile.RED));
        assertTrue(wallLine.canPutTile(Tile.YELLOW));
    }

    @Test
    public void testPutTile() {
        ArrayList<Tile> tileTypesSequence = new ArrayList<>();
        tileTypesSequence.add(Tile.RED);
        tileTypesSequence.add(Tile.GREEN);
        tileTypesSequence.add(Tile.BLUE);
        WallLine wallLine = new WallLine(tileTypesSequence);

        WallLine upWall = new WallLine(tileTypesSequence);
        wallLine.setUpWall(upWall);

        WallLine downWall = new WallLine(tileTypesSequence);
        wallLine.setDownWall(downWall);

        upWall.putTile(Tile.GREEN);
        downWall.putTile(Tile.BLUE);
        wallLine.putTile(Tile.GREEN);

        Points totalPoints = wallLine.putTile(Tile.BLUE);
        assertEquals(4, totalPoints.getValue(), "Incorrect total points after placing additional tiles");

    }

}
