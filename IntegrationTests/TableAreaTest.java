package IntegrationTests;

import Code.TableArea;
import Code.Tile;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TableAreaTest {
    @Test
    public void notExistsSource(){
        TableArea tableArea = new TableArea(5);
        ArrayList<Tile> taken = tableArea.take(7, 1);
        assertEquals("Number of taken tiles should be 0", 0, taken.size());
    }

    @Test
    public void takeFromTableCenterSource(){
        TableArea tableArea = new TableArea(5);
        ArrayList<Tile> taken = tableArea.take(0, 1);
        assertEquals("Number of taken tiles should be > 0", );
    }
}
