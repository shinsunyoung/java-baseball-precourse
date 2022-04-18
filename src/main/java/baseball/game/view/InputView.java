package baseball.game.view;

import baseball.game.model.BallNumbers;
import baseball.game.model.Input;
import baseball.printer.Printer;
import baseball.util.StringUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private final Printer printer;

  private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

  public InputView(final Printer printer) {
    this.printer = printer;
  }

  public BallNumbers readBallValue() {
    printer.print(INPUT_MESSAGE);
    Input input = new Input(Console.readLine());
    return new BallNumbers(StringUtils.convertToIntegerList(input.getValue()));
  }
}
