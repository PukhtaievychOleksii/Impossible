package Code.Interfaces;

import Code.Source.Points;
import Code.Source.Tile;

import java.util.ArrayList;
import java.util.Optional;

public interface Component {


    Points getPoints(ArrayList<ArrayList<Optional<Tile>>> records);
}