package Model.Pieces;
import Model.Color;


public class Bishop extends AbstractStraightPiece {

  protected Bishop(Color color, String symbol) {
    super(color, symbol,
          new int[]{-1, -1, 1, 1},
          new int[]{-1, 1, -1, 1});
  }

}
