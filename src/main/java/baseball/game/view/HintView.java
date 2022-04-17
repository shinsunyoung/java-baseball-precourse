package baseball.game.view;

import baseball.game.model.Ball;
import baseball.game.model.Hint;
import baseball.game.model.Nothing;
import baseball.game.model.Strike;
import java.util.ArrayList;
import java.util.List;

public class HintView {

  public static final String NOTHING_MESSAGE = "낫싱";
  public static final String STRIKE_MESSAGE = "스트라이크";
  public static final String BALL_MESSAGE = "볼";

  private final List<String> message = new ArrayList<>();

  public HintView(Hint hint) {
    addMessageIfNothing(hint.getNothing());
    addMessageIfBall(hint.getBall());
    addMessageIfStrike(hint.getStrike());
  }

  public String getMessage() {
    return String.join(" ", message);
  }

  private void addMessageIfNothing(Nothing nothing) {
    if (nothing != null && nothing.isNothing()) {
      this.message.add(NOTHING_MESSAGE);
    }
  }

  private void addMessageIfBall(Ball ball) {
    if (ball != null) {
      this.message.add(ball.getCount() + BALL_MESSAGE);
    }
  }

  private void addMessageIfStrike(Strike strike) {
    if (strike != null) {
      this.message.add(strike.getCount() + STRIKE_MESSAGE);
    }
  }

}
