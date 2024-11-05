package Model.Pieces;
import Model.Color;


/**
 * This is the implementation of a rook.
 */
public class Rook extends AbstractStraightPiece {

  /**
   * Initializes the color and sends over iters values for up, down, left right.
   * @param color the rook's color
   */
  protected Rook(Color color, String symbol) {
    super(color, symbol,
          new int[]{-1, 1, 0, 0},
          new int[]{0, 0, -1, 1});
  }

}
