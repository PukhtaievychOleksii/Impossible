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
        List<Tile> bagList = new ArrayList<>(bag);
        Collections.shuffle(bagList);
        bag = new ArrayDeque<>(bagList);
    }
    /*На 16 строке ты пытаешься перемешать элементы ArrayDeque
     предполагая что оно List, вызывается ошибка ClassCastException.
     Сначала создай лист на основе декью а потом можно будет мешать. я пределала
     проверь 16-18 строчку*/
    public ArrayList<Tile> take(int count){
        ArrayList<Tile> taken = new ArrayList<>();
        for(int i = 0; i < count; i++){
            taken.add(bag.pop());
        }
        return taken;

    }

    public String state(){
        return "str";
    }
}