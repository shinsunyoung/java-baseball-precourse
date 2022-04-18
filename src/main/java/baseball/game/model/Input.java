package baseball.game.model;

import static baseball.game.model.BallNumbers.BALL_LENGTH;

import baseball.util.StringUtils;

public class Input {

  private final String value;

  public Input(String value) {
    validate(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private void validate(final String input) {
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
