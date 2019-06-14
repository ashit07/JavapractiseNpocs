package multithreading;

import java.util.Vector;

public class ProducerConsumerWaitVector {
  public static void main(String[] args) {
    final Vector share = new Vector();
    Thread produce = new Thread(new Producer(share));
    Thread consume = new Thread(new Consumer(share));
    produce.start();
    try {
      consume.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    consume.start();
  }

}


class Producer implements Runnable {
  public final Vector share;

  Producer(Vector share) {
    this.share = share;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      synchronized (share) {
        if (!share.isEmpty()) {
          try {
            System.out.println("Waiting to produce");
            share.wait();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        System.out.println("Produced: " + i);
        share.add(i);
        share.notify();
      }
    }
  }
}


class Consumer implements Runnable {
  public final Vector share;

  Consumer(Vector share) {
    this.share = share;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      synchronized (share) {
        if (share.isEmpty()) {
          try {
            System.out.println("Waiting to consume");
            share.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println("Consumed: " + i);
        share.remove(0);
        share.notify();

      }
    }
  }
}
