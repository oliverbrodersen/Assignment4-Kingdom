package kingdom;

import kingdom.Factory.GemDeposit;
import kingdom.Factory.GemMineWorker;
import kingdom.Factory.GemTransporter;

public class RunApp
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new GemDeposit(15);
    TresureRoomGuardsman tresureRoomGuardsman = new TresureRoomGuardsman();
    Thread t1 = new Thread(new GemMineWorker(gemDeposit));
    Thread t2 = new Thread(new GemMineWorker(gemDeposit));
    Thread t3 = new Thread(new GemMineWorker(gemDeposit));

    Thread t4 = new Thread(new GemTransporter(gemDeposit, tresureRoomGuardsman, "oliver"));
    Thread t5 = new Thread(new GemTransporter(gemDeposit, tresureRoomGuardsman, "Benjamin"));
    Thread t6 = new Thread(new GemTransporter(gemDeposit, tresureRoomGuardsman, "Odin"));

    Thread t7 = new Thread(new Accountant(tresureRoomGuardsman, "Accountant"));

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
  }
}
