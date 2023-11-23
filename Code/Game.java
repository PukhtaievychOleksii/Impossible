package Code;

import Code.Interfaces.GameInterface;

import java.util.ArrayList;

public class Game implements GameInterface {
    private int numOfPlayers;
    private int curPlayer;
    private Bag bag;
    private ArrayList<Board> playerBoards;
    private String winner;
    private ArrayList<Factory> factories;

    private static final String[] defaultNames = { "Player 1", "Player 2", "Player 3", "Player 4" };
    private static final int[] factoryCount = { -1, -1, 5, 7, 9 };

    public Game(int numOfplayers){
        this(numOfplayers, defaultNames);
    }
    public Game(int numOfPlayers, String[] nameOfPlayers){
        if(numOfPlayers < 2 || numOfPlayers > 4){
            throw new IllegalArgumentException("Number of players must be 2-4.");
        }
        if(nameOfPlayers.length < numOfPlayers){
            throw new IllegalArgumentException("Not enough names for the given number of players");
        }

        this.numOfPlayers = numOfPlayers;
        this.winner = "none";
        this.playerBoards = new ArrayList<Board>();
        this.bag = new Bag();
        this.factories = new ArrayList<>();

        curPlayer = (int) (Math.random() * numOfPlayers);

        for (int i = 0; i < numOfPlayers; i++){
            playerBoards.add(i, new Board());
        }
        int numOfFactories = factoryCount[numOfPlayers];
        for(int i = 0; i < numOfFactories; i++){
            factories.add(new Factory());
        }



    }
    public int getCurrentPLayer(){
        return curPlayer;
    }

    @Override
    public boolean take(int playerId, int sourceId, int idx, int destinationIdx) {
        return false;
    }
}
