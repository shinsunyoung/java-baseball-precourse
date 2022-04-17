package baseball.game.controller;

import baseball.game.service.InputService;
import baseball.game.model.Answer;
import baseball.game.model.Result;
import baseball.game.view.HintView;
import baseball.printer.Printer;
import baseball.printer.SystemPrinter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class GameManager {

  public static String GAME_END_CHOICE;

  public static final String FINISH_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
  public static final String RETRY = "1";

  private final Printer printer;
  private final InputService inputService;

  public GameManager(final SystemPrinter printer) {
    this.printer = printer;
    this.inputService = new InputService(printer);
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
      final List<Integer> inputValues = inputService.readBallValue();
      result = Result.make(answer.getNumbers(), inputValues);
      printHint(result);
    }
  }

  private void afterClear() {
    printer.print(FINISH_GAME_MESSAGE);
    GAME_END_CHOICE = Console.readLine();
  }

  private void printHint(Result result) {
    printer.print(new HintView(result.getHint()).getMessage() + "\n");
  }
}
