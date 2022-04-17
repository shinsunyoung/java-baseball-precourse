package baseball.game.model;

import java.util.List;

public class BallNumbers {

  public static final int BALL_LENGTH  = 3;

  private final List<Integer> values;

  public BallNumbers(List<Integer> values) {
    validate(values);
    this.values = values;
  }

  public List<Integer> getValues() {
    return values;
  }

  public int getSize() {
    return values.size();
  }

  public int get(int index) {
    return values.get(index);
  }

  public boolean contains(int value) {
    return values.contains(value);
  }

  private void validate(List<Integer> input) {
    validateLength(input);
  }

  private void validateLength(List<Integer> input) {
    if (input.size() != BALL_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
