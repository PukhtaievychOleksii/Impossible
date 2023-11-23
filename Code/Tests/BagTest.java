package Code.Tests;

import Code.Bag;
import Code.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class BagTest {
    private Bag bag;

    @BeforeEach
    public void setUp() { bag = new Bag(); }

    @Test
    public void testBagInitialization() {

    }
    @Test
    public void testTake() {
        int count = 5;
        ArrayList<Tile> takenTiles = bag.take(count);
        assertEquals(count, takenTiles.size());
    }



}

