package multithreading;

import java.util.concurrent.CountDownLatch;

class Racing extends Thread {
  private String name;
  private CountDownLatch counting;

  Racing(String name, CountDownLatch count) {
    counting = count;
    this.name = name;
    start();
  }

  public void run() {
    try {
      counting.await();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Running...." + name);
  }
}


public class CountDownLatchExample {
  public static void main(String[] args) {
    CountDownLatch count = new CountDownLatch(5);
    new Racing("First", count);
    new Racing("Second", count);
    new Racing("Third", count);
    long countVal = count.getCount();
    System.out.println("Counting");
    while (countVal > 0) {
      System.out.println(countVal);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      count.countDown();
      countVal = count.getCount();
    }
  }
}
