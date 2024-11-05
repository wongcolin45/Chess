package View;

import java.util.List;

import Model.Position;
import Model.ViewableBoard;

public class ChessTerminalView implements ChessView {

  private final ViewableBoard board;

  private int iter;

  private int start;

  private final StringBuilder ranks = new StringBuilder("a     b     c     d     e     f     g     h");

  public ChessTerminalView(ViewableBoard board) {
    this.board = board;
    this.iter = 1;
    this.start = 0;
  }

  private void addPossibleMoves(String[][] grid) {
    try {
      List<Position> moves = board.getPossibleMoves();
      for (Position p : moves) {
        grid[p.getRow()][p.getCol()] = "◦";
      }
    } catch (Exception ignored) {

    }
  }

  @Override
  public void render() {
    System.out.println(possibleMovesBar());
    System.out.println(toString());
  }

  private String possibleMovesBar() {
    StringBuilder bar = new StringBuilder("Possible Moves: ");
    List<Position> moves = board.getPossibleMoves();
    if (moves.isEmpty()) {
      return "No Piece Selected: ";
    }
    for (Position pos : moves) {
      bar.append(pos).append(", ");
    }
    bar.setLength(bar.length() - 2);
    return bar.toString();
  }


  @Override
  public String toString() {
    String[][] grid = board.getTextGrid();
    addPossibleMoves(grid);
    StringBuilder result = new StringBuilder();
    int file = 8 - start;

    result.append("   ╔═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╗" + "\n");
    for (int r = start; r < 8 && r >= 0; r+=iter) {
      result.append(" " + file + " ");
      file -= iter;
      for (int c = start; c < 8 && c >= 0; c+=iter) {
        result.append("║  " + grid[r][c] + "  ");
      }
      result.append("║"+"\n");
      result.append("   ╠═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╣");
      result.append("\n");
    }

    result.setLength(result.length() - 53);
    result.append("   ╚═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╝");
    result.append("\n");

    result.append("      ");
    if (iter == -1) {
      result.append(ranks.reverse());
    } else {
      result.append(ranks);
    }
    result.append("\n");


    return result.toString();
  }

  @Override
  public void flip() {
    start = (start == 7) ? 0 : 7;
    iter *= -1;

  }
}
