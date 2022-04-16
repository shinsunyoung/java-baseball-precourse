package baseball;

import baseball.printer.Printer;
import baseball.printer.SystemPrinter;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

  public static String GAME_END_CHOICE;

  public static final String FINISH_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
  public static final String RETRY = "1";

  private final Printer printer;

  public GameManager(final SystemPrinter printer) {
    this.printer = printer;
  }

  public void start() {
    do {
      // TODO: 정답 생
      // TODO: 입력 값 읽어오기
      // TODO: 정답 판단
      clear();
    } while (GAME_END_CHOICE.equals(RETRY));
  }

  private void clear() {
    printer.print(FINISH_GAME_MESSAGE);
    GAME_END_CHOICE = Console.readLine();
  }
}
