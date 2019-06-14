package collections.list.arrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrayListTest {
  private List list = new ArrayList();
  Map m = new TreeMap(new Comparator() {
    public int compare(Object o1, Object o2) {
      return 0;
    }
  });
  public ArrayListTest() {

  }
  public void fillList() {
    list.add("abc");
    list.add("bcd");
    list.add("cdb");
    list.add("abcd");
    list.add("abce");
    list.add("abcf");
  }

  public static void main(String[] args) {
    ArrayListTest test = new ArrayListTest();
    test.fillList();
    System.out.println(test.list.get(3));
    test.list.remove("cdb");
    System.out.println(test.list.get(3));
  }

}
