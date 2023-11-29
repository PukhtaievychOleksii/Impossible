
package Code;

import Code.Interfaces.GameInterface;

import java.util.ArrayList;

public class Game implements GameInterface {

    private Bag bag;
    private ArrayList<Board> playerBoards;
    private String[] playerNames;
    private TableArea tableArea;
    private GameObserver gameObserver;
    private int curPlayer;
    private static final String[] defaultNames = {"Player 1", "Player 2", "Player 3", "Player 4"};
    private static final int[] factoriesCount = {-1, -1, 5, 7, 9};

    public Game(int numOfplayers) {
        this(numOfplayers, defaultNames);
    }

    public Game(int numOfPlayers, String[] playerNames) {
        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new IllegalArgumentException("Number of players must be 2-4.");
        }
        if (playerNames.length != numOfPlayers) {
            throw new IllegalArgumentException("Not enough/Too many names for the given number of players");
        }
        this.playerNames = playerNames;
        curPlayer = (int) (Math.random() * numOfPlayers);
        this.bag = new Bag();
        int numOfFactories = factoriesCount[numOfPlayers];
        this.tableArea = new TableArea(numOfFactories, bag);
        this.playerBoards = new ArrayList<Board>();
        for (int i = 0; i < numOfPlayers; i++) {
            playerBoards.add(i, new Board(bag.getUsedTiles()));
        }
        gameObserver = new GameObserver();

    }


    public int getCurrentPLayer() {
        return curPlayer;
    }

    public void setGameObserver(GameObserver gameObserver){
        this.gameObserver = gameObserver;
    }

    @Override
    public boolean take(int playerId, int sourceId, int idx, int destinationIdx) {
        if(playerId < 0 || playerId >= playerBoards.size()){
            throw new IllegalArgumentException("No such player found");
        }
        if(!tableArea.sourceExists(sourceId, idx)){
            return false;
        }

        // make a move
        Board playerBoard = playerBoards.get(playerId);
        ArrayList<Tile> takenTiles = tableArea.take(sourceId,idx);
        if(playerBoard.destinationExists(playerId)){
            playerBoard.put(destinationIdx, takenTiles);
        } else{
            playerBoard.getFloor().put(takenTiles);
        }

        //restart round if needed
        manageRounds();
        return true;
    }

    private void manageRounds(){
        if(tableArea.isRoundEnd()){
            boolean isGameOver = false;
            tableArea.startNewRound();
            for(Board playerBoard: playerBoards){
                FinishRoundResult roundResult = playerBoard.finishRound();
                if(roundResult.equals(FinishRoundResult.GAME_FINISHED)) isGameOver = true;
            }

            if(isGameOver) endGame();
        }
    }


    private void endGame() {
        gameObserver.notifyEverybody("Game is finished!");

        String winnerName = "nobody";
        int winnerPoints = 0;
        for (int i = 0; i < playerBoards.size(); i++) {
            Board playerBoard = playerBoards.get(i);
            playerBoard.endGame();
            if (playerBoard.points.getValue() > winnerPoints) {
                winnerPoints = playerBoard.points.getValue();
                winnerName = playerNames[i];
            }
            gameObserver.notifyEverybody(playerNames[i] + "'s score is: " + playerBoard.points.getValue() + ".");

        }
        gameObserver.notifyEverybody("Winner is " + winnerName + "! Winner's score is : " + winnerPoints + ".");
    }
}
