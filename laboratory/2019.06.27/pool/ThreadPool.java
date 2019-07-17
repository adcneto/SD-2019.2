package pool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
  private BlockingQueue<Runnable> taskQueue;
  private List<PoolThread> threads = new ArrayList<>();
  private boolean isStopped = false;

  public ThreadPool(int noOfThreads, int maxNoOfTasks) {
    taskQueue = new BlockingQueue<>(maxNoOfTasks);

    for (int i = 0; i < noOfThreads; i++) {
      threads.add(new PoolThread(taskQueue));
    }

    for (PoolThread thread : threads) {
      thread.start();
    }
  }

  public synchronized void execute(Runnable task) throws Exception {
    if (this.isStopped)
      throw new IllegalStateException("ThreadPool is stopped");
    
    this.taskQueue.enqueue(task);
  }

  public synchronized void stop() {
    this.isStopped = true;

    for (PoolThread thread : threads) {
      thread.doStop();
    }
  }
}
