package Code.Tests;

import Code.Bag;
import Code.Tile;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

=======
import java.util.*;
>>>>>>> b834ed97e2681dff99ed1e5e4ccff5423557986e
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

