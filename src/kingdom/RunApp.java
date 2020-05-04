package kingdom;

import kingdom.Factory.GemDeposit;
import kingdom.Factory.GemMineWorker;
import kingdom.Factory.GemTransporter;

public class RunApp
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new GemDeposit(15);
    Thread t1 = new Thread(new GemMineWorker(gemDeposit));
    Thread t2 = new Thread(new GemMineWorker(gemDeposit));
    Thread t3 = new Thread(new GemMineWorker(gemDeposit));

    Thread t4 = new Thread(new GemTransporter(gemDeposit));
    Thread t5 = new Thread(new GemTransporter(gemDeposit));
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
