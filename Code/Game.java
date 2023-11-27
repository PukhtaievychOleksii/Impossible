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

    private TableArea tableArea;

    private static final String[] defaultNames = {"Player 1", "Player 2", "Player 3", "Player 4"};
    private static final int[] factoryCount = {-1, -1, 5, 7, 9};

    public Game(int numOfplayers) {
        this(numOfplayers, defaultNames);
    }

    public Game(int numOfPlayers, String[] nameOfPlayers) {
        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new IllegalArgumentException("Number of players must be 2-4.");
        }
        if (nameOfPlayers.length < numOfPlayers) {
            throw new IllegalArgumentException("Not enough names for the given number of players");
        }

        this.numOfPlayers = numOfPlayers;
        this.winner = "none";
        this.playerBoards = new ArrayList<Board>();
        this.bag = new Bag();
        this.factories = new ArrayList<>();
<<<<<<< HEAD
        this.observers = new ArrayList<>();
<<<<<<< HEAD
//        this.tableArea = new TableArea();
=======
        //this.tableArea = new TableArea();
=======
<<<<<<< HEAD
        this.tableArea = new TableArea();
=======
        this.observers = new ArrayList<>();
        //this.tableArea = new TableArea();
>>>>>>> 87266292d4aeea80ab0b70dc586b6e855905476d
>>>>>>> b834ed97e2681dff99ed1e5e4ccff5423557986e
>>>>>>> f955a926cef94962dba504a3141a40aff7e4eab3

        curPlayer = (int) (Math.random() * numOfPlayers);

        for (int i = 0; i < numOfPlayers; i++) {
            playerBoards.add(i, new Board());
        }
        int numOfFactories = factoryCount[numOfPlayers];
        for(int i = 0; i < numOfFactories; i++){
            factories.add(new Factory(bag));
        }
        for (int i = 0; i < numOfFactories; i++) {
<<<<<<< HEAD
            factories.add(new Factory(bag));
        }

=======
           // factories.add(new Factory());
        }

=======
        for (int i = 0; i < numOfFactories; i++) {
            factories.add(new Factory(bag));
        }
>>>>>>> b834ed97e2681dff99ed1e5e4ccff5423557986e
>>>>>>> f955a926cef94962dba504a3141a40aff7e4eab3
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
