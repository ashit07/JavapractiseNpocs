package regex;

public class RegexUtils {
  public static boolean isNumeric(String s) {
    return java.util.regex.Pattern.matches("\\d+", s);
  }

  public static boolean isNumeric2(String s) {
    return java.util.regex.Pattern.matches("([0-9]*)", s);
  }
}
