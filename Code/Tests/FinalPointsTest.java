package Code.Tests;

import Code.FinalPointsCalculationComposite;
import Code.Interfaces.Component;
import Code.Points;
import Code.Tile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FinalPointsTest {
    @Test
<<<<<<< HEAD
    public void fullMosaicTest() {
=======
    public void fullMosaicTest(){
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
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
        Component comp = new FinalPointsCalculationComposite();
        Points points = comp.getPoints(records);
        assertEquals("Full mosaic should give 95 points.", 95, points.getValue());

    }

    @Test
<<<<<<< HEAD
    public void oneRowCompletedTest() {
=======
    public void oneRowCompletedTest(){
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
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
        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateHorizontalRowPoints(records);
        assertEquals("One row should give 2 points", 2, n);
    }

    @Test
<<<<<<< HEAD
    public void noRowCompletedTest() {
=======
    public void noRowCompletedTest(){
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
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
        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateHorizontalRowPoints(records);
        assertEquals("There is no complete row.", 0, n);
    }
<<<<<<< HEAD

    @Test
    public void oneColumnCompletedTest() {
=======
    @Test
    public void oneColumnCompletedTest(){
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
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
<<<<<<< HEAD
        ArrayList<Optional<Tile>> row5 = new ArrayList<>(
=======
       ArrayList<Optional<Tile>> row5 = new ArrayList<>(
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
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
        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("Two rows should give 14 points", 14, n);
<<<<<<< HEAD
=======
    }
    @Test
    public void noColumnCompletedTest(){
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

        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("There is no complete column.", 0, n);
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
    }

    @Test
    public void noColumnCompletedTest() {
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

        FinalPointsCalculationComposite comp = new FinalPointsCalculationComposite();
        int n = comp.calculateVerticalColumnPoints(records);
        assertEquals("There is no complete column.", 0, n);
    }

    @Test
    public void testCalculateColorPoints() {
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

        FinalPointsCalculationComposite finalPoints = new FinalPointsCalculationComposite();
        int result = finalPoints.calculateColorPoints(records);
        assertEquals(5 * 10, result);
    }
<<<<<<< HEAD
}
=======
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
