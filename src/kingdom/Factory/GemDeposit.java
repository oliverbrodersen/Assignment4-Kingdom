package kingdom.Factory;

import kingdom.Catalog;
import kingdom.Flyweight.Valuable;

public class GemDeposit extends BlockingQueue
{
  public GemDeposit(int limit)
  {
    super(limit);
  }
}
