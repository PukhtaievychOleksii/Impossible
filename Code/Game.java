package Code;

import Code.Interfaces.GameInterface;

import java.util.ArrayList;
import java.util.Optional;

public class Game implements GameInterface {
    private int numOfPlayers;
    private int curPlayer;
    private Bag bag;
    private ArrayList<Board> playerBoards;
    private TableArea tableArea;
    private Optional<GameObserver> gameObserver;
    //private String winner;


    private static final String[] defaultNames = {"Player 1", "Player 2", "Player 3", "Player 4"};
    private static final int[] factoryCount = {-1, -1, 5, 7, 9};

    public Game(int numOfplayers) {
        this(numOfplayers, defaultNames);
    }

    public Game(int numOfPlayers, String[] nameOfPlayers) {
        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new IllegalArgumentException("Number of players must be 2-4.");
        }
        if (nameOfPlayers.length != numOfPlayers) {
            throw new IllegalArgumentException("NotEnough/TooMany names for the given number of players");
        }

        this.numOfPlayers = numOfPlayers;
        bag = new Bag();
        playerBoards = new ArrayList<Board>();
        gameObserver = Optional.empty();

        int numOfFactories = factoryCount[numOfPlayers];
        tableArea = new TableArea(numOfFactories);


        curPlayer = (int) (Math.random() * numOfPlayers);
        //create boards
        for (int i = 0; i < numOfPlayers; i++) {
            playerBoards.add(i, new Board());
        }

    }

    public void SetGameObserver(GameObserver gameObserver){
        this.gameObserver = Optional.of(gameObserver);
    }

    public int getCurrentPLayer() {
        return curPlayer;
    }

    @Override
    public boolean take(int playerId, int sourceId, int idx, int destinationIdx) {
        return false;
    }

    private void endRound() {
        boolean gameFinished = false;
        for (Board board : playerBoards) {
            if (board.finishRound() == FinishRoundResult.GAME_FINISHED) {
                gameFinished = true;
                break;
            }
        }
        if (gameFinished) {
            endGame();
        }
    }

    private void endGame() {
        GameObserver gameObserver = new GameObserver();
        gameObserver.notifyEverybody("Game is finished!");

        Points winnerPoints = new Points(0);
        for (int i = 0; i < playerBoards.size(); i++) {
            playerBoards.get(i).endGame();
            if (winnerPoints.getValue() < playerBoards.get(i).points.getValue()) {
                winnerPoints = new Points(playerBoards.get(i).points.getValue());
                winner = defaultNames[i];
            }
            gameObserver.notifyEverybody(defaultNames[i] + "'s score is: " + playerBoards.get(i).points.getValue() + ".");

        }
        gameObserver.notifyEverybody("Winner is " + winner + "! Winner's score is : " + winnerPoints.getValue() + ".");
    }
}
