package Model;

import Model.Pieces.Piece;

public class BoardSquare implements Square {

  private Piece piece;
  private final Position pos;
  private boolean occupied;

  public BoardSquare(Position pos) {
    this.pos = pos;
    occupied = false;
  }

  @Override
  public boolean isOccupied() {
    return occupied;
  }

  @Override
  public Position getPosition() {
    return pos;
  }

  @Override
  public Piece getPiece() {
    return piece;
  }

  @Override
  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}