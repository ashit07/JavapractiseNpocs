package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
private  BlockingQueue bq = new LinkedBlockingQueue();

 public static void main(String[] args) {
   ProducerConsumerBlockingQueue inst = new ProducerConsumerBlockingQueue();
   Thread produce = new Thread(inst.producer);
   Thread consume = new Thread(inst.consumer);
   produce.start();
   consume.start();

 }
 Runnable producer = new Runnable() {
   public void run() {
    for(int i=1; i<=10;i++){
      try {
        System.out.println("Producer: "+i);
        bq.put(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
   }
 };

 Runnable consumer = new Runnable() {
   public void run() {
     for(int i=1; i<=10;i++){
      try {
        System.out.println("Consumer: "+bq.take());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
   }
 };
}
