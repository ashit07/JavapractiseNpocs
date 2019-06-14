package multithreading;

import java.util.Vector;

class Producer implements Runnable {
  private final Vector sharedQueue;

  Producer(Vector sharedQueue) {
    this.sharedQueue = sharedQueue;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Produced: " + i);
      produce(i);
      try {
        Thread.sleep(500);
      } catch (Exception e) {
        System.out.println("In Producer Class");
      }
    }


  }

  void produce(int i) {
    synchronized (sharedQueue) {
      sharedQueue.add(i);
      sharedQueue.notifyAll();
    }
  }
}


class Consumer implements Runnable {
  private final Vector sharedQueue;

  Consumer(Vector sharedQueue) {
    this.sharedQueue = sharedQueue;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println("Consummed: " + consume());
        Thread.sleep(500);
      } catch (Exception e) {

      }

    }
  }

  int consume() throws InterruptedException {
    while (sharedQueue.isEmpty()) {
      synchronized (sharedQueue) {
        System.out.println("Consume Empty");
        sharedQueue.wait();
      }
    }
    synchronized (sharedQueue) {
      sharedQueue.notifyAll();
      return (Integer) sharedQueue.remove(0);
    }

  }

}


public class ProducerConsumerWaitNotify {
  public static void main(String[] args) {

    Vector sharedQueue = new Vector();
    Thread prodThread = new Thread(new Producer(sharedQueue), "Producer");
    Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
    prodThread.start();
    consThread.start();
  }
}
