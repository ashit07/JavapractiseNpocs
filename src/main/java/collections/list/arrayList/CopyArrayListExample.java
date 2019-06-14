package collections.list.arrayList;

import java.util.ArrayList;
import java.util.List;

public class CopyArrayListExample {

  private void fillArrayList(List<String> alphabets) {
    alphabets.add("a");
    alphabets.add("b");
  }

  private List<String> getAlphabets() {
    List<String> alphabets = new ArrayList<String>();

    fillArrayList(alphabets);
    return alphabets;
  }

  public static void main(String[] args) {
    List<String> alph = new CopyArrayListExample().getAlphabets();
    for (String chara : alph) {
      System.out.println(chara + " ");
      alph.remove(chara);
    }
    System.out.println("-----------");
    List<String> alph2 = new CopyArrayListExample().getAlphabets();
    List<String> alph2Copy = new ArrayList<String>();
    alph2Copy.addAll(alph2);
    for (String chara : alph2Copy) {
      System.out.println(chara + " ");
      alph2.remove(chara);
    }
  }
}
