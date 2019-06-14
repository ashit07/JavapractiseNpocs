package puzzles.jpMorgan;

public class Main2 {
  boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
    if (l1.x > r2.x || l2.x > r1.x)
      return false;
    if (l1.y < r2.y || l2.y < r1.y)
      return false;

    return true;
  }

  public static void main(String[] args) {

    String str1 = "0 0 1 1 -1 -1 1 1";

    String[] strArr = str1.split(" ");
    int[] vals = new int[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      vals[i] = Integer.parseInt(strArr[i]);
    }
    Point topLeft1 = new Point(vals[0], vals[0] + vals[3]),
        bottomRight1 = new Point(vals[0] + vals[2], vals[1]);
    Point topLeft2 = new Point(vals[4], vals[4] + vals[7]),
        bottomRight2 = new Point(vals[4] + vals[6], vals[5]);
    Main2 obj = new Main2();
    System.out.println(obj.doOverlap(topLeft1, bottomRight1, topLeft2, bottomRight2));
  }
}


class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
