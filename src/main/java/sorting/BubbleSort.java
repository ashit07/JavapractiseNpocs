package sorting;

public class BubbleSort {
	int [] array = new int [10];
 public void doBubbleSort () {
	 for (int j=array.length;j>1;j--) {
	 for (int i=0;i<array.length-1;i++) {
		 if (array[i]>array[i+1]) {
			 swap (i,i+1);
		 }
	 }
	 }
 }
 public void swap (int large, int small) {
	 int temp = array[large];
	 array[large]=array[small];
	 array[small]=temp;
 }
 public void insertElement(int index, int value) {
	 array[index]=value;
 }
 public void display () {
	for (int i=0;i<array.length;i++) {
	 System.out.print(array[i]+" ");
	 }
 }
 public static void main (String args[]) {
	 BubbleSort obj = new BubbleSort();
	 obj.insertElement(0, 30);
	 obj.insertElement(1, 10);
	 obj.insertElement(2, 50);
	 obj.insertElement(3, 23);
	 obj.insertElement(4, 21);
	 obj.insertElement(5, 40);
	 obj.insertElement(6, 50);
	 obj.insertElement(7, 80);
	 obj.insertElement(8, 11);
	 obj.insertElement(9, 19);
	 obj.display();
	 
	 obj.doBubbleSort();
	 System.out.println("After sorting");
	 obj.display();
 }
 
}
