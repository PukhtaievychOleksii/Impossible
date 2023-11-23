package Code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class WallLine {
    private ArrayList<Tile> tileTypesSequence;
    private ArrayList<Optional<Tile>> presentTiles;
    private Optional<WallLine> upWall;
    private Optional<WallLine> downWall;

    public WallLine(ArrayList<Tile> tileTypesSequence){
        this.tileTypesSequence = tileTypesSequence;
        presentTiles = new ArrayList<>();
        for(int i = 0; i < tileTypesSequence.size(); i++){
            presentTiles.add(Optional.empty());
        }
        upWall = Optional.empty();
        downWall = Optional.empty();
    }

    public void setUpWall(WallLine upWall){
        this.upWall = Optional.of(upWall);
    }

    public void setDownWall(WallLine downWall){
        this.downWall = Optional.of(downWall);
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
        int points = 0;
        //put
        int index = 0;
        for(int i = 0; i < tileTypesSequence.size(); i++){
            if(tile == tileTypesSequence.get(i)){
                index = i;
                break;
            }
        }
        presentTiles.set(index, Optional.of(tile));
        //count
        int horSeq = 1;
        int vertSeq = 1;
        if(index - 1 >= 0 && !presentTiles.get(index - 1).isEmpty()) horSeq++;
        if(index + 1 < presentTiles.size() && !presentTiles.get(index + 1).isEmpty()) horSeq++;
        if(upWall.isPresent()){
            ArrayList<Optional<Tile>> upLine = upWall.get().getTiles();
            if(upLine.get(index).isPresent()) vertSeq++;
        }
        if(downWall.isPresent()){
            ArrayList<Optional<Tile>> downLine = downWall.get().getTiles();
            if(downLine.get(index).isPresent()) vertSeq++;
        }

        if(horSeq == 1 && vertSeq == 1) points = 1;
        //TODO: FIX Points calculation to full

        return new Points(points);
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
