/**
 * The merge sort algorithm closely follows the divide-and-conquer paradigm. Intuitively,
 *	it operates as follows.
 *	Divide: Divide the n-element sequence to be sorted into two subsequences of n=2
 *			elements each.
 *	Conquer: Sort the two subsequences recursively using merge sort.
 *	Combine: Merge the two sorted subsequences to produce the sorted answer.
 * 
 * 
 * 
 */

package sorting;

public class MergeSort {
/*
 * Let A[p,r] be an array of elements.
 * Then for merge sort we divide the array A[p,r] to A[p,q] and A[q+1,r]
 * where p is the index of first element and r is the index of last element
 */
	int[] arrayToSort ;
	int p;
	int r;
	
	public MergeSort() {
	
	arrayToSort = new int [10];
	p=0;
	r=arrayToSort.length-1;
	
	// TODO Auto-generated constructor stub
	}
	public void insertIntoArray (int index, int value) {
		arrayToSort[index]=value;
	}
	public void display (int [] arrayToDisplay) {
		for (int i=0;i<arrayToDisplay.length;i++)
		System.out.print(arrayToDisplay[i]+" ");
	}
	public int[] mergeElements(int [] arrayToSort, int p, int q, int r) {
		int n1=q-p+1; //Number of elements in 1st pile arrayToSort[p,q]
		int n2=r-q;   //Number of elements in 2nd pile arrayToSort[q+1,r]
		//Create 2 arrays with n1+1 and n2+1 sizes insert into them values from the array
		int [] L = new int [n1];
		int [] R = new int [n2];
		for (int i=1; i<=n1;i++) {
			L[i-1]=arrayToSort[p+i-1];
		}
		for (int i=1;i<=n2;i++) {
			R[i-1]=arrayToSort[q+i];
		}
		// Enter sentinal values in L[n1+1] and R[n2+1]
		//Merging the array
		int i=0;
		int j=0;
		for (int k=p;k<=r;k++) {
			if (L[i]<=R[j]) {
				arrayToSort[k]=L[i];
				i=i+1;
			}
			else{
				arrayToSort[k]=R[j];
				j=j+1;
			}
		}
		return arrayToSort;
	}
	public int[] implementMergeSort(int [] arrayToSort, int p, int r) {
		
		if(p < r) {
			int q=(p+r)/2;
		 implementMergeSort(arrayToSort, p, q);
		implementMergeSort(arrayToSort, q+1,r);
			arrayToSort= mergeElements(arrayToSort, p, q, r);
		}
		 return arrayToSort;
	}
	public static void main (String args[]) {
		MergeSort obj=new MergeSort();
	// insert values into array 8, 20, 9, 4, 15, 10, 7, 22, 3, 12
		obj.insertIntoArray(0, 8);
		obj.insertIntoArray(1, 20);
		obj.insertIntoArray(2, 9);
		obj.insertIntoArray(3, 4);
		obj.insertIntoArray(4, 15);
		obj.insertIntoArray(5, 10);
		obj.insertIntoArray(6, 7);
		obj.insertIntoArray(7, 22);
		obj.insertIntoArray(8, 3);
		obj.insertIntoArray(9, 12);
		System.out.println("Before Sorting array is ");
		obj.display(obj.arrayToSort);
		System.out.println("");
		System.out.println("After applying MergeSort array is ");
		int [] arrayAfterSort = obj.implementMergeSort(obj.arrayToSort, obj.p, obj.r);
		obj.display(arrayAfterSort);
	}
}
