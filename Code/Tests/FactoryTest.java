package Code.Tests;

import Code.Source.Bag;
import Code.Source.Factory;
import Code.Source.TableCenter;
import Code.Source.Tile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FactoryTest {
    @Test
    public void testFactory(){
        Bag bag = new Bag();
        TableCenter tableCenter = new TableCenter();
        Factory factory = new Factory(bag, tableCenter);
        factory.startNewRound();

        //test take
        Tile firstTile = factory.getSourceTiles().get(0);
        int count = 0;
        for(Tile tile : factory.getSourceTiles()){
            if(firstTile.equals(tile)) count++;
        }
        int numberToTake = factory.take(0).size();
        assertEquals(count, numberToTake);
        //all tiles taken
        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.RED, Tile.RED));
        factory = new Factory(tiles, tableCenter);
        assertEquals("All tiles should be taken.", 4, factory.take(0).size());
        assertEquals("No tiles left.", 0, factory.sizeOfFactory());
        //some tiles taken
        tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.YELLOW, Tile.YELLOW));
        factory = new Factory(tiles, tableCenter);
        assertEquals("Two tiles should be taken.", 2, factory.take(0).size());
        assertEquals("Two left.", 2, factory.sizeOfFactory());
        assertEquals("Two tiles should be taken.", 2, factory.take(0).size());
        assertEquals("No tiles left", 0, factory.sizeOfFactory());

<<<<<<< HEAD
=======
        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.BLACK, Tile.BLACK));
        Factory factory1 = new Factory(tiles);
        assertEquals("Two red tiles should be taken.", 2, factory1.take(0).size());
        assertEquals("Two green left.", 2, factory1.sizeOfFactory());
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate)


<<<<<<< HEAD
        tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.RED, Tile.GREEN));
        factory = new Factory(tiles, tableCenter);
        assertEquals("Three should be taken.", 3, factory.take(0).size());
        assertEquals("One should be left.", 1, factory.sizeOfFactory());
        assertEquals("One should be taken.", 1, factory.take(0).size());
        assertEquals("No tiles left.", 0, factory.sizeOfFactory());
=======
        tiles = new ArrayList<>(Arrays.asList(Tile.BLUE, Tile.BLUE, Tile.BLUE, Tile.BLUE));
        Factory factory2 = new Factory(tiles);
        assertEquals("Four blue tiles should be taken.", 4, factory2.take(0).size());
        assertEquals("No tiles left.", 0, factory2.sizeOfFactory());

        tiles = new ArrayList<>(Arrays.asList(Tile.YELLOW, Tile.YELLOW, Tile.YELLOW, Tile.GREEN));
        Factory factory3 = new Factory(tiles);
        assertEquals("Only one green tile should be taken.", 1, factory3.take(3).size());
        assertEquals("Three should be left.", 3, factory3.sizeOfFactory());
        assertEquals("Three yellow tiles should be taken.", 3, factory3.take(0).size());
        assertEquals("No tiles left.", 0, factory3.sizeOfFactory());
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate)


    }
}
