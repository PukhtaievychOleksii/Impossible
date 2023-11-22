package Code;

import java.util.ArrayList;
import java.util.Collections;

import static java.time.chrono.JapaneseEra.values;

public class Bag {
    private ArrayList<Tile> bag;
    public Bag(){
        this.bag = new ArrayList<>();
        for(Tile color : Tile.values()){
            for (int i = 0; i < 20; i++) {
                bag.add(i, color);
            }
        }
        Collections.shuffle(bag);
    }
    private ArrayList<Tile> take(int count){
        return new ArrayList<>();
    }
    public String state(){
        return "str";
    }
}
