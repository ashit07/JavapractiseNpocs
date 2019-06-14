package strings;

public class StringToInteger {

  public static int convert(String strNum) {
    int number = 0;
    int length=strNum.length();
    int startIndex=0;
    boolean isNegative=false;
    if(strNum.charAt(0)=='-') {
      isNegative=true;
      startIndex=1;
    }
    while(startIndex<length) {
      number = number*10;
      number+=(strNum.charAt(startIndex++)-'0');
    }
    if(isNegative) {
      number=-number;
    }
    return number;
  }

  public static void main(String[] args) {
    System.out.println(StringToInteger.convert("123456"));
    System.out.println(StringToInteger.convert("-123456"));
  }
}
