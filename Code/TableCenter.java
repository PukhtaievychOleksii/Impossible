package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableCenter extends TyleSource{

    public void add(ArrayList<Tile> tiles){
        sourceTiles.addAll(tiles);
    }

    @Override
    public void startNewRound(){
        ArrayList<Tile> arrayList = new ArrayList<>();
        arrayList.add(Tile.STARTING_PLAYER);
        add(arrayList);
    }

}
