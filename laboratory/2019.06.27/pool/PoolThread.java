package pool;

public class PoolThread extends Thread {
  private BlockingQueue<Runnable> taskQueue;
  private boolean isStopped = false;

  public PoolThread(BlockingQueue<Runnable> queue) {
    taskQueue = queue;
  }

  public void run () {
    while (!isStopped()) {
      try {
        Runnable runnable = (Runnable) taskQueue.dequeue();
        runnable.run();
      } catch (Exception e) {
        // System.err.printf("ERROR: %s\n", e.getMessage());
      }
    }
  }

  public synchronized void doStop() {
    isStopped = true;
    // Break pool thread out of dequeue() call.
    this.interrupt();
  }

  public synchronized boolean isStopped() {
    return isStopped;
  }
}
