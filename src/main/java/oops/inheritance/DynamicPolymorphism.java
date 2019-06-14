package oops.inheritance;

class BaseClass {
 BaseClass () {
   System.out.println("Base Class");
 }

 public void method1(){
   System.out.println("Base...");
   method2(3);
 }
 public void method2(int i) {
   System.out.println("Base...."+i);
 }

}
class Derived1 extends BaseClass {
  Derived1 (int i) {
    System.out.println("Derived 1");
  }

//  public void method1(){
 //   System.out.println("Derived1...");
  //}
}

class Derived2 extends Derived1 {
  Derived2(int i, int j) {
    super(i);
    System.out.println("Derived 2");
  }
//  public void method1(){
  //  System.out.println("Derived2...");
 // }
  public void method2(int i) {
    System.out.println("Derived2...."+i);
  }
  public void method3(int i) {
    System.out.println("Derived2...."+i);
  }

}


public class DynamicPolymorphism {

public static void main(String[] args) {
   BaseClass b = new Derived2(2, 3);
  // Derived1 d1 = new Derived2(4, 5);
   //d1.method1();

   b.method2(2);


}

}
