package Model.Pieces;

import java.util.List;
import java.util.stream.Stream;

import Model.Board;
import Model.Color;
import Model.Position;

public class Queen extends AbstractPiece {

  public Queen(Color color, String symbol) {
    super(color, symbol);
  }

  @Override
  public List<Position> getMoves(Board board, Position pos) {
    Piece rook = new Rook(getColor(), "r");
    Piece bishop = new Rook(getColor(),"b");

    List<Position> straightMoves = rook.getMoves(board, pos);
    List<Position> diagonalMoves = bishop.getMoves(board, pos);

    return Stream.concat(straightMoves.stream(), diagonalMoves.stream()).toList();

  }
}
