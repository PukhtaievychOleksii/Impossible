package Code.Tests;

import Code.Source.FinalPointsCalculation;
import Code.Interfaces.Component;
import Code.Source.Points;
import Code.Source.Tile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FinalPointsTest {

    @Test
    public void calculatePointsTest() {
        ArrayList<ArrayList<Optional<Tile>>> records = new ArrayList<>();
        ArrayList<Optional<Tile>> row1 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row2 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row3 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row4 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row5 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );

        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);
        records.add(row5);

        FinalPointsCalculation finalPoints = new FinalPointsCalculation();
        int result = finalPoints.calculateColorPoints(records);
        assertEquals(5 * 10, result);
    }

    @Test
    public void oneRowFullTest(){
        ArrayList<ArrayList<Optional<Tile>>> records = new ArrayList<>();
        ArrayList<Optional<Tile>> row1 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row2 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row3 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row4 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );
        ArrayList<Optional<Tile>> row5 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );

        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);
        records.add(row5);
        FinalPointsCalculation comp = new FinalPointsCalculation();
        int n = comp.calculateHorizontalRowPoints(records);
        assertEquals("One row should give 2 points", 2, n);
    }

    @Test
    public void noRowTest(){
        ArrayList<ArrayList<Optional<Tile>>> records = new ArrayList<>();
        ArrayList<Optional<Tile>> row1 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED)
                )
        );
        ArrayList<Optional<Tile>> row2 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE)
                )
        );
        ArrayList<Optional<Tile>> row3 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row4 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );
        ArrayList<Optional<Tile>> row5 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );

        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);
        records.add(row5);
        FinalPointsCalculation comp = new FinalPointsCalculation();
        int n = comp.calculateHorizontalRowPoints(records);
        assertEquals("There is no complete row.", 0, n);
    }

    @Test
    public void oneColumnFullTest(){
        ArrayList<ArrayList<Optional<Tile>>> records = new ArrayList<>();
        ArrayList<Optional<Tile>> row1 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE),
                        Optional.of(Tile.BLACK)
                )
        );
        ArrayList<Optional<Tile>> row2 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row3 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row4 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );
        ArrayList<Optional<Tile>> row5 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW)
                )
        );

        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);
        records.add(row5);
        FinalPointsCalculation comp = new FinalPointsCalculation();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("Two rows should give 14 points", 14, n);
    }

    @Test
    public void noColumnFullTest() {
        ArrayList<ArrayList<Optional<Tile>>> records = new ArrayList<>();
        ArrayList<Optional<Tile>> row1 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.BLACK),
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN),
                        Optional.of(Tile.BLUE)
                )
        );
        ArrayList<Optional<Tile>> row2 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row3 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.RED),
                        Optional.of(Tile.YELLOW),
                        Optional.of(Tile.GREEN)
                )
        );
        ArrayList<Optional<Tile>> row4 = new ArrayList<>(
                Arrays.asList(
                        Optional.of(Tile.YELLOW)
                )
        );
        records.add(row1);
        records.add(row2);
        records.add(row3);
        records.add(row4);

        FinalPointsCalculation comp = new FinalPointsCalculation();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("There is no complete column.", 0, n);
    }


}