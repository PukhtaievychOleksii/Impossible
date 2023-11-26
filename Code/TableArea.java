package Code;

import java.util.ArrayList;

public class TableArea {
    private ArrayList<TyleSource> factoriesOnArea;
    public TableArea(ArrayList<Factory> factories){
        factoriesOnArea = new ArrayList<>();
        for(Factory factory : factories) {
            factoriesOnArea.add(new TyleSource(factory));
        }
    }
    public ArrayList<Tile> take(int sourceId, int idx){
        TyleSource source = factoriesOnArea.get(sourceId);
        ArrayList<Tile> taken = source.take(idx);
        return taken;
    }
    public boolean isRoundEnd(){
        return true;
    }
    public void  startNewRound(){

    }
    public String state() {
        String result = "";
        for(int i = 0; i < factoriesOnArea.size(); i++){
            result += "Factory " + (i+1);
            if (!factoriesOnArea.get(i).isEmpty()){
                result += " contains:";
                ArrayList<Tile> presentTiles = factoriesOnArea.get(i).getSourceTiles();
                for(Tile tile : presentTiles){
                    result += tile.toString() + ",";
                }
            }
            else{
                result += " is Empty";
            }
        }
        return result;
    }
}
