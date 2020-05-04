package kingdom.Factory;

import kingdom.Catalog;
import kingdom.Flyweight.Valuable;

public class GemMineWorker implements Runnable
{
  private GemDeposit queue;

  public GemMineWorker(GemDeposit queue){
    this.queue = queue;
  }

  @Override public void run()
  {
    try{
      while(true){
        Valuable justProduced = getResource();
        queue.enqueue(justProduced);
        Catalog.getInstance().log("Produced valuable - Queue size now = " + queue.size(), true);
      }
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Gem mine worker Interupted", true);
    }
  }

  private Valuable getResource()
  {
    try{
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Gem mine worker Interupted", true);
    }
    return GemMine.getValuable();
  }

}
