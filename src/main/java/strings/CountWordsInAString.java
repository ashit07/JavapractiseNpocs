package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountWordsInAString {
  public Map<String, Integer> countAndSortWordsInAStringKey(String str) {
    if (str == null || str.equals("")) {
      return null;
    }
    String[] stringToken = str.trim().split(" ");
    Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
    if (stringToken.length == 1) {
      sortedMap.put(stringToken[0].toLowerCase(), 1);
      return sortedMap;
    }
    for (int i = 0; i < stringToken.length; i++) {
      if (sortedMap.containsKey(stringToken[i].trim().toLowerCase())) {
        sortedMap.put(stringToken[i].trim().toLowerCase(), sortedMap.get(stringToken[i]) + 1);
      } else {
        sortedMap.put(stringToken[i].trim().toLowerCase(), 1);
      }
    }
    return sortedMap;
  }

  void printMap(Map<String, Integer> sortedMap) {
    Set<String> set = sortedMap.keySet();
    System.out.println("Word----Count");
    System.out.println("");
    for (String s : set) {
      System.out.println(s + "----" + sortedMap.get(s));
    }
  }

  void countAndSortWordsInAStringValues(final Map<String, Integer> sortedMap) {
    Comparator c = new Comparator() {
      public int compare(Object paramT1, Object paramT2) {
        if (paramT1 instanceof Entry && paramT2 instanceof Entry) {
          return (((Entry) paramT2).getValue().toString())
              .compareTo(((Entry) paramT1).getValue().toString());
        } else {
          return -1;
        }
      }
    };
    Set<Entry<String, Integer>> sortedSet = sortedMap.entrySet();
    ArrayList<Entry<String, Integer>> list = new ArrayList<>(sortedSet);
    Collections.sort(list, c);
    Iterator<Entry<String, Integer>> itr = list.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  public static void main(String[] args) {
    CountWordsInAString obj = new CountWordsInAString();
    String str =
        "This is just a test. Hope you do good in this test. please let me know the result of this test.";
    Map<String, Integer> sortedMap = obj.countAndSortWordsInAStringKey(str);
    obj.printMap(sortedMap);
    System.out.println("");
    System.out.println("After sorting with value");
    System.out.println("");
    obj.countAndSortWordsInAStringValues(sortedMap);
  }
}
