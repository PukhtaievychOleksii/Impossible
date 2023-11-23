package Code;

import java.util.*;

import static java.time.chrono.JapaneseEra.values;

public class Bag {
    private Deque<Tile> bag;
    public Bag(){
        this.bag = new ArrayDeque<>();
        for(Tile color : Tile.values()){
            for (int i = 0; i < 20; i++) {
                bag.push(color);
            }
        }
        Collections.shuffle((List<?>) bag);
    }
<<<<<<< HEAD
    public ArrayList<Tile> take(int count){
        return new ArrayList<>();
=======
    private ArrayList<Tile> take(int count){
        ArrayList<Tile> taken = new ArrayList<>();
        for(int i = 0; i < count; i++){
            taken.add(bag.pop());
        }
        return taken;
>>>>>>> c654542ac3765ee780219f324b43a4a8ae78f9de
    }
    public String state(){
        return "str";
    }
}
