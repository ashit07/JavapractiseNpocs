package sorting;

class QuickSort implements Sorting{

  public void sort(int[] array) {
    quicksort(array, 0, array.length-1);
  }
  private void quicksort(int[] array, int start, int end) {
    int pivot;
    if(end>start) {
      pivot = partition(array, start, end);
      quicksort(array, start, pivot-1);
      quicksort(array, pivot+1, end);
    }
  }
  private int partition(int[] array, int start, int end) {
   int left=start;
   int right= end;
   int pivot=array[left];
   while(left<right) {
     while(array[left]<pivot) {
       left++;
     }
     while(array[right]>pivot) {
       right--;
     }
     if(left<right) {
       swap(array, left, right);
  //     left++;
    //   right--;
     }
   }
   array[left]=array[right];
   array[right]=pivot;
   return right;
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left]=array[right];
    array[right]=temp;
  }
  public static void main(String[] args) {
    QuickSort sorter = new QuickSort();
    int [] arr = {10,4,3,5,6,1,8,2,6};
    sorter.sort(arr);
    for(int i=0; i< arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
  }

}
