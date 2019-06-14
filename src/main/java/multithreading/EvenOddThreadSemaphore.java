package multithreading;

import java.util.concurrent.Semaphore;

class PrintEvenOdd implements Runnable{

  private Semaphore s1;
  private Semaphore s2;
  int val;
  public PrintEvenOdd(int val, Semaphore s1, Semaphore s2) {
    this.val=val;
    this.s1=s1;
    this.s2=s2;
  }

  public void run() {
    while(val<20) {
    try {
      s1.acquire();
      System.out.println(val);
      val=val+2;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally{
      s2.release();
    }
  }
  }
}
public class EvenOddThreadSemaphore {
  public static void main(String[] args) {
    Semaphore s1 = new Semaphore(1, true);
    Semaphore s2 = new Semaphore(0, true);
    Thread t1 = new Thread(new PrintEvenOdd(1, s1, s2));
    Thread t2 = new Thread(new PrintEvenOdd(2, s2, s1));
    t1.start();
    t2.start();

  }
}
