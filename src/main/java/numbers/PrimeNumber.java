package numbers;

public class PrimeNumber {

  public static boolean isPrime(int number) {
     for (int i=2;i<number/2; i++) {
       if(number%i==0) {
         return false;
       }
     }
     return true;
  }
  public static boolean isPrimeRecursive (int i, int number) {
    if(i>=number/2) {
      return true;
    }
    if(number%i==0) {
      return false;
    }
    return isPrimeRecursive(++i, number);

  }
  public static void main(String[] args) {
//    System.out.println(isPrime(13));
//    System.out.println(isPrime(18));
//    System.out.println(isPrime(23));
//    System.out.println(isPrime(31));

    System.out.println(isPrimeRecursive(2, 31));
    System.out.println(isPrimeRecursive(2, 28));


  }
}
