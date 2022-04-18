package baseball.game.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

  @DisplayName("입력값은 숫자여야 한다")
  @Test
  void inputMustNumberTest() {
    // given
    String wrongInput = "테스트";

    // when, then
    assertThatThrownBy(() -> {
      new Input(wrongInput);
    }).isInstanceOf(IllegalArgumentException.class);

  }

  @DisplayName("입력값은 야구게임의 최대값과 같아 한다")
  @Test
  void inputMustEqualsBallLengthTest() {
    // given
    String wrongInput = "";

    // when, then
    assertThatThrownBy(() -> {
      new Input(wrongInput);
    }).isInstanceOf(IllegalArgumentException.class);
  }


  @DisplayName("입력값은 독립된 숫자여야 한다")
  @Test
  void inputIndependenceNumberTest() {
    // given
    String wrongInput = "112";

    // when, then
    assertThatThrownBy(() -> {
      new Input(wrongInput);
    }).isInstanceOf(IllegalArgumentException.class);

  }


}