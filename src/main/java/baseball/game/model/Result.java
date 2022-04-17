package baseball.game.model;


import static baseball.game.model.BallNumbers.BALL_LENGTH;

import java.util.List;

public class Result {

  private final boolean answer;
  private final int strikeCount;
  private final int ballCount;

  private Result(boolean answer, int strikeCount, int ballCount) {
    this.answer = answer;
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public static Result make(final BallNumbers answer, final List<Integer> input) {
    int strikeCount = countStrike(answer, input);
    int ballCount = countBall(answer, input);

    return new Result(checkAnswer(strikeCount, ballCount), strikeCount, ballCount);
  }

  public static Result init() {
    return new Result(false, 0, 0);
  }

  public boolean isAnswer() {
    return answer;
  }

  public int getStrikeCount() {
    return strikeCount;
  }

  public int getBallCount() {
    return ballCount;
  }

  private static boolean checkAnswer(int strikeCount, int ballCount) {
    return strikeCount == BALL_LENGTH;
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
