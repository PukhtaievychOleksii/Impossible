package Code;

import java.util.ArrayList;
import java.util.Optional;

public class WallLine {
    private ArrayList<Tile> tileTypesSequence;
    private ArrayList<Optional<Tile>> presentTiles;
    private WallLine upWall;
    private WallLine downWall;

    public WallLine(ArrayList<Tile> tileTypesSequence){
        this.tileTypesSequence = tileTypesSequence;
        presentTiles = new ArrayList<>();
        for(int i = 0; i < tileTypesSequence.size(); i++){
            presentTiles.add(Optional.empty());
        }
    }

    public void setUpWall(WallLine upWall){
        this.upWall = upWall;
    }

    public void setDownWall(WallLine downWall){
        this.downWall = downWall;
    }

    public boolean canPutTile(Tile tile){
        boolean ans = true;
        for(Optional<Tile> oTile : presentTiles){
            if(oTile.isPresent() && oTile.get() == tile) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public ArrayList<Optional<Tile>> getTiles(){
        return presentTiles;
    }

    public Points putTile(Tile tile){
        //TODO: Points calculation
        Points points = new Points(0);

        int index = 0;
        for(int i = 0; i < tileTypesSequence.size(); i++){
            if(tile == tileTypesSequence.get(i)){
                index = i;
                break;
            }
        }
        presentTiles.set(index, Optional.of(tile));

        return points;
    }

    public String state(){
        String toReturn = "";
        for (Optional<Tile> oTile: presentTiles) {
            if(!oTile.isPresent()) toReturn += "N";
            else toReturn += oTile.get().toString();
        }
        return toReturn;
    }
}