package arrayExamples;

import sorting.SortFactory;
import sorting.Sorting;
import sorting.SortingTypes.SortingType;

public class FindMinAndMaxElemInArray {

  public static void findMinAndMax(int[] array) {
    printArray(array);
    sortArray(array);
    printArray(array);
    System.out.println(getMinElem(array));
    System.out.println(getMaxElem(array));
  }

  private static void printArray(int[] array) {
    for(int i=0; i<array.length;i++) {
      System.out.print(array[i]+" ");
    }
    System.out.println("");
  }

  private static int getMaxElem(int[] array) {
    return array[0];
  }

  private static int getMinElem(int[] array) {
    return array[array.length-1];
  }

  private static void sortArray(int[] array) {
    Sorting instance = SortFactory.getInstance().getSortingInstance(SortingType.QUICK_SORT);
    instance.sort(array);
  }
  public static void main(String[] args) {
    int[] array= {2,5,4,3,6,8,1,22,33,42,10};
    FindMinAndMaxElemInArray.findMinAndMax(array);

    int[] arrayWithNegativeElems = {2,5,4,3,-6,8,-1,-22,33,42,10};
    FindMinAndMaxElemInArray.findMinAndMax(arrayWithNegativeElems);
  }
}
