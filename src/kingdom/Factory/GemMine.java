package kingdom.Factory;

import kingdom.Flyweight.GoldBar;
import kingdom.Flyweight.GoldNugget;
import kingdom.Flyweight.Valuable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GemMine
{
  private static Map<String, Valuable> valuableCache = new HashMap<>();
  private static String[] valuableTypes = {"Gold bar", "Gold nugget"};

  public static Valuable getValuable(String type){
    Valuable valuable = valuableCache.get(type);
    if (valuable == null){
      switch (type.toLowerCase()){
        case "gold bar": valuable = new GoldBar(); break;
        case "gold nugget": valuable = new GoldNugget(); break;
      }
      valuableCache.put(type, valuable);
    }
    return valuable;
  }
  public static Valuable getValuable(){
    int rand = new Random().nextInt(valuableTypes.length);
    return getValuable(valuableTypes[rand]);
  }
}
