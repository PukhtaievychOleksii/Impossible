package Code;

import java.util.ArrayList;

public class Factory extends TyleSource{
    private ArrayList<Tile> factoryTiles;
    private TableCenter tableCenter;
    private Bag bag;
    public Factory(Bag bag, TableCenter tableCenter) {
        super();
        this.bag = bag;
        this.tableCenter = tableCenter;
    }



    @Override
    public void startNewRound(){
        if (bag.sizeOfBag() >= 4) {
            sourceTiles = bag.take(4);
        }
        else{
            sourceTiles = bag.take(bag.sizeOfBag());
        }
    }

    @Override
    public ArrayList<Tile> take(int indexOfTile){
        ArrayList<Tile> toReturn = super.take(indexOfTile);
        ArrayList<Tile> moveToCenter = new ArrayList<>();
        for(Tile tile : sourceTiles){
            if(!toReturn.contains(tile)) {
                moveToCenter.add(tile);
                //sourceTiles.remove(tile);
            }
        }
        tableCenter.add(moveToCenter);
        return toReturn;
    }
    public int sizeOfFactory(){
        return sourceTiles.size();
    }
}