package puzzles.jpMorgan;

public class Main {
  public String addBinary(String a, String b) {
    int la = a.length();
    int lb = b.length();

    int max = Math.max(la, lb);

    StringBuilder sum = new StringBuilder("");
    int carry = 0;

    for (int i = 0; i < max; i++) {
      int m = getBit(a, la - i - 1);
      int n = getBit(b, lb - i - 1);
      int add = m + n + carry;
      sum.append(add % 2);
      carry = add / 2;
    }

    if (carry == 1)
      sum.append("1");

    String sum2 = sum.reverse().toString();
    int i = 0;
    while (sum2.charAt(i) == '0') {
      i++;
    }
    if (i > 0) {
      sum2 = sum2.substring(i, sum2.length());
    }
    return sum2;

  }

  public int getBit(String s, int index) {
    if (index < 0 || index >= s.length())
      return 0;

    if (s.charAt(index) == '0')
      return 0;
    else
      return 1;
  }

  public static String addBinaryNumbers(String num1, String num2) {
    int p1 = num1.length() - 1;
    int p2 = num2.length() - 1;
    StringBuilder buf = new StringBuilder();
    int carry = 0;
    while (p1 >= 0 || p2 >= 0) {
      int sum = carry;
      if (p1 >= 0) {
        sum += num1.charAt(p1) - '0';
        p1--;
      }
      if (p2 >= 0) {
        sum += num2.charAt(p2) - '0';
        p2--;
      }
      carry = sum >> 1;
      sum = sum & 1;
      buf.append(sum == 0 ? '0' : '1');
    }
    if (carry > 0) {
      buf.append('1');
    }
    String sum2 = buf.reverse().toString();
    int i = 0;
    while (sum2.charAt(i) == '0') {
      i++;
    }
    if (i > 0) {
      sum2 = sum2.substring(i, sum2.length());
    }
    return sum2;
  }

  public static void main(String[] args) {
    Main obj = new Main();
    // System.out.println(obj.addBinary("0001", "1"));

    System.out.println(Main.addBinaryNumbers("0001", "1"));
  }
}
