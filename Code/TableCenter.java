package Code;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableCenter extends TyleSource{

    public void add(ArrayList<Tile> tiles){
        sourceTiles.addAll(tiles);
    }

    @Override
    public void startNewRound(){
        ArrayList<Tile> arrayList = new ArrayList<>();
        arrayList.add(Tile.STARTING_PLAYER);
        add(arrayList);
    }


    @Test
    public void startNewRoundTest () {
        TableCenter tableCenter = new TableCenter();
        tableCenter.startNewRound();
        assertEquals(1, tableCenter.sourceTiles.size());
        assertTrue(tableCenter.sourceTiles.contains(Tile.STARTING_PLAYER));
    }

}
