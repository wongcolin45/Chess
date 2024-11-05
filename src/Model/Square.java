package Model;

import Model.Pieces.Piece;

/**
 * This represents a square on the chess board.
 */
public interface Square {

  /**
   * Tells whether this square is occupied.
   * @return true if piece is here, otherwise false
   */
  boolean isOccupied();

  /**
   * Gets the position of the square.
   * @return the position
   */
  Position getPosition();

  /**
   * Gets the piece on this square
   * @return the piece
   */
  Piece getPiece();

  /**
   * This set the piece on this square.
   * @param piece the put on this square
   */
  void setPiece(Piece piece);

  /**
   * Removes the piece from the square.
   */
  void clear();
}
