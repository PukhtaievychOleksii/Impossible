package Code;

import java.util.ArrayList;
import java.util.Optional;

public class GameFinished {
    private ArrayList<ArrayList<Optional<Tile>>> wall;

    public FinishRoundResult gameFinished(ArrayList<ArrayList<Optional<Tile>>> wall) {
        this.wall = wall;
        if (hasCompleteRow()) {
            return FinishRoundResult.GAME_FINISHED;
        } else return FinishRoundResult.NORMAL;
    }

    private boolean hasCompleteRow() {
        boolean complete;
        for (int row = 0; row < 5; row++) {
            complete = true;
            for (Optional<Tile> oTyle : wall.get(row)) {
                if (!oTyle.isPresent()) {
                    complete = false;
                    break;
                }
            }
            if (complete) return true;
        }
        return false;
    }
}