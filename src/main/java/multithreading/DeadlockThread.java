package multithreading;

public class DeadlockThread {
  public static void main(String[] args) {
    A obj1 = new A();
    B obj2 = new B();
    Thread t1 = new Thread(new A(obj1, obj2));
    Thread t2 = new Thread(new B(obj1, obj2));
    t1.start();
    t2.start();
  }
}


class A implements Runnable {
  private final A obj1;
  private final B obj2;

  A() {
    obj1 = null;
    obj2 = null;
  }

  A(A obj1, B obj2) {
    this.obj1 = obj1;
    this.obj2 = obj2;
  }

  public void run() {
    while (true) {
      synchronized (obj1) {
        System.out.println("Thread t1: waiting for obj2");
        synchronized (obj2) {
          System.out.println("In Class A");
        }
      }
    }
  }
}


class B implements Runnable {
  private final A obj1;
  private final B obj2;

  B() {
    obj1 = null;
    obj2 = null;
  }

  B(A obj1, B obj2) {
    this.obj1 = obj1;
    this.obj2 = obj2;
  }

  public void run() {
    while (true) {
      synchronized (obj2) {
        System.out.println("Thread t2: waiting for obj1");
        synchronized (obj1) {
          System.out.println("In class B");
        }
      }
    }
  }
}
