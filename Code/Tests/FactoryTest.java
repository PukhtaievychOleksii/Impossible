package Code.Tests;

import Code.Bag;
import Code.Factory;
import Code.TableCenter;
import Code.Tile;
import org.junit.Test;

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
    }
}
