package baseball.game.model;

import static baseball.game.model.BallNumbers.BALL_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

  @DisplayName("값이 모두 다른 숫자 3개를 랜덤하게 뽑아 반환한다.")
  @Test
  void makeAnswerTest() {
    // given, when
    Answer answer = new Answer();

    List<Integer> values = answer.getNumbers().getValues();
    int uniqueCount = getUniqueCount(values);

    // then
    assertThat(values.size()).isEqualTo(BALL_LENGTH);
    assertThat(values.size()).isEqualTo(uniqueCount);

  }

  private int getUniqueCount(List<Integer> values) {
    Set<Integer> uniqueValues = new HashSet<>(values);

    return uniqueValues.size();
  }

}