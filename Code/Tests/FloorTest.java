package Code.Tests;

import Code.Source.Floor;
import Code.Source.Points;
import Code.Source.Tile;
import Code.Source.UsedTyles;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FloorTest {
    private UsedTyles usedTiles;
    private Floor floor;


    @Test
    public void test_tiles() {
        //create floor
        usedTiles = new UsedTyles();
        ArrayList<Points> pointPattern = new ArrayList<Points>();
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(2));
        pointPattern.add(new Points(2));
        pointPattern.add(new Points(3));
        floor = new Floor(usedTiles, pointPattern);
        //test floor
        assertEquals("Floor should be empty when created.", "", floor.state());

        ArrayList<Tile> tiles = new ArrayList<Tile>();
        tiles.add(Tile.RED);
        tiles.add(Tile.YELLOW);
        tiles.add(Tile.RED);
        floor.put(tiles);
        assertEquals( "RIR", floor.state());
        Points points = floor.finishRound();
        assertEquals("", floor.state());
        assertEquals("Wrong points calculation", 5, points.getValue());
        assertArrayEquals("Used tiles should contain tiles from the floor", tiles.toArray(), usedTiles.takeAll().toArray());

        floor.put(Arrays.asList(Tile.RED));
        floor.put(Arrays.asList(Tile.BLACK));
        //floor.put(new ArrayList<Tile>());
        assertEquals( "RL", floor.state());
        points = floor.finishRound();
        assertEquals("Floor should be empty after the round is finished.", "", floor.state());
        assertEquals(
                "Wrong points calculation", 3, points.getValue());
        tiles.add(Tile.RED);
        tiles.add(Tile.BLACK);
        assertArrayEquals(tiles.toArray(), usedTiles.takeAll().toArray());
    }


}