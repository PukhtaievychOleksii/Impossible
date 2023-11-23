package Code.Tests;

import org.junit.Test;
import Code.Tile;
import Code.WallLine;
import java.util.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WallLineTest {
    @Test
    public void testCanPutTile() {
        ArrayList<Tile> tileTypesSequence = new ArrayList<>(Arrays.asList(Tile.RED,Tile.GREEN, Tile.BLUE, Tile.YELLOW, Tile.BLACK));
        WallLine wallLine = new WallLine(tileTypesSequence);

        assertTrue(wallLine.canPutTile(Tile.RED));
        wallLine.putTile(Tile.RED);
        assertFalse(wallLine.canPutTile(Tile.RED));
        assertTrue(wallLine.canPutTile(Tile.YELLOW));



    }

}
