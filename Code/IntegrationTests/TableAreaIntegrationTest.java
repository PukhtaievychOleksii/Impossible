package Code.IntegrationTests;

import Code.Source.Bag;
import Code.Source.TableArea;
import Code.Source.Tile;
import Code.Source.TyleSource;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableAreaIntegrationTest {

    @Test
    public void testIntegrationWithTyleSource(){
        //create TableArea
        ArrayList<ArrayList<Tile>> factoryTiles = new ArrayList<>();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(Tile.GREEN);
        tiles.add(Tile.RED);
        tiles.add(Tile.GREEN);
        tiles.add(Tile.GREEN);
        factoryTiles.add(tiles);
        TableArea tableArea = new TableArea(factoryTiles);
        final int workingIndex = 0;

        //test Integration
        TyleSource tyleSource = tableArea.getTyleSource(workingIndex + 1);
        int initialSize = tyleSource.getSize();
        tableArea.take(workingIndex + 1,0);
        int currentSize = tyleSource.getSize();
        assertTrue("Tiles were not taken from the source", initialSize > currentSize);
        assertEquals("The wrong amount of tiles were taken", currentSize,1);
    }

    @Test
    public void takeTableArea(){
        //create TableArea
        ArrayList<ArrayList<Tile>> factoryTiles = new ArrayList<>();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(Tile.GREEN);
        tiles.add(Tile.YELLOW);
        tiles.add(Tile.GREEN);
        tiles.add(Tile.GREEN);
        factoryTiles.add(tiles);
        TableArea tableArea = new TableArea(factoryTiles);
        ArrayList<Tile> taken = tableArea.take(1, 0);
        assertEquals("Number of taken tiles should be 3",3, taken.size() );
    }

    @Test
    public void roundEndTest(){
        ArrayList<ArrayList<Tile>> factoriesTile = new ArrayList<>();
        factoriesTile.add(new ArrayList<>());
        factoriesTile.add(new ArrayList<>());
        TableArea tableArea = new TableArea(factoriesTile);
        assertEquals("Round should be finished", true, tableArea.isRoundEnd());
    }

    @Test
    public void notExistsSource(){
        Bag bag = new Bag();
        TableArea tableArea = new TableArea(5, bag);
        ArrayList<Tile> taken = tableArea.take(7, 1);
        assertEquals("Number of taken tiles should be 0", 0, taken.size());
    }


}
