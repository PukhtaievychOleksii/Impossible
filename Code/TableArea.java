package Code;

import java.util.ArrayList;

public class TableArea {
    private ArrayList<TyleSource> factoriesOnArea;
    private TableCenter tableCenter;
    public TableArea(int numOfFactories){
        tableCenter = new TableCenter();
        factoriesOnArea = new ArrayList<>();
        int index = 0;
        while(index < numOfFactories){
            factoriesOnArea.add(new TyleSource());
            index++;
        }
    }
    public ArrayList<Tile> take(int sourceId, int idx){
        TyleSource source;
        if(sourceId == 0){
            source = tableCenter;
        }
        else {
          source = factoriesOnArea.get(sourceId - 1);
        }

        return source.take(idx);
    }
    public boolean isRoundEnd(){
        int count = 0;
        for(TyleSource source : factoriesOnArea){
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
    }

