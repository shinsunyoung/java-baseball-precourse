package baseball.game.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  @DisplayName("모든 숫자가 같으면 3스트라이크가 되며 정답이 된다")
  @Test
  void threeStrikeResultTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    List<Integer> input = Lists.list(1, 2, 3);

    // when
    Result threeStrike = Result.make(answer, input);

    // then
    assertThat(threeStrike.getStrikeCount()).isEqualTo(3);
    assertThat(threeStrike.isAnswer()).isTrue();
  }

  @DisplayName("스트라이크, 볼 모두 일치하지 않으면 오답이 된다")
  @Test
  void nothingResultTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    List<Integer> input = Lists.list(4, 5, 6);

    // when
    Result nothing = Result.make(answer, input);

    // then
    assertThat(nothing.getStrikeCount()).isEqualTo(0);
    assertThat(nothing.getBallCount()).isEqualTo(0);
    assertThat(nothing.isAnswer()).isFalse();
  }


  @DisplayName("1볼 1스트라이크인 경우 오답이 된다")
  @Test
  void ballAndStrikeHintTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    List<Integer> input = Lists.list(1, 3, 6);

    // when
    Result oneBallOneStrike = Result.make(answer, input);

    // then
    assertThat(oneBallOneStrike.getStrikeCount()).isEqualTo(1);
    assertThat(oneBallOneStrike.getBallCount()).isEqualTo(1);
    assertThat(oneBallOneStrike.isAnswer()).isFalse();
  }

}