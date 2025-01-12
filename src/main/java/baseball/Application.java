package baseball;

import baseball.game.controller.GameManager;
import baseball.printer.SystemPrinter;

public class Application {

  public static void main(final String[] args) {
    final GameManager gameManager = new GameManager(
        new SystemPrinter()
    );

    gameManager.start();
  }
}
