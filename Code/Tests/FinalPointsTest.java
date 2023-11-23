package Code.Tests;

import Code.FinalPointsCalculationComposite;
import Code.Interfaces.Component;
import Code.Points;
import Code.Tile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FinalPointsTest {
    @Test
    public void fullMosaicTest(){
        ArrayList<ArrayList<Tile>> records = new ArrayList<>();
        ArrayList<Tile> row1 = new ArrayList<>(5);
        row1.add(Tile.BLUE);
        row1.add(Tile.YELLOW);
        row1.add(Tile.RED);
        row1.add(Tile.BLACK);
        row1.add(Tile.GREEN);
        records.add(row1);
        ArrayList<Tile> row2 = new ArrayList<>(5);
        row2.add(Tile.GREEN);
        row2.add(Tile.BLUE);
        row2.add(Tile.YELLOW);
        row2.add(Tile.RED);
        row2.add(Tile.BLACK);
        records.add(row2);
        ArrayList<Tile> row3 = new ArrayList<>(5);
        row3.add(Tile.BLACK);
        row3.add(Tile.GREEN);
        row3.add(Tile.BLUE);
        row3.add(Tile.YELLOW);
        row3.add(Tile.RED);
        records.add(row3);
        ArrayList<Tile> row4 = new ArrayList<>(5);
        row4.add(Tile.RED);
        row4.add(Tile.BLACK);
        row4.add(Tile.GREEN);
        row4.add(Tile.BLUE);
        row4.add(Tile.YELLOW);
        records.add(row4);
        ArrayList<Tile> row5 = new ArrayList<>(5);
        row5.add(Tile.YELLOW);
        row5.add(Tile.RED);
        row5.add(Tile.BLACK);
        row5.add(Tile.GREEN);
        row5.add(Tile.BLUE);
        records.add(row5);

        Component comp = new FinalPointsCalculationComposite();
        Points points = comp.getPoints(records);
        assertEquals("Full mosaic should give 95 points.", 95, points.getValue());

    }
    @Test
    public void oneRowCompletedTest(){
        ArrayList<ArrayList<Tile>> records = new ArrayList<>(5);
        ArrayList<Tile> row1 = new ArrayList<>(5);
        row1.add(Tile.BLUE);
        row1.add(Tile.YELLOW);
        row1.add(Tile.RED);
        row1.add(Tile.BLACK);
        row1.add(Tile.GREEN);
        records.add(row1);
        ArrayList<Tile> row2 = new ArrayList<>(5);
        row2.add(Tile.GREEN);
        row2.add(Tile.BLUE);
        row2.add(Tile.YELLOW);
        row2.add(Tile.RED);
        records.add(row2);
        ArrayList<Tile> row3 = new ArrayList<>(5);
        row3.add(Tile.BLACK);
        row3.add(Tile.RED);
        row3.add(Tile.GREEN);
        records.add(row3);
        ArrayList<Tile> row4 = new ArrayList<>(5);
        row4.add(Tile.BLUE);
        row4.add(Tile.GREEN);
        records.add(row4);
        ArrayList<Tile> row5 = new ArrayList<>(5);
        row5.add(Tile.BLUE);
        row5.add(Tile.GREEN);
        records.add(row5);
        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateHorizontalRowPoints(records);
        assertEquals("One row should give 2 points", 2, n);
    }
    @Test
    public void oneColumnCompletedTest(){
        ArrayList<ArrayList<Tile>> records = new ArrayList<>(5);
        ArrayList<Tile> row1 = new ArrayList<>(5);
        row1.add(Tile.BLUE);
        row1.add(Tile.YELLOW);
        row1.add(Tile.RED);
        row1.add(Tile.BLACK);
        row1.add(Tile.GREEN);
        records.add(row1);
        ArrayList<Tile> row2 = new ArrayList<>(5);
        row2.add(Tile.GREEN);
        row2.add(Tile.BLUE);
        row2.add(Tile.YELLOW);
        row2.add(Tile.RED);
        records.add(row2);
        ArrayList<Tile> row3 = new ArrayList<>(5);
        row3.add(Tile.BLACK);
        row3.add(Tile.RED);
        row3.add(Tile.GREEN);
        records.add(row3);
        ArrayList<Tile> row4 = new ArrayList<>(5);
        row4.add(Tile.BLUE);
        row4.add(Tile.GREEN);
        records.add(row4);
        ArrayList<Tile> row5 = new ArrayList<>(5);
        row5.add(Tile.BLUE);
        records.add(row5);
        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("One row should give 7 points", 7, n);
    }
    @Test
    public void testCalculateColorPoints() {
        ArrayList<ArrayList<Tile>> records = new ArrayList<>();
        ArrayList<Tile> row1 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.YELLOW, Tile.GREEN, Tile.BLUE, Tile.BLACK));
        ArrayList<Tile> row2 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.YELLOW, Tile.GREEN, Tile.BLUE, Tile.BLACK));
        ArrayList<Tile> row3 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.YELLOW, Tile.GREEN, Tile.BLUE, Tile.BLACK));
        ArrayList<Tile> row4 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.YELLOW, Tile.GREEN, Tile.BLUE, Tile.BLACK));
        ArrayList<Tile> row5 = new ArrayList<>(Arrays.asList(Tile.RED, Tile.YELLOW, Tile.GREEN, Tile.BLUE, Tile.BLACK));

        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);
        records.add(row5);

        FinalPointsCalculationComposite finalPoints = new FinalPointsCalculationComposite();
        int result = finalPoints.calculateColorPoints(records);
        assertEquals(5 * 10, result);
    }
}
