package kingdom.Factory;

import kingdom.ArrayList.ArrayList;
import kingdom.Catalog;
import kingdom.Flyweight.Valuable;
import kingdom.TreasureRoomDoor;
import kingdom.TresureRoomGuardsman;

import java.util.Random;

public class GemTransporter implements Runnable
{
  protected GemDeposit queue;
  int target, current = 0;
  ArrayList<Valuable> itemQueue;
  String name;
  private TresureRoomGuardsman treasureRoom;

  public GemTransporter(GemDeposit queue, TresureRoomGuardsman treasureRoom,String name){
    this.queue = queue;
    itemQueue = new ArrayList<>();
    target = new Random().nextInt(1400) + 100;
    this.treasureRoom = treasureRoom;
    this.name = name;
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
          take(itemQueue);
        }
      }
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Deposit interrupted", true);
    }
  }

  private void take(ArrayList<Valuable> valuables)
  {
    try{
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      Catalog.getInstance().log("Deposit interrupted", true);
    }
    for (int i = 0; i < valuables.size(); i++)
    {
        treasureRoom.acquireWriteAccess(name);
        treasureRoom.addValuable(valuables.get(i));
        Catalog.getInstance()
            .log("Deposited valuable: " + valuables.get(i), true);
        itemQueue.remove(valuables.get(i));
        treasureRoom.releaseWriteAccess(name);
    }
    target = new Random().nextInt(1400) + 100;
  }
}
