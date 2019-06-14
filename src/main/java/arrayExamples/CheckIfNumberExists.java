package arrayExamples;

import sorting.SortFactory;
import sorting.Sorting;
import sorting.SortingTypes.SortingType;

public class CheckIfNumberExists {

  public boolean checkIfExists(int[] array, int numToFind) {
    Sorting sort = SortFactory.getInstance().getSortingInstance(SortingType.QUICK_SORT);
    sort.sort(array);
    return binarySearch(array, 0, array.length-1, numToFind);
  }
  private boolean binarySearch(int [] array, int start, int end, int numToFind) {
    if(start>end) {
      return false;
    }
   int mid = (start+end)/2;
   return array[mid]==numToFind || binarySearch(array, 0, mid-1, numToFind) || binarySearch(array, mid+1, end, numToFind);
  }
  public static void main(String[] args) {
    int[] arr = {2,5,4,3,6,8,1,22,33,42,10};
    CheckIfNumberExists inst = new CheckIfNumberExists();
    System.out.println(inst.checkIfExists(arr, 24));

  }

}
