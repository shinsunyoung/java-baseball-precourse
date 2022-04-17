package baseball.game.model;


import static baseball.game.model.BallNumbers.BALL_LENGTH;

import java.util.List;

public class Result {

  private final boolean answer;

  private final Hint hint;

  private Result(final boolean answer, final Hint hint) {
    this.answer = answer;
    this.hint = hint;
  }

  public boolean isAnswer() {
    return answer;
  }

  public Hint getHint() {
    return hint;
  }

  public static Result correct() {
    return new Result(true, new Hint(BALL_LENGTH, 0));
  }

  public static Result wrong(final int strike, final int ball) {
    return new Result(false, new Hint(strike, ball));
  }

  public static Result init() {
    return new Result(false, null);
  }

  public static Result make(final BallNumbers answer, final List<Integer> input) {
    final int strikeCount = countStrike(answer, input);
    final int ballCount = countBall(answer, input);

    return calculation(strikeCount, ballCount);
  }

  private static Result calculation(int strikeCount, int ballCount) {
    if (strikeCount == BALL_LENGTH) {
      return correct();
    }

    return wrong(strikeCount, ballCount);
  }

  private static int countStrike(final BallNumbers answer, final List<Integer> input) {
    int count = 0;

    for (int i = 0; i < answer.getSize(); i++) {
      if (isStrike(answer.getValues().get(i), input.get(i))) {
        count++;
      }
    }

    return count;
  }


  private static int countBall(final BallNumbers answer, final List<Integer> input) {
    int count = 0;

    for (int i = 0; i < answer.getSize(); i++) {
      if (isBall(answer, answer.get(i), input.get(i))) {
        count++;
      }
    }

    return count;
  }

  private static boolean isBall(BallNumbers allAnswers, Integer answer, Integer input) {
    return !isStrike(answer, input) && allAnswers.contains(input);
  }

  private static boolean isStrike(Integer answer, Integer input) {
    return answer.equals(input);
  }
}
