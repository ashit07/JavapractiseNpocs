package numbers;

public class Fibonacci {

  public static int fibonacci(int number) {
    if(number==0) {
      return 0;
    }
    if(number==1) {
      return 1;
    }
    if(number==2) {
      return 1;
    }
    return fibonacci(number-1)+fibonacci(number-2);
  }
  public static void main(String[] args) {
    for(int i=0;i<10;i++) {
      System.out.println(Fibonacci.fibonacci(i));
    }
  }

}