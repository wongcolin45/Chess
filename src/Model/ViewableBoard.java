package Model;

public interface ViewableBoard {


  /**
   * Gets the current turn of the player.
   * @return the color turn
   */
  Color getTurn();

  /**
   * Gets the grid representation as a string 2d array.
   * @return the grid
   */
  String[][] getGridString();
}
