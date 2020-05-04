package kingdom.Flyweight;

public class GoldNugget implements Valuable
{
  @Override public String getName()
  {
    return "Gold Nugget";
  }

  @Override public int getValue()
  {
    return 100;
  }
  public String toString(){
    return "Gold nugget";
  }
}
