package baseball.game;

import static baseball.game.Game.BALL_LENGTH;

import baseball.printer.Printer;
import baseball.util.StringUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputService {

  private final Printer printer;

  private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

  public InputService(final Printer printer) {
    this.printer = printer;
  }

  public List<Integer> readBallValue() {
    printer.print(INPUT_MESSAGE);
    final String input = Console.readLine();
    validInput(input);
    return StringUtils.convertToIntegerList(input);
  }

  private void validInput(final String input) {
    mustBeEqualSpecifiedLength(input);
    mustBePositiveNumber(input);
    mustBeIndependentNumber(input);
  }

  private void mustBeEqualSpecifiedLength(final String input) {
    if (input.length() != BALL_LENGTH) {
      throw new IllegalArgumentException();
    }
  }

  private void mustBePositiveNumber(final String input) {
    if (!StringUtils.isPositiveNumber(input)) {
      throw new IllegalArgumentException();
    }
  }

  private void mustBeIndependentNumber(final String input) {
    if (StringUtils.hasDuplicatedNumber(input)) {
      throw new IllegalArgumentException();
    }
  }

}
