package baseball.game.model;

import static baseball.game.model.BallNumbers.BALL_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {

  private final BallNumbers numbers;

  public Answer() {
    this.numbers = makeAnswer();
  }

  private BallNumbers makeAnswer() {
    final List<Integer> uniqueNumbers = new ArrayList<>();

    for (int i = 0; i < BALL_LENGTH; i++) {
      final int randomNumber = Randoms.pickNumberInRange(1, 9);

      if (uniqueNumbers.contains(randomNumber)) {
        continue;
      }

      uniqueNumbers.add(randomNumber);
    }

    return new BallNumbers(uniqueNumbers);
  }

  public BallNumbers getNumbers() {
    return numbers;
  }
}
