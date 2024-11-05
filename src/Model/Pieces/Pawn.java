package Model.Pieces;

import java.util.ArrayList;
import java.util.List;

import Model.Board;
import Model.Color;
import Model.Position;

/**
 * This is the implementation of a pawn.
 */
public class Pawn extends AbstractPiece {

  private final int forward;

  private final String symbol;

  /**
   * Initializes the color and which direction is forward for the pawn.
   * @param color the color of the pawn
   */
  public Pawn(Color color, String symbol) {
    super(color, symbol);
    if (color == Color.WHITE) {
      this.forward = -1;
      this.symbol = "♟";
    } else {
      this.forward = 1;
      this.symbol = "♙";
    }

  }

  protected void checkOpenMove(Board board, List<Position> moves, Position pos, int r, int c) {
    Position check = new Position(r, c);
    if (onBoard(r,c) && board.isEmpty(check)) {
      moves.add(check);
    }
  }

  protected void checkCapture(Board board, List<Position> moves, Position pos,  int r, int c) {
    Position check = new Position(r, c);
    if (onBoard(r, c) && !board.isEmpty(pos) && board.getPiece(pos).getColor() == color.opposing()) {
      moves.add(check);
    }
  }

  @Override
  public List<Position> getMoves(Board board, Position pos) {
    List<Position> moves = new ArrayList<>();

    int r = pos.getRow();
    int c = pos.getCol();

    Position check;

    // Check first move
    if ((color == Color.WHITE && r == 6) || (color == Color.BLACK && r == 1)) {
      checkOpenMove(board, moves, pos, r + 2 * forward, c);
    }
    // Check moving forward
    checkOpenMove(board, moves, pos, r + forward, c);
    // Check diagonal captures
    for (int i = -1; i <= 1; i += 2) {
      checkCapture(board, moves, pos, r + forward, c + i);
    }
    return moves;
  }

  @Override
  public String toString() {
    return symbol;
  }


}
