package strings;

public class ReverseString {
  String s1 = "";

  public String reverseStringRecursive(String val) {
    if (val.length() == 0) {
      return "";
    }
    return val.charAt(val.length() - 1)
        + reverseStringRecursive(val.substring(0, val.length() - 1));
  }

  public String reverseStringShashi(String val) {
    try {
      char[] arr = val.toCharArray();
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
    return "";
  }

  public String reverseString(String str) {
    int index = str.length();
    if (index > 0) {
      s1 = s1 + str.charAt(index - 1);
      // System.out.println(s1);
      str = str.substring(0, index - 1);
      // System.out.println(str);
      reverseString(str.substring(0, index - 1));
    }
    return s1;
  }

  public static void main(String[] args) {
    ReverseString rs = new ReverseString();
    System.out.println(rs.reverseStringRecursive("abcdef"));

  }
}
