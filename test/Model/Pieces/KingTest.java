package Model.Pieces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Model.Board;
import Model.ChessBoard;
import Model.Color;
import Model.Position;

import static org.junit.Assert.*;

public class KingTest {

  private Board board;

  @Before
  public void init() {
    board = new ChessBoard();
  }

  @Test
  public void testKingInCenter() {
    Piece king = new King(Color.WHITE, "K");
    Position start = new Position("e4");
    List<Position> moves = king.getMoves(board, start);
    Assert.assertEquals(8, moves.size());

    String[] expectedMoves = {"d5", "e5", "f5", "d4", "f4", "d3", "e3", "f3"};

    for (String m : expectedMoves) {
      Position pos = new Position(m);
      Assert.assertTrue(moves.contains(pos));
    }

  }

}