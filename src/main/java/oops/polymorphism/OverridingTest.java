package oops.polymorphism;

import java.io.FileNotFoundException;

class Base {
int i;
Base() {
  System.out.println("Base Constructor");
  try {
  display(20);
  } catch(Exception e) {

  }
}

//public final void display(final Integer i) {
//  System.out.println("Base: "+i);
//}
public void display(final int i) throws RuntimeException{
  System.out.println("Base: "+i);
  throw new RuntimeException();
//  return i;
}


}
class Child1 extends Base{
 Child1() {
   System.out.println("Child1 constructor");
   display(30);
 }
 public void display(final int i) throws RuntimeException{
   super.display(40);
   System.out.println("Child1: "+i);
 }
}

public class OverridingTest {

  public static void main(String [] args) {
    Base base = new Child1();

    //Base base = new Base();
//    try {
//      base.display(20);
//    } catch (Exception e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
  }


}
