package Code.Interfaces;

import Code.Points;
import Code.Tile;

import java.util.ArrayList;
import java.util.Optional;

public interface Component {

    Points getPoints(ArrayList<ArrayList<Optional<Tile>>> records);
}
