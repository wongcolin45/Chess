package Model;

import java.util.List;

public interface ViewableBoard {


  /**
   * Gets the current turn of the player.
   * @return the color turn
   */
  Color getTurn();

  /**
   * Gets all the possible moves for the selected piece at that position.
   * If no piece is selected an empty list is given.
   */
  List<Position> getPossibleMoves();

  /**
   * Gets the String grid of the board.
   * @return the grid
   */
  String[][] getTextGrid();
}
