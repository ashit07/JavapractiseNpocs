package multithreading;

import java.util.concurrent.Semaphore;

public class UsingSemaphore implements Runnable {
  String name;
  Semaphore sema;

  public UsingSemaphore(String name, Semaphore sema) {
    this.name = name;
    this.sema = sema;
  }

  @Override
  public void run() {
    System.out.println(name + " entering");
    try {
      sema.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(name + " executing");
    System.out.println(name + " releaseing");
    sema.release();
  }
}
