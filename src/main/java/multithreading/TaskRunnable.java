package multithreading;

public class TaskRunnable implements Runnable {

  private Task task = null;

  public TaskRunnable(String info) {
    task = new Task(info);
  }

  @Override
  public void run() {
    System.out.println("Run tasks");
  }

  public Task getTask() {
    return task;
  }

  class Task {
    String info;

    Task(String info) {
      this.info = info;
    }

    public String getInfo() {
      return info;
    }

    public void setInfo(String info) {
      this.info = info;
    }

  }
}
