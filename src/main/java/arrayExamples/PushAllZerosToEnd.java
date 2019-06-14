package arrayExamples;

public class PushAllZerosToEnd {
  int[] arr;

  void pushZerosEndUsingSwap() {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == 0) {
        if (arr[i + 1] != 0) {
          swap(i, i + 1);
        } else {
          if ((i + 2) < arr.length - 1) {
            int j = 2;
            while (arr[i + j] == 0) {
              j++;
            }
            swap(i, i + j);
          }
        }
      }
    }

  }

  private void setArray(int[] array) {
    arr = array;
  }

  private void display() {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private void swap(int a, int b) {
    int temp = 0;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public void pushZerosEndUsingTempArray() {
    int[] temparr = new int[arr.length];
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (j < arr.length) {
        while (arr[j] == 0) {
          j++;
        }

        temparr[i] = arr[j];
        j++;
      }
    }
    /*
     * if(temparr.length < arr.length) { int diff = arr.length - temparr.length; int
     * length=temparr.length; System.out.println("Length of temp array is "+length); for(int i = 0;
     * i<diff; i++) temparr[length+i]=0; }
     */
    arr = temparr;
  }


  public static void main(String[] args) {
    int[] aray = {1, 0, 8, 3, 0, 0, 4, 6};
    PushAllZerosToEnd obj = new PushAllZerosToEnd();
    obj.setArray(aray);
    obj.display();
    System.out.println("");
    System.out.println("After replacing");
    System.out.println("");
    obj.pushZerosEndUsingTempArray();
    obj.display();
  }
}
