package Code;

import java.util.ArrayList;
import java.util.Optional;

import static Code.FinishRoundResult.*;

public class Board {

    private Points points;
    private ArrayList<ArrayList<Tile>> tileTypesSequenceWall;
    private ArrayList<WallLine> wallLines;
    private ArrayList<PatternLine> patternLines;
    private Floor floorLine;
    private ArrayList<Points> floorLineScores;
    private GameFinished gameResult;

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

    private ArrayList<ArrayList<Optional<Tile>>> wallToArrayList(){
        ArrayList<ArrayList<Optional<Tile>>> wall = new ArrayList<>();
        for(WallLine wallLine : wallLines){
            wall.add(wallLine.getTiles());
        }
        return wall;
    }

    public FinishRoundResult finishRound() {
        int finishRoundSum = 0;
        for (int i = 0; i < 5; i++){
            finishRoundSum += patternLines.get(i).finishRound().getValue();
        }
        points = new Points(points.getValue() + finishRoundSum - floorLine.finishRound().getValue());


        if (gameResult.gameFinished(wallToArrayList()) == GAME_FINISHED ) {
            return GAME_FINISHED;
        }
        return NORMAL;
    }



    public void endGame() {
        FinalPointsCalculationComposite bonus = new FinalPointsCalculationComposite();
        points = new Points(points.getValue() + bonus.getPoints(wallToArrayList()).getValue());
//      No test!!! Will be Changed in the future
    }

    public String state() {
        return null;
    }

}