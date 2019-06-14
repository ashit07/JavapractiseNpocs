package strings;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not
 * use additional data structures?
 *
 * @author ashijune
 *
 */
public class UniqueCharsInString {
  /**
   * Throws IllegalArgumentException if string is null.
   *
   * @param word
   * @return
   */
  public boolean isUniqueChars(String word) throws IllegalArgumentException {
    if (word == null) {
      throw new IllegalArgumentException("Founded null value");
    }
    if (word.isEmpty()) {
      return true;
    }
    boolean[] chars = new boolean[256];
    for (int i = 0; i < word.length(); i++) {
      int asci = word.charAt(i);
      if (chars[asci]) {
        return false;
      }
      chars[asci] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    UniqueCharsInString instance = new UniqueCharsInString();
    System.out.println(instance.isUniqueChars("abcdef"));
    System.out.println(instance.isUniqueChars("abcded"));
  }

}
