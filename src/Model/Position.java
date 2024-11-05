package Model;

import java.util.Objects;

/**
 * This represents a position on the chess board.
 */
public class Position {

  private final int row;
  private final int col;

  private final String notation;

  public Position(int row, int col) {
    this.row = row;
    this.col = col;

    char file = Integer.toString(8 - row).charAt(0);
    // 97 i s 'a'
    // 0 = 48
    // 48 -> 97
    int ascii = col + '0';
    char rank = (char) (ascii + 49);
    this.notation = Character.toString(rank) + Character.toString(file);
  }

  public Position(String notation) {
    char file = notation.toLowerCase().charAt(0);
    char rank = notation.charAt(1);

    this.notation = notation;
    this.row = 8 - Character.getNumericValue(rank);
    this.col = file - 'a';

  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public boolean offGrid() {
    return row < -1 || row >= 8 || col < 0 || col >= 8;
  }

  @Override
  public String toString() {
    return notation;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Position other = (Position) obj;
    return row == other.getRow() && col == other.getCol();
  }

  @Override
  public int hashCode() {
    return Objects.hash(row) + Objects.hash(col);
  }

}
