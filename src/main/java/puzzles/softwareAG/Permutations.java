package puzzles.softwareAG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Permutations {
  Map m = new HashMap();
  Set s = new HashSet();

  public int countStrings(int n) {
    int[] a = new int[n];
    int[] b = new int[n];
    a[0] = b[0] = 1;

    for (int i = 1; i < n; i++) {
      a[i] = a[i - 1] + b[i - 1];
      b[i] = a[i - 1];
    }
    System.out.println(2 << n); // 1 << n is equivalent to 2^n
    return (1 << n) - a[n - 1] - b[n - 1];
  }


  public static void main(String[] args) {
    String s = "617";
    System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));

  }

  public static Set<String> permutationFinder(String str) {
    Set<String> perm = new HashSet<String>();
    // Handling error scenarios
    if (str == null) {
      return null;
    } else if (str.length() == 0) {
      perm.add("");
      return perm;
    }
    char initial = str.charAt(0); // first character
    String rem = str.substring(1); // Full string without first character
    Set<String> words = permutationFinder(rem);
    for (String strNew : words) {
      for (int i = 0; i <= strNew.length(); i++) {
        perm.add(charInsert(strNew, initial, i));
      }
    }
    return perm;
  }

  public static String charInsert(String str, char c, int j) {
    String begin = str.substring(0, j);
    String end = str.substring(j);
    return begin + c + end;
  }

  static void ispermuation_divisibleby8(String[] arr) {

    for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
      Set<String> abc = permutationFinder(arr[i]);
      Boolean flag = false;
      for (String str : abc) {
        if (Integer.parseInt(str) % 8 == 0) {
          flag = true;
          System.out.println("YES");
          break;
        }
      }
      if (!flag) {
        System.out.println("NO");
      }
    }
  }
}


