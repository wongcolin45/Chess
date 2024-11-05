package Model.Pieces;

import java.util.List;

import Model.Board;
import Model.Color;
import Model.Position;

/**
 * This represents a piece the board.
 * It does one thing, given the board and its position get the pieces possible moves.
 */
public interface Piece {

  /**
   * This gets the list of all the pieces possible moves.
   * @param board the board to use
   * @param pos the position of the piece
   * @return the list of positions the piece can move to
   */
  List<Position> getMoves(Board board, Position pos);

  /**
   * Gets the color of the piece.
   * @return the color
   */
  Color getColor();


}
