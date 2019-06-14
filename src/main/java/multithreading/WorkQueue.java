package multithreading;

import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.log4j.Logger;

class WorkQueue {
  private static final int nThreads = 20;
  private final PoolWorker[] threads;
  private final LinkedList<TaskRunnable> queue;
  private final LinkedList<String> ongoingTasks;

  private static final WorkQueue INSTANCE = new WorkQueue();
  private static final Logger LOG = Logger.getLogger(WorkQueue.class);

  public static WorkQueue getInstance() {
    return INSTANCE;
  }

  private WorkQueue() {
    queue = new LinkedList<TaskRunnable>();
    threads = new PoolWorker[nThreads];
    ongoingTasks = new LinkedList<String>();

    for (int i = 0; i < nThreads; i++) {
      threads[i] = new PoolWorker();
      threads[i].setIdentifier(i);
      threads[i].start();
    }
  }

  public void execute(TaskRunnable r) {
    boolean added = true;

    synchronized (queue) {
      boolean alreadyInQueue = false;

      // checking whether exists already in queue
      for (TaskRunnable hvRunnable : queue) {
        if (r.getTask().getInfo().compareTo(hvRunnable.getTask().getInfo()) == 0) {
          alreadyInQueue = true;
          break;
        }
      }

      // checking whether exists already in ongoingTasks
      for (String info : ongoingTasks) {
        if (r.getTask().getInfo().compareTo(info) == 0) {
          alreadyInQueue = true;
          break;
        }
      }

      if (!alreadyInQueue) {
        queue.addLast(r);
        queue.notifyAll();
      } else {
        added = false;
      }
    }
    int size = queue.size();

    TaskRunnable runnable = r;
    if (added) {
      LOG.debug(new StringBuilder().append("new bg task added to queue (")
          .append(runnable.getTask().getInfo()).append("), size of queue = ").append(size));
    } else {
      LOG.debug(new StringBuilder().append("task not added , exists already in queue (")
          .append(runnable.getTask().getInfo()).append("), size of queue = ").append(size));
    }
  }

  public boolean isTaskOngoing(TaskRunnable r) {
    synchronized (queue) {
      boolean existsInQueue = false;

      for (TaskRunnable hvRunnable : queue) {
        if (r.getTask().getInfo().compareTo(hvRunnable.getTask().getInfo()) == 0) {
          existsInQueue = true;
          LOG.debug("task exists in queue: " + r.getTask().getInfo());
          break;
        }
      }

      for (String info : ongoingTasks) {
        if (r.getTask().getInfo().compareTo(info) == 0) {
          existsInQueue = true;
          LOG.debug("task found in ongoingTasks: " + r.getTask().getInfo());
          break;
        }
      }

      if (!existsInQueue) {
        LOG.debug("task does not exist in queues: " + r.getTask().getInfo());
      }
      return existsInQueue;
    }
  }

  public void removeOngoingTask(String info) {
    if (info == null) {
      return;
    }

    synchronized (queue) {

      ListIterator<String> targetItr = ongoingTasks.listIterator();

      while (targetItr.hasNext()) {
        String task = targetItr.next();
        if (info.compareTo(task) == 0) {
          targetItr.remove();
          LOG.debug("task found and removed from ongoingTasks: " + info);
          break;
        }
      }
    }
  }

  private class PoolWorker extends Thread {
    private int identifier;

    public void setIdentifier(int id) {
      this.identifier = id;
    }

    @Override
    public void run() {
      TaskRunnable r;

      while (true) {
        synchronized (queue) {
          while (queue.isEmpty()) {
            try {
              queue.wait();
            } catch (InterruptedException ignored) {
            }
          }

          r = queue.removeFirst();

          String currentInfo = r.getTask().getInfo();
          ongoingTasks.add(currentInfo);
        }

        int size = queue.size();
        LOG.debug(new StringBuilder().append("bg task taken into run : ")
            .append(r.getTask().getInfo()).append(" , queue size now = ").append(size)
            .append(", bg_worker_id = ").append(this.identifier));

        try {
          r.run();
        } catch (RuntimeException e) {
          LOG.error("Exception occured while executing task " + r.getTask().getInfo(), e);
        } catch (Exception e2) {
          LOG.error("Exception occured while executing task " + r.getTask().getInfo(), e2);
        }
      }
    }
  }
}
