package Code;

import java.util.ArrayList;
import java.util.Optional;

public class WallLine {
    private ArrayList<Tile> presentTileTypes;

    public boolean canPutTile(Tile tile){
        return false;
    }

    public Optional<Tile> getTiles(){
        return Optional.empty();
    }
//    public ArrayList<Tile> getTiles(){
//        return null;
//    }


    public Points putTile(Tile tile){
        return new Points(0);
    }

    public String state(){
        return "";
    }
}
