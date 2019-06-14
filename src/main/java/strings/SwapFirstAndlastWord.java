package strings;

public class SwapFirstAndlastWord {
  public String swapIt(String str) {
    if (str == null || str.equals(""))
      return null;
    String[] strArray = str.trim().split(" ");
    if (strArray.length == 1) {
      return str;
    }
    int firstIndex = 0;
    int lastIndex = strArray.length - 1;
    while (firstIndex != lastIndex && (lastIndex - firstIndex > 0)) {
      String temp = strArray[firstIndex];
      strArray[firstIndex] = strArray[lastIndex];
      strArray[lastIndex] = temp;
      firstIndex++;
      lastIndex--;
    }
    StringBuffer strBuf = new StringBuffer();
    for (int i = 0; i < strArray.length; i++) {
      strBuf.append(strArray[i]);
      strBuf.append(" ");
    }

    return new String(strBuf);
  }


  public static void main(String[] args) {
    String str = "you are a java programmer yes";
    System.out.println(str);
    SwapFirstAndlastWord obj = new SwapFirstAndlastWord();
    String swapped = obj.swapIt(str);
    System.out.println(swapped);
  }
}
