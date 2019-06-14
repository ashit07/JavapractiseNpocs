package arrayExamples;

public class FindMaxTwo {

  public void findMaxTwoWithoutSort(int[] arr) {
    int max1=Integer.MIN_VALUE;
    int max2=Integer.MIN_VALUE;
    for(int i=0; i<arr.length;i++) {
      if(max1<arr[i]) {
        max2=max1;
        max1=arr[i];
      } else {
        max2=arr[i];
      }
    }
    System.out.println("Max 1 is: "+max1);
    System.out.println("Max 2 is: "+max2);
  }
  public static void main(String[] args) {
    FindMaxTwo instance = new FindMaxTwo();
    int[] arr = {2,3,44,33,1,22,99,44};
    instance.findMaxTwoWithoutSort(arr);
  }
}
