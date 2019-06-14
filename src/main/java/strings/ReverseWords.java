package strings;

public class ReverseWords {

  public ReverseWords() {

  }

  public String reverseWords (String s) {
    char[] buf = (" "+s).toCharArray();
    reverse(buf, 0, buf.length);
    System.out.println(new String(buf));
    int wordEnd=0;
    for(int wordStart=0; wordStart < buf.length;wordStart=wordEnd+1) {
      for(wordEnd=wordStart; wordEnd < buf.length ; wordEnd ++) {
        if(buf[wordEnd] == ' ') {
         reverse(buf, wordStart, wordEnd);
        // System.out.println(new String(buf));
         break;
        }
      }
    }
    return new String(buf);
  }
  public void reverse(char[] c, int start, int end) {
    for(int i=start, j=end-1; i<j ; i++, j-- ) {
      char temp = c[i];
      c[i] = c[j];
      c[j] = temp;
    }
  }

  public static void main(String [] args) {
    String abc = new ReverseWords().reverseWords("How are you doing");
    System.out.println(abc);
  }
}
