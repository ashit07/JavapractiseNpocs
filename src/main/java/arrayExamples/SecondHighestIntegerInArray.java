package arrayExamples;

public class SecondHighestIntegerInArray {

  public static int findSecondHighestNumber(int[] arr) {
    int maxOne = 0;
    int maxTwo = 0;
    for (int i = 0; i < arr.length; i++) {
      if (maxOne < arr[i]) {
        maxTwo = maxOne;
        maxOne = arr[i];
      } else if (maxTwo < arr[i]) {
        maxTwo = arr[i];
      }
    }
    return maxTwo;

  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 44, 5, 26, 7, 8, 9};
    int maxTwo = findSecondHighestNumber(arr);
    System.out.println("Second highest number is " + maxTwo);
  }
}
