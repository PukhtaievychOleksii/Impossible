package Code.Tests;

import Code.Bag;
import Code.Tile;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagTest {

    @Test
    public void testTake() {
        Bag bag = new Bag();

        int count = 5;
        ArrayList<Tile> takenTiles = bag.take(count);

        assertEquals(count, takenTiles.size(), "Incorrect number of tiles taken");

        }
    }

