package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class Hint {

  public static final String NOTHING_MESSAGE = "낫싱";
  public static final String STRIKE_MESSAGE = "스트라이크";
  public static final String BALL_MESSAGE = "볼";

  private final List<String> message = new ArrayList<>();

  public Hint(final int strikeCount, final int ballCount) {
    addHintIfNothing(strikeCount, ballCount);
    addHintIfBall(ballCount);
    addHintIfStrike(strikeCount);
  }

  public String getMessage() {
    return String.join(" ", message);
  }

  private void addHintIfNothing(int strikeCount, int ballCount) {
    if (nothing(strikeCount, ballCount)) {
      this.message.add(NOTHING_MESSAGE);
    }
  }

  private boolean nothing(final int strike, final int ball) {
    return strike == 0 && ball == 0;
  }

  private void addHintIfBall(int ballCount) {
    if (ballCount != 0) {
      this.message.add(ballCount + BALL_MESSAGE);
    }
  }

  private void addHintIfStrike(int strikeCount) {
    if (strikeCount != 0) {
      this.message.add(strikeCount + STRIKE_MESSAGE);
    }
  }
}
