package Model.Pieces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import Model.Board;
import Model.ChessBoard;
import Model.Color;
import Model.Position;

import static org.junit.Assert.*;

public class RookTest {

  private Board board;

  @Before
  public void init() {
    board = new ChessBoard();
  }

  @Test
  public void testRookStartMoves() {
    Piece rook = new Rook(Color.WHITE, "r");
    Position pos = new Position("a1");
    List<Position> moves = rook.getMoves(board, pos);
    Assert.assertEquals(14, moves.size());

    for (int r = 2; r <= 8; r++) {
      Position check = new Position("a"+r);
      Assert.assertTrue(moves.contains(check));
    }

    for (String c : new String[]{"b", "c", "d", "e", "f", "g", "h"}) {
      Position check = new Position(c+1);
      Assert.assertTrue(moves.contains(check));
    }
  }


}