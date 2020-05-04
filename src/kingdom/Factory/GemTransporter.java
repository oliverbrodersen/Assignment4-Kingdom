package kingdom.Factory;

import kingdom.ArrayList.ArrayList;
import kingdom.Catalog;
import kingdom.Flyweight.Valuable;

import java.util.Random;

public class GemTransporter implements Runnable
{
  protected GemDeposit queue;
  int target, current = 0;
  ArrayList<Valuable> itemQueue;
  public GemTransporter(GemDeposit queue){
    this.queue = queue;
    itemQueue = new ArrayList<>();
    target = new Random().nextInt(1400) + 100;
  }

  @Override public void run()
  {
    try{
      while(true){
        Valuable valuable = (Valuable) queue.dequeue();
        itemQueue.add(valuable);
        current += valuable.getValue();
        if (current >= target)
        {
          Catalog.getInstance().log("Deposited resource - Que size is now = " + queue.size(),
              true);
          //It should take the queue
          take(valuable);
        }
      }
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Deposit interrupted", true);
    }
  }

  private void take(Valuable valuable)
  {
    try{
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Deposit interrupted", true);
    }
    Catalog.getInstance().log("Deposited valuable: " + valuable, true);
    target = new Random().nextInt(1400) + 100;
  }
}
