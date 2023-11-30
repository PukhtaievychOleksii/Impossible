package Code.Tests;

import Code.Bag;
import Code.Tile;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagTest {

    @Test
    public void testTake() {
        Bag bag = new Bag();

        int count = 5;
        int n = bag.sizeOfBag();
        ArrayList<Tile> takenTiles = bag.take(count);

        assertEquals(count, takenTiles.size(), "Incorrect number of tiles taken");
        assertEquals(n-count, bag.sizeOfBag(), "Incorrect size of bag.");

        Stack<Tile> tiles = new Stack<>();
        tiles.push(Tile.RED);
        tiles.push(Tile.YELLOW);
        tiles.push(Tile.BLUE);
        tiles.push(Tile.GREEN);
        tiles.push(Tile.GREEN);
        tiles.push(Tile.BLACK);
        Bag bag1 = new Bag(tiles);

        int takeCount = 2;
        ArrayList<Tile> takenFromBag1 = bag1.take(takeCount);
        assertEquals(takeCount, takenFromBag1.size(), "Incorrect number of tiles from Bag1");

        assertEquals(Tile.GREEN, takenFromBag1.get(1), "Incorrect tile taken from Bag1" );
        assertEquals(Tile.BLACK, takenFromBag1.get(0), "Incorrect tile taken from Bag1" );

        tiles = new Stack<>();
        tiles.push(Tile.BLUE);
        tiles.push(Tile.YELLOW);
        tiles.push(Tile.RED);
        tiles.push(Tile.BLACK);
        tiles.push(Tile.GREEN);
        Bag bag2 = new Bag(tiles);

        int takeCount2 = 3;
        ArrayList<Tile> takenFromBag2 = bag2.take(takeCount2);
        assertEquals(takeCount2, takenFromBag2.size(), "Incorrect number of tiles from Bag1");

        assertEquals(Tile.GREEN, takenFromBag2.get(0), "Incorrect tile taken from Bag1" );
        assertEquals(Tile.BLACK, takenFromBag2.get(1), "Incorrect tile taken from Bag1" );
        assertEquals(Tile.RED, takenFromBag2.get(2), "Incorrect tile taken from Bag1" );

        
    }
}