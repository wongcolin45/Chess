package Model.Pieces;
import Model.Board;
import Model.ChessBoard;
import Model.Color;
import Model.Position;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class PawnTest {

  private Board board;


  @Before
  public void init() {
    board = new ChessBoard();
  }

  @Test
  public void testWhitePawnFirstMoves() {
    Piece pawn = new Pawn(Color.WHITE, "P");
    Position pos = new Position("e2");
    List<Position> moves = pawn.getMoves(board, pos);

    Assert.assertEquals(2, moves.size());

    Position forward1 = new Position("e3");
    Position forward2 = new Position("e4");

    Assert.assertTrue(moves.contains(forward1));
    Assert.assertTrue(moves.contains(forward2));
  }

  @Test
  public void testBlackPawnFirstMoves() {
    Piece pawn = new Pawn(Color.BLACK, "p");
    Position pos = new Position("d7");

    List<Position> moves = pawn.getMoves(board, pos);

    Assert.assertEquals(2, moves.size());

    Position forward1 = new Position("d6");
    Position forward2 = new Position("d5");

    Assert.assertTrue(moves.contains(forward1));
    Assert.assertTrue(moves.contains(forward2));
  }

  @Test
  public void testWhitePawnSecondMove() {
    Piece pawn = new Pawn(Color.WHITE, "P");
    Position pos = new Position("f6");

    List<Position> moves = pawn.getMoves(board, pos);
    Assert.assertEquals(1, moves.size());
    Position forward1 = new Position("f7");
    Assert.assertTrue(moves.contains(forward1));
  }

  @Test
  public void testBlackPawnSecondMove() {
    Piece pawn = new Pawn(Color.BLACK, "p");
    Position pos = new Position("d5");

    List<Position> moves = pawn.getMoves(board, pos);
    Assert.assertEquals(1, moves.size());
    Position forward1 = new Position("d4");
    Assert.assertTrue(moves.contains(forward1));
  }



}