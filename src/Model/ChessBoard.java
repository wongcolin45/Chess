package Model;

import Model.Pieces.Piece;

public class ChessBoard implements Board {

  private final Square[][] grid;
  private Color turn;

  private Piece selectedPiece;

  public ChessBoard() {
    grid = new Square[8][8];
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        Position pos = new Position(r, c);
        grid[r][c] = new BoardSquare(pos);
      }
    }

    turn = Color.WHITE;
  }


  private Square getSquare(Position pos) {
    return grid[pos.getRow()][pos.getCol()];
  }

  @Override
  public boolean isEmpty(Position pos) {
    return !getSquare(pos).isOccupied();
  }

  @Override
  public Piece getPiece(Position pos) {
    if (isEmpty(pos)) {
      throw new IllegalArgumentException("There is not piece here");
    }
    return this.getSquare(pos).getPiece();
  }

  @Override
  public boolean isValidPieceSelection(Position pos) {
    Square current = getSquare(pos);
    return (current.isOccupied() && current.getPiece().getColor() == turn);
  }


  @Override
  public void selectedPiece(Position pos) {
    if (!isValidPieceSelection(pos)) {
      throw new IllegalArgumentException("This square is empty or is an opposing piece");
    }
    selectedPiece = getSquare(pos).getPiece();
  }

  @Override
  public void movePiece(Position pos) {
    if (selectedPiece == null) {
      throw new IllegalStateException("You need to select a piece before you can move!");
    }

  }

  @Override
  public Color getTurn() {
    return turn;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public GameResult getGameResult() {
    return null;
  }

  @Override
  public String[][] getGridString() {
    String[][] grid = new String[8][8];
    return grid;
  }
}
