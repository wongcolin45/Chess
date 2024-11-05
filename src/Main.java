import Controller.ChessController;
import Controller.ChessTerminalController;

public class Main {
  public static void main(String[] args) {

    ChessController controller = new ChessTerminalController();
    controller.startGame();

  }
}
