package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PatternLine {
    private int capacity;
    private ArrayList<Tile> presentTiles;
    private Floor floor;
    private WallLine wallLine;
    private UsedTyles usedTyles;

    public PatternLine(int capacity, Floor floor, WallLine relatedWallLine, UsedTyles usedTyles){
        this.capacity = capacity;
        this.floor = floor;
        this.wallLine = relatedWallLine;
        this.usedTyles = usedTyles;
        presentTiles = new ArrayList<>();
        resetLine();
    }

    public void resetLine(){
        for(Tile tile: presentTiles){
            usedTyles.give(new ArrayList<>(Arrays.asList(tile)));
        }
        presentTiles = new ArrayList<>();
    }

    public boolean isLineFull(){
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
            presentTiles.remove(instance);
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

    public boolean isEmpty(){
        return presentTiles.isEmpty();
    }


}
