package Code;

import java.util.ArrayList;

public class TableArea {
    private ArrayList<TyleSource> factoriesOnArea;
    public TableArea(Bag bag){
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
        int count = 0;
        for(TyleSource source : factoriesOnArea){
            if (source.isEmpty()){
                count ++;
            }
        }
        return count == 5;
    }
    public void startNewRound(){
        if(isRoundEnd()){

        }
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

