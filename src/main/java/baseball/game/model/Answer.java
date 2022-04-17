package baseball.game.model;

import static baseball.game.model.Game.BALL_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {

  private final List<Integer> numbers;

  public Answer() {
    this.numbers = makeAnswer();
  }

  private List<Integer> makeAnswer() {
    final List<Integer> uniqueNumbers = new ArrayList<>();

    for (int i = 0; i < BALL_LENGTH; i++) {
      final int randomNumber = Randoms.pickNumberInRange(1, 9);

      if (uniqueNumbers.contains(randomNumber)) {
        continue;
      }

      uniqueNumbers.add(randomNumber);
    }

    return uniqueNumbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
