package Model;

import Model.Pieces.Piece;

/**
 * This represents a chess board.
 */
public interface Board extends ViewableBoard {

  /**
   * Sets the pieces on the board
   */
  void setPieces();

  /**
   * Checks is position is empty;
   * @param pos the position to check
   * @return true if empty, otherwise false
   */
  boolean isEmpty(Position pos);

  /**
   * Gets the piece at the position.
   * @param pos the position to check
   * @return the piece on that position
   * @throws IllegalStateException if there is no piece there
   */
  Piece getPiece(Position pos);



  /**
   * Sets the selected piece on the board.
   * @param pos the position of the piece
   * @throws IllegalArgumentException there is no piece at the position / it is an opposing players piece
   */
  void selectedPiece(Position pos);

  /**
   * Unselects the current piece.
   */
  void unselectedPiece();

  /**
   * This moves the piece to the given position.
   * @param pos the position to move too
   * @throws IllegalArgumentException if the position is not a valid move for the piece
   * @throws IllegalStateException if no piece has been selected
   */
  void movePiece(Position pos);


  /**
   * Tells whether game is over.
   * @return true if checkmate or draw, otherwise false
   */
  boolean isGameOver();

  /**
   * Gets the results of the game.
   * @return the result, either checkmate for white/black or stalemate
   * @throws IllegalStateException if the game is not over
   */
  GameResult getGameResult();




}
