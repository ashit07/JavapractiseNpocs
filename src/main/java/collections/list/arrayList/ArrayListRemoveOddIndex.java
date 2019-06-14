package collections.list.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListRemoveOddIndex {

  private List<Integer> list = new ArrayList<Integer> ();
  public ArrayListRemoveOddIndex() {
  }
  public void addToList() {
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);
    list.add(11);
    list.add(12);
  }

  public void removeOddIndexItems() {
    ListIterator<Integer> itr = list.listIterator();
    int count=1;
    while(itr.hasNext()) {
      itr.next();
      if(count%2==1) {
        itr.remove();
      }
      count++;
    }
  }

  public void displayList() {
    for(Integer i: list) {
      System.out.print(i+" ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ArrayListRemoveOddIndex obj = new ArrayListRemoveOddIndex();
    obj.addToList();
    obj.displayList();
    obj.removeOddIndexItems();
    obj.displayList();
  }
}
