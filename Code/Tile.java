package Code;

import java.util.Random;

public enum Tile {
    STARTING_PLAYER,
    RED,
    GREEN,
    YELLOW,
    BLUE,
    BLACK;

    @Override
    public String toString() {
        switch (this) {
            case STARTING_PLAYER:
                return "S";
            case RED:
                return "R";
            case GREEN:
                return "G";
            case YELLOW:
                return "I";
            case BLUE:
                return "B";
            case BLACK:
                return "L";
            default:
                return null;
        }
    }

    private static final Random rand = new Random();

    public static Tile randomTile()  {
        Tile[] tiles = {Tile.RED, Tile.GREEN,Tile.BLUE, Tile.BLACK, Tile.YELLOW};
        return tiles[rand.nextInt(tiles.length)];
    }
}
