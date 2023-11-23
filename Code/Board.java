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
        tileTypesSequenceWall = new ArrayList<>();
        wallLines = new ArrayList<>();
        patternLines = new ArrayList<>();

        fillFlorLineScores();
        floorLine = new Floor(new ArrayList<>(), floorLineScores);

        for (int i = 0; i < 5; i++) {
            //TODO: use constructor
            if(i == 0) {
                wallLines.add(new WallLine());
            }
            patternLines.add(new PatternLine(i + 1, floorLine, wallLines.get(i)));
        }

        points = new Points(0);
    }

    private void fillFlorLineScores() {
        int count = -1;
        for (int i = 0; i < 7; i++) {
            if (i == 2) count = -2;
            if (i == 5) count = -3;
            floorLineScores.add(i, new Points(count));
        }
    }

    public void put(int destinationIdx, ArrayList<Tile> tyles) {
        patternLines.get(destinationIdx).put(tyles);
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
                for (Optional<Tile> oTyle : wallLines.get(row).getTiles()) {
                    if (oTyle.get() == null) {
                        complete = false;
                        break;
                    }
                }
                complete = false;
                break;

            }
            if (complete) return true;
        }
        return false;
    }

    public void endGame() {
        FinalPointsCalculationComposite bonus = new FinalPointsCalculationComposite();
        points = new Points(points.getValue() + bonus.getPoints(tileTypesSequenceWall).getValue());
    }

    public String state() {
        return null;
    }

}
