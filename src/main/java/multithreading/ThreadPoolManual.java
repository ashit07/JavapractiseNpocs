package multithreading;

import java.util.LinkedList;

public class ThreadPoolManual {
private LinkedList<Integer> queue = new LinkedList<Integer>();
private PoolWorker[] threads;
private int numThreads=10;

public static void main(String [] args) {
  ThreadPoolManual pool = new ThreadPoolManual();
  for(int i=0; i< 20; i++)
    pool.addToQueue(i);
}
  public ThreadPoolManual () {
    threads = new PoolWorker[numThreads];
    for(int i=0; i<numThreads; i++) {
      threads[i] = new PoolWorker();
      threads[i].start();
    }
   }
  public void addToQueue(Integer val) {
    synchronized (queue) {
      queue.add(val);
      queue.notifyAll();
    }

  }


  private class PoolWorker extends Thread {

    public void run() {
      synchronized(queue) {
        while(queue.isEmpty()) {
          try {
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName()+" : "+queue.removeFirst());
        queue.notify();
      }

    }


  }



}
