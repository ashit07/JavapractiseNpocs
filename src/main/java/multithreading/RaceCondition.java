package multithreading;


public class RaceCondition {

  static int x = 0, y = 0;
  private final static Object obj = new Object();

  int setX() {
    int i = 0;
    synchronized (obj) {
      x = 1;
      i = y;
      System.out.println("X is " + x);
    }
    return i;
  }

  int setY() {
    int j = 0;
    synchronized (obj) {
      j = x;
      y = 1;

      System.out.println("y is " + y);
    }
    return j;
  }

  public static void main(String[] args) throws InterruptedException {


    Runnable r1 = new Runnable() {
      public void run() {
        System.out.println("Thread 1 " + (new RaceCondition()).setX());
      }
    };

    Runnable r2 = new Runnable() {
      public void run() {
        System.out.println("Thread 2 " + (new RaceCondition()).setY());

      }
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.join();
    t1.start();
    t2.start();
  }
}

