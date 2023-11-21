package Code;
import Code.Interfaces.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FinalPointsCalculationComposite implements Component {
    @Override
    public Points getPoints(ArrayList<ArrayList<Tile>> records) {
        int totalPoints = 0;

        totalPoints += calculateColorPoints(records);
        totalPoints += calculateHorizontalRowPoints(records);
        totalPoints += calculateVerticalColumnPoints(records);


        return new Points(totalPoints);
    }

    public int calculateHorizontalRowPoints(ArrayList<ArrayList<Tile>> records) {
        int horizontalPoints = 0;
        for (ArrayList<Tile> row : records) {
            if (isRowComplete(row)) {
                horizontalPoints += 2;
            }
        }
        return horizontalPoints;
    }

    public boolean isRowComplete(ArrayList<Tile> row) {
        for (Tile tile : row) {
            if (tile == null) return false;
        }
        return true;
    }


    public int calculateVerticalColumnPoints(ArrayList<ArrayList<Tile>> records) {
        int verticalPoints = 0;
        for( int col = 0; col < records.get(0).size(); col++){
            ArrayList<Tile> column = new ArrayList<>();
            for(ArrayList<Tile> row : records){
                column.add(row.get(col));
            }
            if(isColumnComplete(column)){
                verticalPoints += 7;
            }
        }
        return verticalPoints;
    }

    public boolean isColumnComplete(ArrayList<Tile> column){
        for(Tile tile : column){
            if (tile == null) return false;
        }
       return false;
    }
    
    public int calculateColorPoints(ArrayList<ArrayList<Tile>> records) {
        int colorPoints = 0;
        for (ArrayList<Tile> row : records){
            colorPoints += calculateColorPointsInRow(row);
        }
        return colorPoints;
    }
    public int calculateColorPointsInRow(ArrayList<Tile> row){
        int colorPoints = 0;
        Map<String, Integer> countColor = new HashMap<>();
        for(Tile tile : row){
            String FirstLetterColor = tile.toString();

            countColor.put(FirstLetterColor, countColor.getOrDefault(FirstLetterColor, 0) + 1);

            if (countColor.get(FirstLetterColor) == 5){
                colorPoints += 10;
            }
        }
        return colorPoints;
    }
}
