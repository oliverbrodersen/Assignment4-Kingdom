package kingdom.Factory;

import kingdom.ArrayList.ArrayList;

public abstract class BlockingQueue
{
  private ArrayList queue = new ArrayList<Object>();
  private int limit = 0;

  public BlockingQueue(int limit){
    this.limit = limit;
  }

  public int size(){
    return queue.size();
  }

  public synchronized void enqueue(Object item)
      throws InterruptedException  {
    while(this.queue.size() == this.limit) {
      wait();
    }
    this.queue.add(item);
    if(this.queue.size() == 1) {
      notifyAll();
    }
  }


  public synchronized Object dequeue() throws InterruptedException{
    while(this.queue.size() == 0){
      wait();
    }
    if(this.queue.size() == this.limit){
      notifyAll();
    }

    return this.queue.remove(0);
  }
}
