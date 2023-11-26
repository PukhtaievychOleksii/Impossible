package Code;

import java.util.ArrayList;

public class Factory {
    private ArrayList<Tile> factoryTiles;
    public Factory(Bag bag) {
        if (bag.sizeOfBag() >= 4) {
            factoryTiles = bag.take(4);
        }
        else{
            factoryTiles = bag.take(bag.sizeOfBag());
        }
    }
    public ArrayList<Tile> getFactoryTiles(){
        return factoryTiles;
    }
    public boolean isEmpty(){
        return factoryTiles.isEmpty();
    }
    public int sizeOfFactory(){
        return factoryTiles.size();
    }
}
