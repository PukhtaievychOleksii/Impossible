package Code.Source;

import java.util.ArrayList;

public class UsedTyles {
    private ArrayList<Tile> usedTyles;

    public UsedTyles() {
        this.usedTyles = new ArrayList<>();
    }

    public void give(ArrayList<Tile> tyles) {
        usedTyles.addAll(tyles);
    }

    public ArrayList<Tile> takeAll() {
        return usedTyles;
    }

    public String state() {
        String toReturn = "";
        for (Tile tile : usedTyles) {
            toReturn += tile.toString();
        }
        return toReturn;
    }
}
