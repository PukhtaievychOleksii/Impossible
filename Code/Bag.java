package Code;

import java.util.*;

import static java.time.chrono.JapaneseEra.values;

public class Bag {
    private Stack<Tile> bag;

    public Bag(){
        this.bag = new Stack<>();
        for(Tile color : Tile.values()){
            for (int i = 0; i < 20; i++) {
                bag.push(color);
            }
        }
        Collections.shuffle(bag);
    }



    public ArrayList<Tile> take(int count){
        ArrayList<Tile> taken = new ArrayList<>();
        for(int i = 0; i < count; i++){
            taken.add(bag.pop());
        }
        return taken;
    }
    public int sizeOfBag(){
        return bag.size();
    }

    public String state(){
        String result = "Current size of bag:" + bag.capacity();
        for(Tile tile : bag){
            result += tile.toString() + "\n";
        }
        return result;
    }
}