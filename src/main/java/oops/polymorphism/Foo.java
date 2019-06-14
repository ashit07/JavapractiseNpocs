package oops.polymorphism;

public class Foo {
  Foo() {
    System.out.println("Foo");
  }

  void display() {
    System.out.println("Foo class");
  }

  public static void main(String[] args) {
    Foo b = new Bar();
    try {
      b.display();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


class Bar extends Foo {
  Bar() {
    System.out.println("Bar");
  }

  protected void display() {
    super.display();
    System.out.println("Bar class");
  }

  public void display2() {
    System.out.println("Display 2");
  }

}
