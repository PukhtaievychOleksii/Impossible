package IntegrationTests;

import Code.Bag;
import Code.TableArea;
import Code.Tile;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TableAreaTest {
    @Test
    public void notExistsSource(){
        Bag bag = new Bag();
        TableArea tableArea = new TableArea(5, bag);
        ArrayList<Tile> taken = tableArea.take(7, 1);
        assertEquals("Number of taken tiles should be 0", 0, taken.size());
    }

    @Test
    public void takeTableArea(){
        ArrayList<ArrayList<Tile>> factoriesTile = new ArrayList<>();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(Tile.RED);
        tiles.add(Tile.YELLOW);
        tiles.add(Tile.GREEN);
        tiles.add(Tile.RED);
        factoriesTile.add(tiles);

        TableArea tableArea = new TableArea(factoriesTile);
        ArrayList<Tile> taken = tableArea.take(1, 0);
        assertEquals("Number of taken tiles should be 2",2, taken.size() );
    }



    @Test
    public void RoundEndTest(){
        ArrayList<ArrayList<Tile>> factoriesTile = new ArrayList<>();
        factoriesTile.add(new ArrayList<>());
        factoriesTile.add(new ArrayList<>());
        TableArea tableArea = new TableArea(factoriesTile);
        assertEquals("Round should be end", true, tableArea.isRoundEnd());


    }
}
