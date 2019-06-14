package numbers;

public class SumOfDigits {

  public int sumOfDigitsRecursion(int number) {
    if(number==0) {
      return 0;
    }
    return (number%10)+sumOfDigitsRecursion(number/10);
  }
  public static void main(String[] args) {
    SumOfDigits sd = new SumOfDigits();
    System.out.println(sd.sumOfDigitsRecursion(12345));
  }
}
