package Code;

import java.util.ArrayList;
import java.util.Iterator;

public class TyleSource {
    private Factory sourceFactory;
    private ArrayList<Tile> sourceTiles;
    public TyleSource(Factory factory){
        this.sourceFactory = factory;
        this.sourceTiles = factory.getFactoryTiles();
    }
    public ArrayList<Tile> take(int indexOfTile){
        ArrayList<Tile> oneColorTiles = new ArrayList<>();
        Tile tile = sourceTiles.get(indexOfTile);
        for(Tile t : sourceTiles){
            if(tile.toString().equals(t.toString())){
                oneColorTiles.add(t);
                sourceTiles.remove(t);
            }
        }
        return oneColorTiles;
    }
    public boolean isEmpty(){
        return sourceFactory.isEmpty();
    }
    public ArrayList<Tile> getSourceTiles(){
        return sourceTiles;
    }
    //must be a function startNewRound()
    public String state(){
        String result = "";
        if(!sourceFactory.isEmpty()){
            result += "The size of SourceTile is " +  sourceFactory.sizeOfFactory() + "\n";
        }
        result += "SourceTyle contains: ";
        for(Tile tile : sourceFactory.getFactoryTiles()){
            result += tile.toString() + ",";
        }
        return result;
    }

}
