package Model.Pieces;

import java.util.List;

import Model.Board;
import Model.Color;
import Model.Position;

public class King extends AbstractPiece {

  protected King(Color color, String symbol) {
    super(color, symbol);
  }

  @Override
  public List<Position> getMoves(Board board, Position pos) {
    return null;
  }
}
