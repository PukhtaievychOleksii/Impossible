package Code;

import java.util.ArrayList;

public class PatternLine {
    private int capacity;
    private ArrayList<Tile> presentTiles;
    private Floor floor;
    private WallLine wallLine;

    public PatternLine(int capacity, Floor floor, WallLine relatedWallLine){
        this.capacity = capacity;
        this.floor = floor;
        this.wallLine = relatedWallLine;

    }

    private void resetLine(){
        ArrayList<Tile> newLine = new ArrayList<>();
        for(int i = 0; i < capacity; i++){
            newLine.add(null);
        }
        presentTiles = newLine;
    }

    private boolean isLineFull(){
        boolean ans = true;
        for(Tile tile : presentTiles){
            if(tile == null) {
                ans = false;
                break;
            }
        }
        return ans;
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

        int startIndex = 0;
        for(Tile tile: presentTiles) {
            if(tile != null) startIndex++;
        }
        for(int i = startIndex; i < tiles.size(); i++){
            if(i < presentTiles.size()){
                presentTiles.set(i, tiles.get(i));
            } else {
                floor.put(tiles.subList(i, i + 1));
            }
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
