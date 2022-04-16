package baseball.util;

import java.util.HashSet;
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

  public static int[] convertToIntArray(final String input) {
    assert (input != null);
    
    final int[] digits = new int[input.length()];

    for (int i = 0; i < input.length(); i++) {
      digits[i] = input.charAt(i) - '0';
    }

    return digits;
  }

}
