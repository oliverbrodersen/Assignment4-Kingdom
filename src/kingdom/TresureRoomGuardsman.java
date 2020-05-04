package kingdom;

import kingdom.Flyweight.Valuable;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TresureRoomGuardsman implements TreasureRoomDoor
{
  private static TreasureRoomDoor treasureRoom;

  private boolean activeWriter;
  private int activeReaders;
  private int waitingReaders;

  private int sharedInt;

  public TresureRoomGuardsman(){
    treasureRoom = new TreasureRoom();
  }

  @Override public void acquireReadAccess(String actorName)
  {
    waitingReaders++;
    while(activeWriter){
      try{
        wait();
      }
      catch (InterruptedException e)
      {
        //e.printStackTrace();
      }
    }
    treasureRoom.acquireReadAccess(actorName);
    waitingReaders--;
    activeReaders++;
  }

  @Override public void acquireWriteAccess(String actorName)
  {
    while(!activeWriter || activeReaders == 0 || waitingReaders == 0){
      try{
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    treasureRoom.acquireWriteAccess(actorName);
    activeWriter = true;
  }

  @Override public void releaseReadAccess(String actorName)
  {
    activeReaders--;
    treasureRoom.releaseReadAccess(actorName);
    if (activeReaders == 0)
      notifyAll();
  }

  @Override public void releaseWriteAccess(String actorName)
  {
    activeWriter = false;
    treasureRoom.acquireWriteAccess(actorName);
    notifyAll();
  }

  @Override public Valuable retrieveValuable()
  {
      return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(Valuable v)
  {
      treasureRoom.addValuable(v);
  }

  @Override public List<Valuable> lookAtAllGems()
  {
      return treasureRoom.lookAtAllGems();
  }
}
