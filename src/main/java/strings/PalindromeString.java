package strings;

class PalindromeString {

  public static void main(String args[]) {

    // Create a Scanner object
    // Scanner s=new Scanner(System.in);

    System.out.println("Enter the string");

    // Read the data
    // String st1=s.nextLine();
    String st1 = "abc";
    // Create StringBuffer obj for st1
    StringBuffer sb = new StringBuffer(st1);

    // Reverse the letters
    sb.reverse();

    // Check & Print if palindrome
    if (st1.equals(sb.toString()))
      System.out.println("Palindrome String");
    else {
      int n = PalindromeString.calculateNumberOfDistinctCharacters(st1, sb);
      System.out.println(n);
    }
  }

  static int calculateNumberOfDistinctCharacters(String a, StringBuffer sb) {
    char[] c = new char[a.length()];
    for (int i = 0; i < c.length; i++) {
      c[i] = a.charAt(i);
    }
    int count = 0;
    char[] c1 = new char[sb.length()];
    for (int i = 0; i < c1.length; i++) {
      c1[i] = sb.charAt(i);
    }
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c1.length; j++) {
        if (c[i] == c1[j]) {
          count = count + 1;
        }
      }
    }
    return c.length - count;
  }
}
