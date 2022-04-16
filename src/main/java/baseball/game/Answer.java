package baseball.game;

import static baseball.game.Game.BALL_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

  private final int[] numbers = new int[BALL_LENGTH];

  public Answer() {
    for (int i = 0; i < BALL_LENGTH; i++) {
      numbers[i] = Randoms.pickNumberInRange(1, 10);
    }
  }

  public int[] getNumbers() {
    return numbers;
  }
}
