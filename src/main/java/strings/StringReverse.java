package strings;

public class StringReverse {


  public String reverseStringRecursive(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }
    return reverseStringRecursive(str.substring(1, str.length())) + str.charAt(0);
  }

  public static String reverse(String str, String result, int index) {
    if (index < str.length()) {
      result = str.charAt(index) + result;
      return reverse(str, result, index + 1);
    }
    return result;
  }


  public boolean isPalindrome(String str, int start, int end) {
    if (start > end) {
      return true;
    }
    if (str.charAt(start) != str.charAt(end)) {
      return false;
    }
    return isPalindrome(str, ++start, --end);
  }


  public static void main(String[] args) {
    StringReverse strReverse = new StringReverse();
    // String str = "abcdef";
    // System.out.println(strReverse.reverseStringRecursive(str));

    String str2 = "abcdba";
    System.out.println(strReverse.isPalindrome(str2, 0, str2.length() - 1));


  }
}
