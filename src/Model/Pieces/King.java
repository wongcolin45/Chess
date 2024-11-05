package Model.Pieces;

import java.util.ArrayList;
import java.util.List;

import Model.Board;
import Model.Color;
import Model.Position;

public class King extends AbstractPiece {

  private final int[] rowIters = {-1, -1, -1, 0, 0 , 1, 1, 1};
  private final int[] colIters = {-1, 0, 1, -1, 1 , -1, 0, 1};

  protected King(Color color, String symbol) {
    super(color, symbol);
  }



  @Override
  public List<Position> getMoves(Board board, Position pos) {
    List<Position> moves = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      checkValidMove(board, moves, pos,pos.getRow() + rowIters[i], pos.getCol() + colIters[i]);
    }

    return moves;
  }
}
