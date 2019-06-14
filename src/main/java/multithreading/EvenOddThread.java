package multithreading;

public class EvenOddThread {
  public boolean flag = true;
  private Object lock = new Object();
  public EvenOddThread() {
  }

  Runnable odd = new Runnable() {

    public void run() {
      for(int i=1; i<20;i=i+2) {
      synchronized (lock) {
        if(!flag) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        flag = false;
        System.out.println(i);
        lock.notifyAll();
      }
     }

    }
  };

  Runnable even = new Runnable() {

    public void run() {
      for(int i=2; i<=20;i=i+2) {
      synchronized (lock) {
        if(flag) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        flag = true;
        System.out.println(i);
        lock.notifyAll();
      }
     }

    }
  };

public static void main(String[] args) {
  EvenOddThread obj = new EvenOddThread();
  Thread t1 = new Thread(obj.odd);
  Thread t2 = new Thread(obj.even);
  t1.start();
  t2.start();
}

}
