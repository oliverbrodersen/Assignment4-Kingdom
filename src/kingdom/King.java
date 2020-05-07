package kingdom;

import kingdom.ArrayList.ArrayList;
import kingdom.Flyweight.Valuable;

import java.util.Random;

public class King implements Runnable{

    private TresureRoomGuardsman tresureRoomGuardsman;
    private String name;
    private ArrayList<Valuable> valuables;
    private int target, current;

    public King(TresureRoomGuardsman treasureRoom, String name){
        this.tresureRoomGuardsman = treasureRoom;
        this.name = name;
        target = new Random().nextInt(10000) + 5000;
        current = 0;
        valuables = new ArrayList<>();
    }

    @Override
    public void run() {
       try {
           while (true) {
               Thread.sleep(500);
               tresureRoomGuardsman.acquireWriteAccess(name);
               Valuable valuable = tresureRoomGuardsman.retrieveValuable();
               if (valuable == null)
               {
                   Catalog.getInstance().log("Not enough valuables to throw a party", true);
                   for (int i = 0; i < valuables.size(); i++) {
                       tresureRoomGuardsman.addValuable(valuables.get(i));
                       Thread.sleep(20);
                   }
                   valuables = new ArrayList<>();
                   target = new Random().nextInt(10000) + 5000;
                   current = 0;
                   tresureRoomGuardsman.releaseWriteAccess(name);
                   Thread.sleep(2000);
                   continue;
               }
               tresureRoomGuardsman.releaseWriteAccess(name);
               valuables.add(valuable);
               current += valuable.getValue();
               if (current >= target)
               {
                   Catalog.getInstance().log("PARTY TIME! Thanks King!", true);
                   valuables = new ArrayList<>();
                   target = new Random().nextInt(10000) + 5000;
                   current = 0;
                   Thread.sleep(2000);
               }
           }
       }
       catch (InterruptedException e)
       {
           Catalog.getInstance().log("King check interrupted",true);
       }
    }
}
