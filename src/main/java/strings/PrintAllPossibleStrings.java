package strings;

class Abcd {
  void getAllStrings(char[] c, int pos) {
    int charLength = c.length;
    getAllStringsRecurse(c, "", charLength, pos);
  }

  void getAllStringsRecurse(char[] c, String prefix, int n, int pos) {
    if (pos == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = 0; i < n; i++) {
      String newPrefix = prefix + c[i];
      getAllStringsRecurse(c, newPrefix, n, pos - 1);
    }
  }
}


public class PrintAllPossibleStrings {
  public static void main(String args[]) {
    char[] c = {'a', 'b', 'c'};
    int k = 2;
    Abcd obj = new Abcd();
    obj.getAllStrings(c, k);
  }
}
