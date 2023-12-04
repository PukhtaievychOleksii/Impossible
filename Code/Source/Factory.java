package Code.Source;

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
<<<<<<< HEAD:Code/Source/Factory.java
<<<<<<< HEAD:Code/Source/Factory.java

    public Factory(ArrayList<Tile> tiles, TableCenter tableCenter) {
=======
=======
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/Factory.java
<<<<<<< HEAD

    public Factory(ArrayList<Tile> tiles, TableCenter tableCenter){
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/Factory.java
        sourceTiles = tiles;
        this.tableCenter = tableCenter;
=======
    public Factory(ArrayList<Tile> tiles){
        sourceTiles = tiles;
        this.tableCenter = new TableCenter();
>>>>>>> 7dea158b8236c85e4478046f073de6708cfcaaa7
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