package oops.inheritance;

class A{
  int i=10;
  public void display() {

  }
}
class B extends A {
  int i=20;
}
class C extends B {
  int k=12;
}
class D extends C {
  int l =13;
}
public class DynamicPolyOnlyVars {

  public static void main(String[] args) {
 // A[] obj = {new A(), new B(), new C(), new D()};
  A obj1 = new B();
  System.out.println(obj1.i);
//    System.out.println(obj[3].i);
//    System.out.println(obj[2].j);
//    System.out.println(obj[1].k);
//    System.out.println(obj[0].m);

  }
}
