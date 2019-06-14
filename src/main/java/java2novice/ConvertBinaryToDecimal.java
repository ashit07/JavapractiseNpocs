package java2novice;

public class ConvertBinaryToDecimal {

  /**
   * binary=1001;
   *
   *
   * @param binary
   * @return
   */
  public static int convertBinaryToDecimal(int binary) {
    int num=0;
    int powerCount=0;
    while(binary>0) {
      num=(int) (num+((binary%10)*(Math.pow(2, powerCount++))));
      binary=binary/10;
    }
    return num;
  }
  public static void main(String[] args) {
    System.out.println(ConvertBinaryToDecimal.convertBinaryToDecimal(1001));
  }
}
