package kingdom;

import kingdom.Flyweight.Valuable;

import java.util.List;

public class Accountant implements Runnable
{
  TresureRoomGuardsman tresureRoomGuardsman;
  String name;

  public Accountant(TresureRoomGuardsman tresureRoomGuardsman, String name){
    this.tresureRoomGuardsman = tresureRoomGuardsman;
    this.name = name;
  }

  @Override public void run()
  {
    while(true){
      tresureRoomGuardsman.acquireReadAccess(name);
      List<Valuable> gems = tresureRoomGuardsman.lookAtAllGems();
      int worth = 0;
      for (int i = 0; i < gems.size(); i++)
      {
        worth += gems.get(i).getValue();
        try{
          Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
          //e.printStackTrace();
        }
      }
      Catalog.getInstance().log("Treasure room's total worth is: " + worth, true);
      tresureRoomGuardsman.releaseReadAccess(name);
      try{
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        //e.printStackTrace();
      }
    }
  }
}
