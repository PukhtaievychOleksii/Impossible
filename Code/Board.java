package Code;

import java.util.ArrayList;

import static Code.FinishRoundResult.*;
import static Code.Tile.*;

public class Board {

    private Points points;
    private ArrayList<ArrayList<Tile>> finalWall;
    private ArrayList<WallLine> wallLines;
    private ArrayList<PatternLine> patternLines;
    private FinishRoundResult roundResult;
    private Floor floorLine;
    private int[] floorLineScores;

    public Board() {

        finalWall = new ArrayList<>();
        wallLines = new ArrayList<>();
        patternLines = new ArrayList<>();
//        floorLine = new Floor();

        for (int i = 0; i < 5; i++) {
            wallLines.add(new WallLine());
            patternLines.add(new PatternLine(i + 1));
        }

        points = new Points(0);
    }

    public void put(int destinationIdx, ArrayList<Tile> tyles) {
        if (tyles.size() > 0) {
            patternLines.get(destinationIdx).put(tyles);
        }
    }

    public FinishRoundResult finishRound() {
        if (hasCompleteRow()) {
            roundResult = GAME_FINISHED;
            endGame();
        } else roundResult = NORMAL;

        return roundResult;
    }

    public boolean hasCompleteRow() {
        boolean complete;
        for (int row = 0; row < 5; row++) {
            complete = true;
            for (int col = 0; col < 5; col++) {
                    for (Tile tyle: wallLines.get(row).getTiles()) {
                        if(tyle == null){
                            complete = false;
                            break;
                        }
                    }
                    complete = false;
                    break;
                }
            }
            if (complete) return true;
        }
        return false;
    }

    public void endGame() {
        FinalPointsCalculationComposite bonus = new FinalPointsCalculationComposite();
        points = new Points(points.getValue() + bonus.getPoints(finalWall).getValue());
    }

    public String state() {
        return null;
    }

}
