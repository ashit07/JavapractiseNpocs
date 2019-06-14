package bitwise;

public class BitwiseOperatorExample {
/**
 * XOR operation
 * 1010    a=10
   1000    b=8
   -------------
   0010    a=a^b=2     10^8
   1000    b=8
   -------------
   1010    b=a^b=10
   0010    a=2
   -------------
   1000    a=b^a=8
 *
 * @param a
 * @param b
 */
  public static void swap (int a, int b) {
    System.out.println("a: "+a+" b: "+b);
    a=a^b;
    b=a^b;
    a=a^b;

    System.out.println("a: "+a+" b: "+b);
  }
  /**
   * number >> shifts
   * Means the same as division with 2^b
   *
   * @param number
   * @param shifts
   */
  public static void rightShift(int number, int shifts) {
    System.out.println(number>>shifts);
  }

  public static void negationShift(int number) {
    System.out.println(~number);
  }
  /**
   * number << shifts
   *
   *Means the same as multiplication with 2^b
   * @param number
   * @param shifts
   */
  public static void leftShift(int number, int shifts) {
    System.out.println(number<<shifts);
  }
/**
 *Difference with bitwise AND and logical AND also known as short-circuit AND operator is that,
 *logical AND operator applies only to boolean type. Also bitwise AND operator is denoted by singe &
 *while short circuit AND operator is denoted by &&.
 *If A represent 0010 and B represent 1010 then result of A&B would be 0010.
 *Here is another example of bitwise AND operator in Java

    int a = 2; //0010
    int b = 4; //0100
    a&b        //0000
 *
 * @param x
 * @param y
 */
  public static void bitwiseAnd(int x, int y) {
    System.out.println(x&y);
  }

  /**
   *Bitwise OR operator is also similar to bitwise AND operator and applies to individual bits.
   *It’s different than short-circuit OR operator, which is denoted by (||) and operates on boolean variable.
   *Bitwise OR operator produce result of OR operation on two bits as shown in below example.
   *Like other bitwise operator in Java, bitwise OR is only applicable to integral types.
   *  int a = 2; //0010
   *  int b = 4; //0100
   *    a|b //0110 = 6
   * @param x
   * @param y
   */
  public static void bitwiseOr(int x, int y) {
    System.out.println(x|y);
  }
  /**
   * Write a Java method that will return the number of bits that will need to be changed in order to convert an integer, X, into another integer,
   * Y and vice versa.
   * The method should accept two different integers as input.
   * For example, if your method is passed the integers 12 and 16 then your method should return a 3 .
   * The binary representation of 12 is 01100 and the binary representation of 16 is 10000.
   * Comparing the binary representation of those two numbers, we can see that the first 3 digits are different,
   * which means that to convert 12 to 16 or 16 to 12 we would have to change 3 numbers.
   * And that is why the method that we write should output a 3.
   *
   */

  public static int bitsToConvert(int x, int y) {
    int z = x^y;
    int bitsCount=0;
    while (z!=0) {
      bitsCount += z&1;
      z=z>>1;
    }
    System.out.println(bitsCount);
    return bitsCount;
  }

  public static void main(String[] args) {
  //  BitwiseOperatorExample.swap(-3, 5);
  //  BitwiseOperatorExample.leftShift(8,2);
  //  BitwiseOperatorExample.rightShift(32,4);
  //  BitwiseOperatorExample.negationShift(2);
    BitwiseOperatorExample.bitsToConvert(12, 16);

  }}
