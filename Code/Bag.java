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
<<<<<<< HEAD



=======
<<<<<<< HEAD
>>>>>>> d893639a03e6eb94f43cc647a39e2ff52f313b28
     /*   List<Tile> bagList = new ArrayList<>(bag);
        Collections.shuffle(bagList);
        bag = new ArrayDeque<>(bagList);
    }*/
    /*На 16 строке ты пытаешься перемешать элементы ArrayDeque
     предполагая что оно List, вызывается ошибка ClassCastException.
     Сначала создай лист на основе декью а потом можно будет мешать. я пределала
     проверь 16-18 строчку*/
<<<<<<< HEAD
=======
=======

>>>>>>> b834ed97e2681dff99ed1e5e4ccff5423557986e
>>>>>>> f955a926cef94962dba504a3141a40aff7e4eab3
>>>>>>> d893639a03e6eb94f43cc647a39e2ff52f313b28
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