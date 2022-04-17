package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtils {

  public static boolean isNumeric(final String input) {
    if (input == null) {
      return false;
    }

    try {
      Integer.parseInt(input);
    } catch (final NumberFormatException nfe) {
      return false;
    }

    return true;
  }

  public static boolean isPositiveNumber(final String input) {
    return isNumeric(input) && !containZero(input) && !containMinus(input);
  }

  public static boolean containZero(final String input) {
    return input.contains("0");
  }

  public static boolean containMinus(final String input) {
    return input.contains("-");
  }

  public static boolean hasDuplicatedNumber(final String input) {
    final Set<Character> set = new HashSet<>();

    for (int i = 0; i < input.length(); i++) {
      set.add(input.charAt(i));
    }

    return set.size() != input.length();
  }

  public static List<Integer> convertToIntegerList(final String input) {
    assert (input != null);

    final List<Integer> digits = new ArrayList<>(input.length());

    for (int i = 0; i < input.length(); i++) {
      digits.add(i, input.charAt(i) - '0');
    }

    return digits;
  }

}
