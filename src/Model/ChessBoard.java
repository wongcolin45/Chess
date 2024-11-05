package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Pieces.ChessPieceFactory;
import Model.Pieces.Piece;
import Model.Pieces.PieceType;

public class ChessBoard implements Board {

  private final Square[][] grid;
  private Color turn;

  private Square selectedSquare;

  public ChessBoard() {
    grid = new Square[8][8];
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        Position pos = new Position(r, c);
        grid[r][c] = new BoardSquare(pos);
      }
    }
    //setBoard();
    turn = Color.WHITE;
  }


  @Override
  public void setPieces() {
    setSide(Color.WHITE);
    setSide(Color.BLACK);
  }


  private void placePiece(Color color, PieceType type, int r, int c) {
    Square current = grid[r][c];
    Piece piece = ChessPieceFactory.buildPiece(color, type);
    current.setPiece(piece);
  }

  private void setSide(Color color) {
    int r = (color == Color.WHITE) ? 6 : 1;
    for (int c = 0; c < 8; c++) {
      placePiece(color, PieceType.PAWN, r, c);
    }
    r = (r == 6) ? r + 1 : r - 1;
    for (int c = 0; c <= 7; c += 7) {
      placePiece(color, PieceType.ROOK, r, c);
    }
    for (int c = 1; c <= 6; c += 5) {
      placePiece(color, PieceType.KNIGHT, r, c);
    }
    for (int c = 2; c <= 5; c += 3) {
      placePiece(color, PieceType.BISHOP, r, c);
    }
    placePiece(color, PieceType.QUEEN, r, 3);
    placePiece(color, PieceType.KING, r, 4);
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
  public void selectedPiece(Position pos) {
    Square current = getSquare(pos);
    if (current.isOccupied() && current.getPiece().getColor() != turn) {
      throw new IllegalArgumentException("You are not allowed to move " + turn.opposing().toString() + "'s pieces!");
    }
    if (!current.isOccupied()) {
      throw new IllegalArgumentException("There is not piece on "+pos + "!");
    }
    if (current.getPiece().getMoves(this, pos).isEmpty()) {
      throw new IllegalArgumentException("This piece has no valid moves!");
    }
    selectedSquare = getSquare(pos);
  }

  @Override
  public void unselectedPiece() {
    selectedSquare = null;
  }

  @Override
  public void movePiece(Position pos) {
    if (selectedSquare == null) {
      throw new IllegalStateException("You need to select a piece before you can move!");
    }
    if (!getPossibleMoves().contains(pos)) {
      throw new IllegalArgumentException(pos + " is not a valid move!");
    }
    Square current = getSquare(pos);
    current.setPiece(selectedSquare.getPiece());
    selectedSquare.clear();
    selectedSquare = null;
    turn = turn.opposing();
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
  public String[][] getTextGrid() {
    String[][] textGrid = new String[8][8];
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        Square current = grid[r][c];
        textGrid[r][c] = current.toString();
      }
    }
    return textGrid;
  }

  @Override
  public List<Position> getPossibleMoves() {
    if (selectedSquare == null) {
      return new ArrayList<>();
    }
    Piece piece = selectedSquare.getPiece();
    return piece.getMoves(this, selectedSquare.getPosition());
  }
}
