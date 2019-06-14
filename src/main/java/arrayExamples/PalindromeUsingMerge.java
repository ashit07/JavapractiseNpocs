package arrayExamples;

import java.util.Arrays;

/**
 * Given an array of positive integers. We need to make the given array a �Palindrome�. Only allowed
 * operation on array is merge. Merging two adjacent elements means replacing them with their sum.
 * The task is to find minimum number of merge operations required to make given array a
 * �Palindrome�.
 * 
 * To make an array a palindromic we can simply apply merging operations n-1 times where n is the
 * size of array (Note a single element array is alway palindrome similar to single character
 * string). In that case, size of array will be reduced to 1. But in this problem we are asked to do
 * it in minimum number of operations.
 * 
 * @author pasbola
 * 
 */
public class PalindromeUsingMerge {

  int findMinOps(int arr[], int n) {
    int ans = 0; // Initialize result

    // Start from two corners
    for (int i = 0, j = n - 1; i <= j;) {
      // If corner elements are same,
      // problem reduces arr[i+1..j-1]
      if (arr[i] == arr[j]) {
        i++;
        j--;
      }

      // If left element is greater, then
      // we merge right two elements
      else if (arr[i] > arr[j]) {
        // need to merge from tail.
        j--;
        arr[j] += arr[j + 1];
        ans++;
      }

      // Else we merge left two elements
      else {
        i++;
        arr[i] += arr[i - 1];
        ans++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    PalindromeUsingMerge arrayExample = new PalindromeUsingMerge();
    int[] arr = new int[] {1, 4, 5, 1};
    // int count = arrayExample.findMinOps(arr, arr.length);
    // System.out.println("result " + count);

    int[] array = new int[] {1, 6, 8, 4, 9, 9, 7, 1};
    displayArr(array);
    int[] resultArray = arrayExample.removeDuplicateElements(array);
    displayArr(resultArray);
    /*
     * // char c = 'lteanr be';
     */System.out.println();
  }

  private static void displayArr(int[] resultArray) {
    for (int ar : resultArray) {
      System.out.print(ar + " ");
    }
    System.out.println("");
  }

  public boolean valExistsInArray(int val, int[] temp) {
    for (int i : temp) {
      if (val == i) {
        return true;
      }
    }
    return false;
  }

  public int[] removeDuplicateElements(int[] arr) {
    int[] temp = new int[arr.length];
    System.out.println("temp length" + temp.length);
    // temp[0] = arr[0];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!valExistsInArray(arr[i], temp)) {
        temp[count++] = arr[i];
      }
    }
    temp = shrink(temp, count);
    /*
     * for(int i = 0; i < arr.length; i++){ temp[i] = arr[i]; }
     */

    return temp;

  }

  private int[] shrink(int[] temp, int count) {
    return Arrays.copyOf(temp, count);
  }
}
