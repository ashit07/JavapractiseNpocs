package puzzles;

/**
 * 1 2 3 5 8 13 21
 * 
 * @author ashijune
 *
 */
public class FibonacciSeries {

  public static void printfibonacciSeries(int range) {
    int[] Feb = new int[range];
    Feb[0] = 0;
    Feb[1] = 1;
    for (int i = 2; i < Feb.length; i++) {
      Feb[i] = Feb[i - 1] + Feb[i - 2];
    }
    for (int i = 0; i < Feb.length; i++) {
      System.out.print(Feb[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    printfibonacciSeries(10);
  }
}
