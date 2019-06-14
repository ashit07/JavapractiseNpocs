package reflection;

public class MyClass {
  int i;
  int j;
  public MyClass() {
    i=0;
    j=0;
  }
  public MyClass(Integer i, Integer j) {
    this.i=i;
    this.j=j;
  }


  public int getI() {
    return i;
  }



  public void setI(int i) {
    this.i = i;
  }



  public int getJ() {
    return j;
  }



  public void setJ(int j) {
    this.j = j;
  }



  public int sum () {
    return i+j;
  }

  public int sum (Integer o, Integer p) {
    return o+p;
  }
  public int diff() {
    return Math.abs(i-j);
  }
}
