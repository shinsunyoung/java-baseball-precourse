package baseball.game.model;


public class Hint {

  private Ball ball;
  private Strike strike;
  private Nothing nothing;

  public Hint(final int strikeCount, final int ballCount) {
    addHintIfNothing(strikeCount, ballCount);
    addHintIfBall(ballCount);
    addHintIfStrike(strikeCount);
  }

  public Ball getBall() {
    return ball;
  }

  public Strike getStrike() {
    return strike;
  }

  public Nothing getNothing() {
    return nothing;
  }

  private void addHintIfNothing(int strikeCount, int ballCount) {
    if (nothing(strikeCount, ballCount)) {
      this.nothing = new Nothing(true);
    }
  }

  private boolean nothing(final int strike, final int ball) {
    return strike == 0 && ball == 0;
  }

  private void addHintIfBall(int ballCount) {
    if (ballCount != 0) {
      this.ball = new Ball(ballCount);
    }
  }

  private void addHintIfStrike(int strikeCount) {
    if (strikeCount != 0) {
      this.strike = new Strike(strikeCount);
    }
  }


}
