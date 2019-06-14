package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorWithRejectionHandler {

  public ThreadPoolExecutor createThreadPoolExecutor() {
    int corePoolSize = 2;
    int maximumPoolSize=5;
    long keepAliveTime=3000;
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(3);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue , new RejectionHandler());
    return executor;
  }

  public static void main(String[] args) {

    ThreadPoolExecutor executor = new ThreadPoolExecutorWithRejectionHandler().createThreadPoolExecutor();
    executor.execute(new RunnableClass(1));
    executor.execute(new RunnableClass(2));
    executor.execute(new RunnableClass(3));
    executor.execute(new RunnableClass(4));
    executor.execute(new RunnableClass(5));
    executor.execute(new RunnableClass(6));
    executor.execute(new RunnableClass(7));
    executor.execute(new RunnableClass(8));
    executor.execute(new RunnableClass(9));
    executor.execute(new RunnableClass(10));
    executor.execute(new RunnableClass(11));
    executor.execute(new RunnableClass(12));
    executor.execute(new RunnableClass(13));

    executor.shutdown();
  }


}
class RejectionHandler implements RejectedExecutionHandler {

  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    RunnableClass obj = (RunnableClass) r;
    System.out.println("Rejected task "+obj.id);
    try{
      Thread.sleep(3000);
    } catch(Exception e) {

    }
    executor.submit(obj);
  }

}
class RunnableClass implements Runnable {
  int id;
  RunnableClass (int id) {
    this.id=id;
  }

  public void run() {
    System.out.println(Thread.currentThread().getName()+"--->"+id);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

