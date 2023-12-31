
package Code.Source;

import Code.Interfaces.GameInterface;

import java.util.ArrayList;

public class Game implements GameInterface {
    private GameObserver gameObserver;
    private Bag bag;
    private TableArea tableArea;
    private ArrayList<Board> playerBoards;
    private String[] playerNames;
    private static final String[] defaultPlayerNames = {"Player 1", "Player 2", "Player 3", "Player 4"};
    private static final int[] amountOfFactories = {-1, -1, 5, 7, 9};

<<<<<<< HEAD:Code/Source/Game.java
<<<<<<< HEAD:Code/Source/Game.java
    public Game() {
        this(4, defaultPlayerNames);
=======
    public Game(int numOfplayers) {
        this(numOfplayers, defaultNames);
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/Game.java
=======
    public Game(int numOfplayers) {
        this(numOfplayers, defaultNames);
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/Game.java
    }

    public Game(int numberOfPlayers, String[] playerNames) {
        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            throw new IllegalArgumentException("Number of players must be 2-4.");
        }
        if (playerNames.length != numberOfPlayers) {
            throw new IllegalArgumentException("Not enough/Too many names for the given number of players");
        }
        this.playerNames = playerNames;
        this.bag = new Bag();
        int numOfFactories = amountOfFactories[numberOfPlayers];
        this.tableArea = new TableArea(numOfFactories, bag);
        this.playerBoards = new ArrayList<Board>();
        for (int i = 0; i < numberOfPlayers; i++) {
            playerBoards.add(i, new Board(bag.getUsedTiles()));
        }
        gameObserver = new GameObserver();

        startNewRound();
    }


    @Override
    public boolean take(int playerId, int sourceId, int idx, int destinationIdx) {
        if(playerId < 0 || playerId >= playerBoards.size()){
            throw new IllegalArgumentException("No such player found");
        }


        // make a move
        Board playerBoard = playerBoards.get(playerId);
        ArrayList<Tile> takenTiles = tableArea.take(sourceId,idx);
        if(takenTiles.isEmpty()) return false;
        if(playerBoard.destinationExists(destinationIdx)){
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
           startNewRound();
        }
    }

    public void startNewRound(){
        boolean isGameOver = false;
        tableArea.startNewRound();
        for(Board playerBoard: playerBoards){
            FinishRoundResult roundResult = playerBoard.finishRound();
            if(roundResult.equals(FinishRoundResult.GAME_FINISHED)) isGameOver = true;
        }

<<<<<<< HEAD:Code/Source/Game.java
        if(isGameOver) endGame();
    }

=======
>>>>>>> parent of d6a0ebd (GameIntegrationTestUpdate):Code/Game.java
    private void endGame() {
        gameObserver.notifyEverybody("Game is finished!");

        String winnerName = "";
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


    public ArrayList<Board> getBoards(){return playerBoards;}

    public TableArea getTableArea(){
        return tableArea;
    }

    public Bag getBag(){
        return bag;
    }

    public void setGameObserver(GameObserver gameObserver){
        this.gameObserver = gameObserver;
    }

}
