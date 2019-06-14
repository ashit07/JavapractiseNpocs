package arrayExamples;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateElements {
  public static void removeDuplicates(int[] arr) {
    int[] temp = new int[arr.length];
    List<Integer> dupelements = new ArrayList<Integer>();
    for (int i = 0; i < arr.length - 1; i++) {
      if (dupelements.contains(arr[i])) {
        System.out.println("Duplicate element is " + arr[i] + " at index " + i);
      } else {
        dupelements.add(arr[i]);
        temp[i] = arr[i];
      }
    }
    Object[] temp1 = dupelements.toArray();
    System.out.println("");
    for (int i = 0; i < temp1.length; i++) {
      System.out.print(((Integer) temp1[i]).intValue() + " ");
    }
    System.out.println("");
    System.out.println("");
    System.out.println("array is ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(temp[i] + " ");
    }
    // return ((Integer [])dupelements.toArray());
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 5, 6, 7, 8, 1, 2, 3, 4, 5};
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("");
    RemoveDuplicateElements.removeDuplicates(array);

  }
}
