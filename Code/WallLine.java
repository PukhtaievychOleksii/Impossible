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

    public Optional<WallLine> getUpWall(){ return upWall;}

    public Optional<WallLine> getDownWall(){ return downWall;}

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
        //go right wall
        int walker = index + 1;
        while(walker < presentTiles.size()){
            if(presentTiles.get(walker).isPresent()) horSeq++;
            else break;
            walker++;
        }
        //go left wall
        walker = index - 1;
        while(walker > 0){
            if(presentTiles.get(walker).isPresent()) horSeq++;
            else break;
            walker--;
        }

        int vertSeq = 1;
        vertSeq += goUpWall(index, upWall);
        vertSeq += goDownWall(index, downWall);


        if(horSeq == 1 && vertSeq == 1) points = 1;
        else points = horSeq + vertSeq;

        return new Points(points);
    }

    private int goUpWall(int index, Optional<WallLine> upWall){
        if(upWall.isPresent() && upWall.get().getTiles().get(index).isPresent()) return 1 + goUpWall(index, upWall.get().getUpWall());
        return 0;
    }

    private int goDownWall(int index, Optional<WallLine> downWall){
        if(downWall.isPresent() && downWall.get().getTiles().get(index).isPresent()) return 1 + goDownWall(index, downWall.get().getDownWall());
        return 0;
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