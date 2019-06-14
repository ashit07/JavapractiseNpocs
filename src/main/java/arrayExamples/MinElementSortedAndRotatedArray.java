package arrayExamples;

import java.util.Scanner;

/**
 * Divide And Conquer Algorithm to be used:
 * 
 * MiNSORTEDARRAY(arr[], low, high) 1. if high < low 2. return arr[high] 3. if high == low 4. return
 * arr[low] 5. int mid = low + (high - low)/2 6. if (mid < high && arr[mid+1] < arr[mid]) 7. return
 * arr[mid+1] 8. if (mid>low && arr[mid]<arr[mid-1]) 9. return arr[mid] // This case causes O(n)
 * time 10. if (arr[low] == arr[mid] && arr[high] == arr[mid]) 11. return min(findMin(arr, low,
 * mid-1), findMin(arr, mid+1, high)); // Check if mid itself is minimum element 12. if (mid > low
 * && arr[mid] < arr[mid - 1]) 13. return arr[mid]; // Decide whether we need to go to left half or
 * right half 14. if (arr[high] > arr[mid]) 15. return findMin(arr, low, mid-1); 16. return
 * findMin(arr, mid+1, high);
 * 
 * @author ashijune
 *
 */
public class MinElementSortedAndRotatedArray {

  private int minElement(int arr[], int high, int low) {
    if (high < low) {
      return arr[high];
    }
    if (high == low) {
      return arr[0];
    }
    int mid = low + (high - low) / 2;
    if (mid < high && arr[mid + 1] < arr[mid]) {
      return arr[mid];
    }
    if (mid > low && arr[mid] < arr[mid - 1]) {
      return arr[mid];
    }
    if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
      return min(minElement(arr, low, mid - 1), minElement(arr, mid + 1, high));
    }
    return minElement(arr, mid + 1, high);
  }

  private int min(int firstsubarray, int secondsubarray) {
    if (firstsubarray < secondsubarray) {
      return firstsubarray;
    } else {
      return secondsubarray;
    }
  }

  public static void main(String args[]) {
    System.out.println("Please enter your array in sorted order");
    int arr[] = new int[10];
    Scanner sc = new Scanner(System.in);
    int i = 0;
    while (sc.hasNext()) {
      arr[i] = sc.nextInt();
      i++;
    }
    MinElementSortedAndRotatedArray obj = new MinElementSortedAndRotatedArray();
    obj.minElement(arr, arr.length, 0);
  }
}
