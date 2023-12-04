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



        tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.RED, Tile.GREEN));
        factory = new Factory(tiles, tableCenter);
        assertEquals("Three should be taken.", 3, factory.take(0).size());
        assertEquals("One should be left.", 1, factory.sizeOfFactory());
        assertEquals("One should be taken.", 1, factory.take(0).size());
        assertEquals("No tiles left.", 0, factory.sizeOfFactory());


    }
}
