package Code.Source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Bag {
    private ArrayList<Tile> bag;
    private UsedTyles usedTyles;
    private final int numOfTiles = 20;
    public Bag(){
        this.bag = new ArrayList<>();
        for(Tile tile : Tile.values()) {
            for (int i = 0; i < numOfTiles; i++) {
                bag.add(tile);
            }
        }
        Collections.shuffle(bag);

        usedTyles = new UsedTyles();
    }
    public Bag(ArrayList<Tile> tiles){
        bag = tiles;
    }

    public ArrayList<Tile> take(int count){
        ArrayList<Tile> taken = new ArrayList<>();
        for(int i = 0; i < count; i++){
            taken.add(bag.get(bag.size() - 1));
            bag.remove(bag.size() - 1);
        }
        return taken;
    }
    public int sizeOfBag(){
        return bag.size();
    }

    public String state(){
        String result = "Current size of bag:" + bag.size();
        for(Tile tile : bag){
            result += tile.toString() + "\n";
        }
        return result;
    }

    public UsedTyles getUsedTiles() {
        return usedTyles;
    }
}