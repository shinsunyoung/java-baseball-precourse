package baseball.game.model;

import static baseball.game.model.BallNumbers.BALL_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumbersTest {

  @DisplayName("값이 모두 다른 숫자 리스트를 포함한다.")
  @Test
  void makeBallNumberTest() {
    // given
    List<Integer> randomRange = Randoms.pickUniqueNumbersInRange(1, 9, BALL_LENGTH);

    // when
    BallNumbers ballNumbers = new BallNumbers(randomRange);

    // then
    assertThat(ballNumbers.getSize()).isEqualTo(BALL_LENGTH);
  }

  @DisplayName("BALL_LENGTH와 크기가 다른 값의 리스트가 인자로 들어오면 예외 발생한다.")
  @Test
  void makeAnswerTest() {
    // given
    List<Integer> emptyList = new ArrayList<>();

    // when, then
    assertThatThrownBy(() -> {
      new BallNumbers(emptyList);
    }).isInstanceOf(IllegalArgumentException.class);
  }


}