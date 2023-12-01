package Code;

import java.util.ArrayList;

public class TableArea {
    private ArrayList<Factory> factoriesOnArea;
    public TableCenter tableCenter;

    public TableArea(int numOfFactories, Bag bag){
        tableCenter = new TableCenter();
        factoriesOnArea = new ArrayList<>();
        int index = 0;
        while(index < numOfFactories){
            factoriesOnArea.add(new Factory(bag, tableCenter));
            index++;
        }
    }

    public TableArea(ArrayList<ArrayList<Tile>> factories){
        this.tableCenter = new TableCenter();
        factoriesOnArea = new ArrayList<>();
        for(ArrayList<Tile> tiles : factories){
            factoriesOnArea.add(new Factory(tiles, tableCenter));
        }

    }
    public ArrayList<Tile> take(int sourceId, int idx){
        if(!sourceExists(sourceId, idx)) return new ArrayList<>();
        TyleSource source = getTyleSource(sourceId);
        return source.take(idx);
    }
    public boolean isRoundEnd(){
        int count = 0;
        for(Factory source : factoriesOnArea){
            if (source.isEmpty()){
                count ++;
            }
        }
        return count == factoriesOnArea.size() && tableCenter.isEmpty();
    }
    public void startNewRound(){
        for(TyleSource source : factoriesOnArea){
            source.startNewRound();
        }
        tableCenter.startNewRound();
    }
    private boolean sourceExists(int sourceId,int idx){
        if(sourceId < 0 || sourceId > factoriesOnArea.size()) return false;
        TyleSource tyleSource = getTyleSource(sourceId);
        if(idx < 0 || idx >= tyleSource.getSourceTiles().size()) return false;
        return true;
    }
    public String state() {
        String result = "";
        for (int i = 0; i < factoriesOnArea.size(); i++) {
            result += "Factory " + (i + 1);
            if (!factoriesOnArea.get(i).isEmpty()) {
                result += factoriesOnArea.get(i).state();
            } else {
                result += " is Empty";
            }
        }
        return result;
    }
    private TyleSource getTyleSource(int sourceId){
        TyleSource source;
        if(sourceId == 0){
            source = tableCenter;
        }
        else {
            source = factoriesOnArea.get(sourceId - 1);
        }

        return source;
    }
}