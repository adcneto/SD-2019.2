package pool;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
  private List<T> queue = new LinkedList<>();
  private int limit = 10;

  public BlockingQueue(int limit) {
    this.limit = limit;
  }

  public synchronized void enqueue(T item) throws InterruptedException {
    while (this.queue.size() == this.limit) {
      wait();
    }

    if (this.queue.size() == 0) {
      notifyAll();
    }

    this.queue.add(item);
  }

  public synchronized T dequeue() throws InterruptedException {
    while (this.queue.size() == this.limit) {
      wait();
    }

    if (this.queue.size() == 0) {
      notifyAll();
    }

    return this.queue.remove(0);
  }
}
