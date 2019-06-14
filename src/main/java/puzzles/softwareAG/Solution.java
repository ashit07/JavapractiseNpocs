package puzzles.softwareAG;

public class Solution {

  public static void perform() {

  }

  public static boolean isNumeric(String s) {
    return java.util.regex.Pattern.matches("\\d+", s);
  }

  public static boolean isNumeric2(String s) {
    return java.util.regex.Pattern.matches("([0-9]*)", s);
  }


  public static void main(String[] args) {
    System.out.println(isNumeric("234"));

    System.out.println(isNumeric2("2348"));
  }
}
