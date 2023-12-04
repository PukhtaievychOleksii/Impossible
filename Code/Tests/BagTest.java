package Code.Tests;

import Code.Source.Bag;
import Code.Source.Tile;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagTest {

    @Test
    public void testTake() {
        //create Bag
        Bag bag = new Bag();

        int size = bag.sizeOfBag();
        int workingSize = 5;
        int takeAmount = 3;

        ArrayList<Tile> takenTiles = bag.take(workingSize);

        assertEquals(workingSize, takenTiles.size(), "Wrong number of tiles taken");
        assertEquals(size-workingSize, bag.sizeOfBag(), "Wrong bag size");

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(Tile.GREEN);
        tiles.add(Tile.GREEN);
        tiles.add(Tile.BLACK);
        bag = new Bag(tiles);

        takenTiles = bag.take(takeAmount);
        assertEquals(takeAmount, takenTiles.size(), "Incorrect number of tiles from Bag");

        assertEquals(Tile.BLACK, takenTiles.get(0), "Incorrect tile taken from Bag" );
        assertEquals(Tile.GREEN, takenTiles.get(1), "Incorrect tile taken from Bag" );
        assertEquals(Tile.GREEN, takenTiles.get(2), "Incorrect tile taken from Bag" );


        tiles = new ArrayList<>();
        tiles.add(Tile.YELLOW);
        tiles.add(Tile.RED);
        tiles.add(Tile.YELLOW);
        tiles.add(Tile.RED);
        bag = new Bag(tiles);

        takenTiles = bag.take(takeAmount);
        assertEquals(takeAmount, takenTiles.size(), "Incorrect number of tiles from Bag");

        assertEquals(Tile.RED, takenTiles.get(0), "Incorrect tile taken from Bag" );
        assertEquals(Tile.YELLOW, takenTiles.get(1), "Incorrect tile taken from Bag" );
        assertEquals(Tile.RED, takenTiles.get(2), "Incorrect tile taken from Bag" );


    }
}