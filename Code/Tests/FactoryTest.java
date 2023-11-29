package Code.Tests;

import Code.Bag;
import Code.Factory;
import Code.TableCenter;
import Code.Tile;
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
        Tile tile = factory.getSourceTiles().get(0);
        int count = 0;
        for(Tile tile1 : factory.getSourceTiles()){
            if(tile.equals(tile1)) count++;
        }
        int n = factory.take(0).size();
        assertEquals(count, n);

        ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(Tile.RED, Tile.RED, Tile.BLACK, Tile.BLACK));
        Factory factory1 = new Factory(tiles);
        assertEquals("Two red tiles should be taken.", 2, factory1.take(0).size());
        assertEquals("Two green left.", 2, factory1.sizeOfFactory());

        assertEquals("Two green tiles should be taken.", 2, factory1.take(3).size());
        assertEquals("No tiles left", 0, factory1.sizeOfFactory());

        tiles = new ArrayList<>(Arrays.asList(Tile.BLUE, Tile.BLUE, Tile.BLUE, Tile.BLUE));
        Factory factory2 = new Factory(tiles);
        assertEquals("Four black tiles should be taken.", 4, factory2.take(0).size());
        assertEquals("No tiles left.", 0, factory2.sizeOfFactory());

        tiles = new ArrayList<>(Arrays.asList(Tile.YELLOW, Tile.YELLOW, Tile.YELLOW, Tile.GREEN));
        Factory factory3 = new Factory(tiles);
        assertEquals("Only one green tile should be taken.", 1, factory2.take(3).size());
        assertEquals("Three should be left.", 3, factory2.sizeOfFactory());
        assertEquals("Three yellow tiles should be taken.", 3, factory2.take(0).size());
        assertEquals("No tiles left.", 0, factory2.sizeOfFactory());


    }
}
