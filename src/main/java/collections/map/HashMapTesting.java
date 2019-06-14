package collections.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTesting {

  public static void main(String[] args) {
    ConcurrentHashMap map;
 // checkModifyingObjects();
  testKeysAsObjects();

  }

  private static void testKeysAsObjects() {
    Map<ObjKey, String> mapOne = new HashMap<ObjKey, String>();
    Integer i = 2;
    mapOne.put(new ObjKey(), "200");
    mapOne.put(new ObjKey(), "200");
    mapOne.put(new ObjKey(), "200");
    mapOne.put(new ObjKey(), "200");

    System.out.println(mapOne.size());


  }

  private static void checkModifyingObjects() {
    Map<String, String> mapOne = new HashMap<String, String>();
    mapOne.put("key11", "val11");
    mapOne.put("key12", "val12");
    mapOne.put("key13", "val13");
    mapOne.put("key14", "val14");
    mapOne.put("key15", "val15");


    Map<String, Map<String, String>> mapTwo = new HashMap<String, Map<String,String>>();
    mapTwo.put("key21", mapOne);
    System.out.println(mapTwo.get("key21").get("key12"));
    mapTwo.get("key21").put("key12", "valChanged");
    System.out.println(mapTwo.get("key21").get("key12"));
  }
  public List<Entry<String, Integer>> sortByValue(Map<String, Integer> map) {
    Set<Entry<String, Integer>> entrySet = map.entrySet();
    List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(entrySet);
    Collections.sort(list, new Comparator<Entry<String,Integer>>() {
      public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
      }
    });
    return list;
  }

}

class ObjKey extends Object{
  String name;
  int id;
  public ObjKey() {
    name="name";
    id=2;
  }

  @Override
  public int hashCode() {
    return 4;
  }
  @Override
  public boolean equals(Object obj) {
    return true;
  }
}
