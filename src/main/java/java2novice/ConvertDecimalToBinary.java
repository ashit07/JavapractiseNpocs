package java2novice;

public class ConvertDecimalToBinary {

  public static void convertToBinary(int number) {
    int [] binary = new int[25];
    int startIndex=0;
    while(number>0) {
      binary[startIndex++]=number%2;
      number/=2;
    }
    for(int i=startIndex-1; i>=0;i--) {
      System.out.print(binary[i]);
    }
    System.out.println("");
  }

  public static void convertUsingBitwiseOperation(int number) {
    int mask = 32768;
    System.out.println(mask);
    while(mask>0) {
      if((mask&number) !=0) {
        System.out.print("1");
      } else {
        System.out.print("0");
      }
      mask=mask>>1;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ConvertDecimalToBinary.convertToBinary(32768);
    ConvertDecimalToBinary.convertUsingBitwiseOperation(9);
  }
}
