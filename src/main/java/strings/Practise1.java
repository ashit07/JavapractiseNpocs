package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise1 {

  public void mergeMapsUsingStreams() {
    System.out.println("----mergeMapsUsingStreams-----");
    Map<String, String> map1 = new HashMap<>();
    map1.put("first", "val1");
    Map<String, String> map2 = new HashMap<>();
    map2.put("second", "val2");
    Map<String, String> map3 = new HashMap<>();
    map3.put("third", "val3");
    Map<String, String> mergedMap = Stream.of(map1.entrySet(), map2.entrySet(), map3.entrySet())
        .flatMap(Set::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    for (String key : mergedMap.keySet()) {
      System.out.println(key + "--" + mergedMap.get(key));
    }
    System.out.println("---------");
  }

  public void mergeMapsUsingPutAll() {
    System.out.println("----mergeMapsUsingPutAll-----");
    Map<String, String> map1 = new HashMap<>();
    map1.put("first", "val1");
    Map<String, String> map2 = new HashMap<>();
    map2.put("second", "val2");
    Map<String, String> map3 = new HashMap<>();
    map3.put("third", "val3");

    Map<String, String> mergedMap = new HashMap<>(map1.size() + map2.size() + map3.size());
    mergedMap.putAll(map1);
    mergedMap.putAll(map2);
    mergedMap.putAll(map3);
    for (String key : mergedMap.keySet()) {
      System.out.println(key + "--" + mergedMap.get(key));
    }
    System.out.println("---------");
  }

  public static void main(String[] args) {
    Practise1 obj = new Practise1();
    obj.mergeMapsUsingPutAll();
    obj.mergeMapsUsingStreams();
  }
}
