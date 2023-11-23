package Code.Tests;

import Code.Floor;
import Code.Points;
import Code.Tile;
import org.junit.Test;

import java.util.ArrayList;

public class PatternLineTest {
    @Test
    public void patternLineTest(){
        ArrayList<Tile> usedTiles = new ArrayList<>();
        ArrayList<Points> pointPattern = new ArrayList<Points>();
        pointPattern.add(new Points(1));
        pointPattern.add(new Points(2));
        pointPattern.add(new Points(2));
        Floor floor = new Floor(usedTiles, pointPattern);

    }
}
