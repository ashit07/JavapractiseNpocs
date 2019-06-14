package collections.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
  Map hm = new HashMap();

  public void addToHashMap(final Object key, final Object value) {
    hm.put(key, value);
  }

  public void displayMap() {
    final Set<Entry> mapEntry = hm.entrySet();
    if (mapEntry.size() == 0) {
      System.out.println("Empty MAp");
    }
    for (final Entry e : mapEntry) {
      System.out.println("Key is " + e.getKey() + " and value is " + e.getValue());
    }
    System.out.println("-----------");
  }

  public void addAnotherMap() {
    Map m = new HashMap();
    m.put("3", "56");
    hm.putAll(m);
  }

  public static void main(final String[] args) {
    final TestHashMap obj = new TestHashMap();
    obj.addToHashMap("2", "10");
    // obj.displayMap();
    // obj.addToHashMap("2", "3");
    obj.displayMap();
    obj.addAnotherMap();
    obj.displayMap();
    Set abc = new HashSet();
    abc.add("abc");
    Map m = new HashMap();
    m.put("a", abc);
    Set newSet = (Set) m.get("a");
    System.out.println(newSet.size());
    System.out.println("----------------");
    obj.getMapFromMap();
  }

  public void getMapFromMap() {
    Map<String, Map<String, String>> dummMap = new ConcurrentHashMap<>();
    Map<String, String> dnMap = new HashMap<>();
    dnMap.put("dn1", "DN-1");
    dnMap.put("dn2", "DN-2");
    dnMap.put("dn3", "DN-3");
    dnMap.put("dn4", "DN-4");
    dnMap.put("dn5", "DN-5");
    dummMap.put("1", dnMap);
    Map<String, String> dnMap2 = new HashMap<>();
    dnMap2.put("dn21", "DN-21");
    dnMap2.put("dn22", "DN-22");
    dnMap2.put("dn23", "DN-23");
    dnMap2.put("dn24", "DN-24");
    dnMap2.put("dn25", "DN-25");
    dummMap.put("2", dnMap2);

    System.out.println(dummMap.get("2"));
  }
}
