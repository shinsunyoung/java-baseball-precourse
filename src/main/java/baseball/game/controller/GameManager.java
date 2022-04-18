package baseball.game.controller;

import baseball.game.model.BallNumbers;
import baseball.game.model.Hint;
import baseball.game.model.Answer;
import baseball.game.model.Result;
import baseball.game.view.HintView;
import baseball.game.view.InputView;
import baseball.printer.Printer;
import baseball.printer.SystemPrinter;
import camp.nextstep.edu.missionutils.Console;


public class GameManager {

  public static String GAME_END_CHOICE;

  public static final String FINISH_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
  public static final String RETRY = "1";

  private final Printer printer;
  private final InputView inputView;

  public GameManager(final SystemPrinter printer) {
    this.printer = printer;
    this.inputView = new InputView(printer);
  }

  public void start() {
    do {
      playing();
      afterClear();
    } while (GAME_END_CHOICE.equals(RETRY));
  }

  private void playing() {
    final Answer answer = new Answer();
    continueUntilClear(answer);
  }

  private void continueUntilClear(final Answer answer) {
    Result result = Result.init();

    while (!result.isAnswer()) {

      BallNumbers ballNumbers = inputView.readBallValue();
      result = Result.make(answer.getNumbers(), ballNumbers);
      printHint(result);
    }
  }

  private void afterClear() {
    printer.print(FINISH_GAME_MESSAGE);
    GAME_END_CHOICE = Console.readLine();
  }

  private void printHint(Result result) {
    Hint hint = new Hint(result);
    printer.print(new HintView(hint).getMessage() + "\n");
  }
}
