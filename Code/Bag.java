package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Bag {
    private Stack<Tile> bag;

    public Bag(){
        this.bag = new Stack<>();
        for(Tile color : Tile.values()) {
            for (int i = 0; i < 20; i++) {
                bag.push(color);
            }
        }
        Collections.shuffle(bag);
    }
<<<<<<< HEAD
=======

     /*   List<Tile> bagList = new ArrayList<>(bag);
        Collections.shuffle(bagList);
        bag = new ArrayDeque<>(bagList);
    }*/
    /*На 16 строке ты пытаешься перемешать элементы ArrayDeque
     предполагая что оно List, вызывается ошибка ClassCastException.
     Сначала создай лист на основе декью а потом можно будет мешать. я пределала
     проверь 16-18 строчку*/
<<<<<<< HEAD
        >>>>>>> 9f657a6140b680d1667b23546556888cab0b1b07
=======
>>>>>>> 9f657a6140b680d1667b23546556888cab0b1b07
>>>>>>> 330c35b9da70eda6837c26375d7cc3e6c429d9ec
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