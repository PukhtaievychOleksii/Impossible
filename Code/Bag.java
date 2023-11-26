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
<<<<<<< HEAD
        Collections.shuffle(bag);
    }
=======
        List<Tile> bagList = new ArrayList<>(bag);
        Collections.shuffle(bagList);
        bag = new ArrayDeque<>(bagList);
    }
    /*На 16 строке ты пытаешься перемешать элементы ArrayDeque
     предполагая что оно List, вызывается ошибка ClassCastException.
     Сначала создай лист на основе декью а потом можно будет мешать. я пределала
     проверь 16-18 строчку*/
>>>>>>> 92a18c7af19c401dd156286b18608519446b2c4b
    public ArrayList<Tile> take(int count){
        ArrayList<Tile> taken = new ArrayList<>();
        for(int i = 0; i < count; i++){
            taken.add(bag.pop());
        }
        return taken;
<<<<<<< HEAD
    }
    public int sizeOfBag(){
        return bag.size();
=======

>>>>>>> 92a18c7af19c401dd156286b18608519446b2c4b
    }

    public String state(){
        String result = "Current size of bag:" + bag.capacity();
        for(Tile tile : bag){
            result += tile.toString() + "\n";
        }
        return result;
    }
}