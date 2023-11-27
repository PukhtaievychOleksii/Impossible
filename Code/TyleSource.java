package Code;

import java.util.ArrayList;
import java.util.Iterator;

public class TyleSource {
    protected ArrayList<Tile> sourceTiles;
    public TyleSource(){
        this.sourceTiles = new ArrayList();
    }
    public ArrayList<Tile> take(int indexOfTile){
        ArrayList<Tile> oneColorTiles = new ArrayList<>();
        Tile tile = sourceTiles.get(indexOfTile);
        for(Tile t : sourceTiles){
            if(tile.equals(t)){
                oneColorTiles.add(t);
                sourceTiles.remove(t);
            }
        }
        return oneColorTiles;
    }
    public boolean isEmpty(){
        return sourceTiles.isEmpty();
    }

    public void startNewRound(){

    }
    public String state(){
        String result = "";
        if(!sourceTiles.isEmpty()){
            result += "Contains: ";
            result += sourceTiles.toString();
        }

        return result;
    }

}
