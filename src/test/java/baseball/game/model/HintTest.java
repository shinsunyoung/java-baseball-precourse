package baseball.game.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {

  @DisplayName("0볼 0스트라이크인 경우, 낫싱 힌트를 생성한다")
  @Test
  void nothingHintTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    BallNumbers input = new BallNumbers(Lists.list(4, 5, 6));

    Result nothing = Result.make(answer, input);

    // when
    Hint hint = new Hint(nothing);

    // then
    assertThat(hint.getNothing().isNothing()).isTrue();
    assertThat(hint.getBall()).isNull();
    assertThat(hint.getStrike()).isNull();
  }


  @DisplayName("1볼 0스트라이크인 경우, 1볼 힌트를 생성한다")
  @Test
  void ballHintTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    BallNumbers input = new BallNumbers(Lists.list(2, 5, 6));

    Result oneBall = Result.make(answer, input);

    // when
    Hint hint = new Hint(oneBall);

    // then
    assertThat(hint.getNothing()).isNull();
    assertThat(hint.getBall().getCount()).isEqualTo(1);
    assertThat(hint.getStrike()).isNull();
  }

  @DisplayName("0볼 2스트라이크인 경우, 2스트라이크 힌트를 생성한다")
  @Test
  void strikeHintTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    BallNumbers input = new BallNumbers(Lists.list(1, 2, 6));


    Result twoStrike = Result.make(answer, input);

    // when
    Hint hint = new Hint(twoStrike);

    // then
    assertThat(hint.getNothing()).isNull();
    assertThat(hint.getBall()).isNull();
    assertThat(hint.getStrike().getCount()).isEqualTo(2);
  }

  @DisplayName("1볼 1스트라이크인 경우, 1볼 1스트라이크 힌트를 생성한다")
  @Test
  void ballAndStrikeHintTest() {
    // given
    BallNumbers answer = new BallNumbers(Lists.list(1, 2, 3));
    BallNumbers input = new BallNumbers(Lists.list(1, 3, 6));

    Result oneBallOneStrike = Result.make(answer, input);

    // when
    Hint hint = new Hint(oneBallOneStrike);

    // then
    assertThat(hint.getNothing()).isNull();
    assertThat(hint.getBall().getCount()).isEqualTo(1);
    assertThat(hint.getStrike().getCount()).isEqualTo(1);
  }

}