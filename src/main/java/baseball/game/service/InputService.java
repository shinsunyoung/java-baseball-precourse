package baseball.game.service;


import static baseball.game.model.BallNumbers.BALL_LENGTH;

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
    validBallLength(input);
    validBallValue(input);
    validIndependentNumber(input);
  }

  private void validBallLength(final String input) {
    if (input.length() != BALL_LENGTH) {
      throw new IllegalArgumentException();
    }
  }

  private void validBallValue(final String input) {
    if (!StringUtils.isPositiveNumber(input)) {
      throw new IllegalArgumentException();
    }
  }

  private void validIndependentNumber(final String input) {
    if (StringUtils.hasDuplicatedNumber(input)) {
      throw new IllegalArgumentException();
    }
  }

}
