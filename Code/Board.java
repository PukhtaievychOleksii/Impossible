package Code;

import java.util.ArrayList;
import java.util.Optional;

import static Code.FinishRoundResult.*;

public class Board {

    private Points points;
    private ArrayList<ArrayList<Tile>> tileTypesSequenceWall;
    private ArrayList<WallLine> wallLines;
    private ArrayList<PatternLine> patternLines;
    private FinishRoundResult roundResult;
    private Floor floorLine;
    private ArrayList<Points> floorLineScores;

    public Board() {
        points = new Points(0);

        tileTypesSequenceWall = new ArrayList<>();
        fillTypesSequenceWall();

        wallLines = new ArrayList<>();
        patternLines = new ArrayList<>();

        fillFlorLineScores();
        floorLine = new Floor(new ArrayList<>(), floorLineScores);

        for (int i = 0; i < 5; i++) {
            wallLines.add(new WallLine(tileTypesSequenceWall.get(i)));
            patternLines.add(new PatternLine(i + 1, floorLine, wallLines.get(i)));
        }
        setNeighbours();

    }

    private void setNeighbours(){
        wallLines.get(0).setDownWall(wallLines.get(1));
        for(int i = 1; i < 4; i++){
            wallLines.get(i).setUpWall(wallLines.get(i - 1));
            wallLines.get(i).setDownWall(wallLines.get(i + 1));
        }
        wallLines.get(4).setUpWall(wallLines.get(3));
    }

    private void fillFlorLineScores() {
        int count = -1;
        for (int i = 0; i < 7; i++) {
            if (i == 2) count = -2;
            if (i == 5) count = -3;
            floorLineScores.add(i, new Points(count));
        }
    }

    private void fillTypesSequenceWall() {
        for (int i = 0; i < 5; i++) {
            tileTypesSequenceWall.add(i, new ArrayList<Tile>());
            for (int j = 0; j < 5; j++) {
                Tile wallTyle = null;
                if (i == j) wallTyle = Tile.BLUE;
                else if ((i + 1) % 5 == j) wallTyle = Tile.YELLOW;
                else if ((i + 2) % 5 == j) wallTyle = Tile.RED;
                else if ((i + 3) % 5 == j) wallTyle = Tile.BLACK;
                else if ((i + 4) % 5 == j) wallTyle = Tile.GREEN;
                tileTypesSequenceWall.get(i).add(j, wallTyle);
            }
        }
    }

    public void put(int destinationIdx, ArrayList<Tile> tyles) {
        patternLines.get(destinationIdx).put(tyles);
    }

    public FinishRoundResult finishRound() {
        int finishRoundSum = 0;
        for (int i = 0; i < 5; i++){
            finishRoundSum += patternLines.get(i).finishRound().getValue();
        }
        points = new Points(points.getValue() + finishRoundSum - floorLine.finishRound().getValue());


        if (hasCompleteRow()) {
            roundResult = GAME_FINISHED;
            endGame();
        } else {
            roundResult = NORMAL;
        }
        return roundResult;
    }

    private boolean hasCompleteRow() {
        boolean complete;
        for (int row = 0; row < 5; row++) {
            complete = true;
            for (int col = 0; col < 5; col++) {
                for (Optional<Tile> oTyle : wallLines.get(row).getTiles()) {
                    if (oTyle.isEmpty()) {
                        complete = false;
                        break;
                    }
                }
            }
            if (complete) return true;
        }
        return false;
    }

    public void endGame() {
        FinalPointsCalculationComposite bonus = new FinalPointsCalculationComposite();
<<<<<<< HEAD
        points = new Points(points.getValue() + bonus.getPoints(wallLines).getValue());
=======
<<<<<<< HEAD
       // points = new Points(points.getValue() + bonus.getPoints(finalWall).getValue());
=======
        //points = new Points(points.getValue() + bonus.getPoints(finalWall).getValue());
>>>>>>> 9f7e9144890f15609cb21241fda8354537f32d4c
>>>>>>> b14be8094aea7d7f92c0184e914b921410982845
    }

    public String state() {
        return null;
    }

}