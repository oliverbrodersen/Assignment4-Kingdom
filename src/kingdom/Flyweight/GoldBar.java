package kingdom.Flyweight;

public class GoldBar implements Valuable
{
  @Override public String getName()
  {
    return "Gold Bar";
  }

  @Override public int getValue()
  {
    return 1000;
  }
}
