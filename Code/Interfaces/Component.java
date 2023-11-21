package Code.Interfaces;

import Code.Points;
import Code.Tile;

import java.util.ArrayList;

public interface Component {

    Points getPoints(ArrayList<ArrayList<Tile>> records);
}
