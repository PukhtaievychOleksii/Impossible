package Code;

import java.util.ArrayList;
import java.util.Collections;

public class PatternLine {
    private int capacity;
    private ArrayList<Tile> presentTiles;
    private Floor floor;
    private WallLine wallLine;

    public PatternLine(int capacity, Floor floor, WallLine relatedWallLine){
        this.capacity = capacity;
        this.floor = floor;
        this.wallLine = relatedWallLine;
        resetLine();
    }

    private void resetLine(){
        presentTiles = new ArrayList<>();
    }

    private boolean isLineFull(){
        return presentTiles.size() == capacity;
    }

    private boolean areTilesOfTheSameType(ArrayList<Tile> tiles){
        Tile startTile = tiles.get(0);
        for(Tile tile : tiles){
            if(tile != startTile) return false;
        }
        return true;
    }

    public void put(ArrayList<Tile> tiles){
        Tile instance = tiles.get(0);
        if(!areTilesOfTheSameType(tiles) || !wallLine.canPutTile(instance)) return;
        for(Tile tile : tiles){
            if(presentTiles.size() < capacity) presentTiles.add(tile);
            else floor.put(Collections.singleton(tile));
        }
    }

    public Points finishRound(){
        Points points = new Points(0);
        if(isLineFull()){
            Tile instance = presentTiles.get(0);
            points = wallLine.putTile(instance);
            resetLine();
        }
        return points;
    }

    public String state(){
        String toReturn = "";
        for (Tile tile : presentTiles) {
            if(tile == null) toReturn += "N";
            else toReturn += tile.toString();
        }
        return toReturn;
    }


}
