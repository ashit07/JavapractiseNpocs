import java.util.ArrayList;

/**
 * 
 * @author ashijune
 * Insertion Sort Algorithm
 * 
 * For array A= {1,2,3,4,5,6,7,8,9,10}
 * 
 * Insertion-Sort(A)
 * 1.	for j=2 to A.length
 * 2.		key=A[j];
 * 3.		i=j-1;
 * 4.		while i>0 and A[i] > key
 * 5.			A[i+1] = A[i];
 * 6.			i=i-1;
 * 7.			A[i+1]=key;
 * 
 */

public class InsetionSort {
int[] toSort={34,54,12,23,67,87,32,45,11,10};;
	InsetionSort () {
		System.out.println("Before sorting ");
		for (int i=0;i<toSort.length;i++) 
		System.out.print(toSort[i]+ " ");
		applyInsertionSort(toSort);
		System.out.println("");
		System.out.println("After sorting ");
		for (int i=0;i<toSort.length;i++) 
		System.out.print(toSort[i]+" ");
}

void applyInsertionSort (int[] arr) {
		for (int j=1; j<toSort.length; j++) {
			int key = toSort[j];
			int i=j-1;
			while (i>=0 && toSort[i]>key) {
				toSort[i+1]=toSort[i];
				i=i-1;
				toSort[i+1]=key;
			}
		}
}

public static void main (String args[]) {
	new InsetionSort();
}
}
