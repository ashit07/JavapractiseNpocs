package arrayExamples;


public class BinarySearchElement {
  int index = 0;

  public void binarySearchElement(int element, int[] arr) {
    int lowerIndex = 0;
    int upperIndex = arr.length;
    int midElement = (lowerIndex + upperIndex) / 2;
    if (arr[midElement] == element) {
      System.out.println("Element is present at location " + (midElement + 1));
    } else if (element < arr[midElement]) {
      int[] halfArray = new int[midElement];
      for (int i = 0; i < midElement; i++)
        halfArray[i] = arr[i];
      binarySearchElement(element, halfArray);
    } else if (element > arr[midElement]) {
      int[] halfArray = new int[midElement + 1];
      for (int i = midElement; i < arr.length; i++)
        halfArray[i - midElement] = arr[i];
      binarySearchElement(element, halfArray);
    } else {
      System.out.println("No element founded");
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    BinarySearchElement obj = new BinarySearchElement();
    obj.binarySearchElement(4, arr);
  }
}
