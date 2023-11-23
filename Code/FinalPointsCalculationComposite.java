package Code;
import Code.Interfaces.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FinalPointsCalculationComposite implements Component {
    private Map<String, Integer> countColor;

    public FinalPointsCalculationComposite(){
        this.countColor = new HashMap<>();
        countColor.put("Optional[R]", 0);
        countColor.put("Optional[G]", 0);
        countColor.put("Optional[I]", 0);
        countColor.put("Optional[B]", 0);
        countColor.put("Optional[L]", 0);

    }
    @Override
    public Points getPoints(ArrayList<ArrayList<Optional<Tile>>> board) {
        int totalPoints = 0;
<<<<<<< HEAD

        totalPoints += calculateColorPoints(board);
        totalPoints += calculateHorizontalRowPoints(board);
        totalPoints += calculateVerticalColumnPoints(board);
=======
        /*не считает colorpoints и verticalcolumnpoints*/
        totalPoints += calculateColorPoints(records);
        totalPoints += calculateHorizontalRowPoints(records);
        totalPoints += calculateVerticalColumnPoints(records);

>>>>>>> 6e97e49827390358edba39bc6424ad5c07d49c1e

        return new Points(totalPoints);
    }

    public int calculateHorizontalRowPoints(ArrayList<ArrayList<Optional<Tile>>> board) {
        int horizontalPoints = 0;
        for (ArrayList<Optional<Tile>> row : board) {
            if (isRowComplete(row)) {
                horizontalPoints += 2;
            }
        }
        return horizontalPoints;
    }

<<<<<<< HEAD
    public boolean isRowComplete(ArrayList<Optional<Tile>> row) {
        int counter = 0;
        for (Optional<Tile> tile : row) {
            if (!tile.isPresent()) return false;
            counter++;
        }
        return counter == 5;
    }


    public int calculateVerticalColumnPoints(ArrayList<ArrayList<Optional<Tile>>> records) {
=======
    public boolean isRowComplete(ArrayList<Tile> row) {
        /*Проверяй есть ли 5 Tiles в ряду, а не является ли какой-то null*/
        for (Tile tile : row) {
            if (tile == null) return false;
        }

        return true;
    }


    public int calculateVerticalColumnPoints(ArrayList<ArrayList<Tile>> records) {
        /*INDEXOFBOUNDS EXCEPTION  для row.get(col), так как в row может быть на одном ряду 5 элементов, а на другом 3*/
>>>>>>> 6e97e49827390358edba39bc6424ad5c07d49c1e
        int verticalPoints = 0;
        for( int col = 0; col < records.get(0).size(); col++){
            ArrayList<Optional<Tile>> column = new ArrayList<>();
            for(ArrayList<Optional<Tile>> row : records) {
                if (row.size() > col) {
                    column.add(row.get(col));
                }
            }
            if(isColumnComplete(column)){
                verticalPoints += 7;
            }
        }
        return verticalPoints;
    }

<<<<<<< HEAD
    public boolean isColumnComplete(ArrayList<Optional<Tile>> column){
        int counter = 0;
        for(Optional<Tile> tile : column){
            if (!tile.isPresent()) return false;
            counter++;
=======
    public boolean isColumnComplete(ArrayList<Tile> column){
        /*Проверяй есть ли 5 Tiles по вертикале, а не является ли какой-то null*/
        for(Tile tile : column){
            if (tile == null) return false;
>>>>>>> 6e97e49827390358edba39bc6424ad5c07d49c1e
        }
       return counter == 5;
    }

    public int calculateColorPoints(ArrayList<ArrayList<Optional<Tile>>> records) {
        int colorPoints = 0;
        for (ArrayList<Optional<Tile>> row : records){
            colorPoints += calculateColorPointsInRow(row);
        }
<<<<<<< HEAD
        if(countColor.get("Optional[R]") == 5){
            colorPoints += 10;
        }
        if(countColor.get("Optional[G]") == 5){
            colorPoints += 10;
        }
        if(countColor.get("Optional[I]") == 5){
            colorPoints += 10;
        }
        if(countColor.get("Optional[B]") == 5){
            colorPoints += 10;
        }
        if(countColor.get("Optional[L]") == 5){
            colorPoints += 10;
=======
        return colorPoints;
    }
    public int calculateColorPointsInRow(ArrayList<Tile> row){
        int colorPoints = 0;
        Map<String, Integer> countColor = new HashMap<>();
        for(Tile tile : row){
            String FirstLetterColor = tile.toString();

            countColor.put(FirstLetterColor, countColor.getOrDefault(FirstLetterColor, 0) + 1);

            if (countColor.get(FirstLetterColor) == 5){
                //никогда не попадет в этот иф
                colorPoints += 10;
            }
>>>>>>> 6e97e49827390358edba39bc6424ad5c07d49c1e
        }
        return colorPoints;
    }
    public int calculateColorPointsInRow(ArrayList<Optional<Tile>> row){
        int colorPoints = 0;
        for(Optional<Tile> tile : row){
            String FirstLetterColor = tile.toString();
            countColor.put(FirstLetterColor, countColor.getOrDefault(FirstLetterColor, 0) + 1);
        }
        return colorPoints;
    }

}
