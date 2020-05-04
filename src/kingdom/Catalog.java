package kingdom;

import kingdom.ArrayList.ArrayList;

public class Catalog
{
  private static Catalog instance;
  private ArrayList<String> log = new ArrayList<>();

  private Catalog(){
  }

  public static Catalog getInstance(){
    if (instance == null){
      instance = new Catalog();
    }
    return instance;
  }

  public void log(String entry, boolean post){
    log.add(entry);
    if (post)
      System.out.println(entry);
  }
}
