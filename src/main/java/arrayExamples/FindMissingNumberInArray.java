package arrayExamples;

public class FindMissingNumberInArray {

  public int getMissingNumber(int[] arr, int end) {
    Object o;
    int sum = getNaturalNumbersSum(arr[end]);
    int sumOfArray = sumOfArray(arr);
    return sum-sumOfArray;
  }
  private int sumOfArray(int[] arr) {

   int sum = 0;
   for(int i=0; i< arr.length; i++) {
     sum = sum+arr[i];
   }
    return sum;
  }
  public int getNaturalNumbersSum(int boundary) {
    return (boundary*(boundary+1))/2;
  }

  public static void main(String [] args) {

    FindMissingNumberInArray inst = new FindMissingNumberInArray();

    int[] arr = new int[100];
    for(int i=0; i<arr.length;i++) {
      if(i==50) {
        continue;
      }
      arr[i]=i+1;
    }
    System.out.println(inst.getMissingNumber(arr, arr.length-1));

  }

}
