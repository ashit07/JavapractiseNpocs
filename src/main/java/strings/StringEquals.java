package strings;

public class StringEquals {


  public static void main(String[] args) {
    String s1 = "abc";
    String s2 = new String("abc");
    String s3 = new String("abc").intern();
    String s5 = null;
   // String s4 = new String (s5);

    System.out.println(s1==s2);
    System.out.println(s1==s3);
    System.out.println(s2==s3);
   // System.out.println(s4);

    System.out.println("-----");
    String s6 = new String();
    System.out.println(s6);
  }
}
