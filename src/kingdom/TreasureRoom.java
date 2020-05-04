package kingdom;

import kingdom.Flyweight.Valuable;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
    private List<Valuable> gems;

    public TreasureRoom() {
        gems = new ArrayList<>();
    }

    // access methods

    public synchronized void acquireReadAccess(String actorName) {
        // note in the catalogue a person entered
        Catalog.getInstance().log(actorName + " entered the Treasure room", true);
    }

    public synchronized void acquireWriteAccess(String actorName) {
        // note in the catalogue a person entered
        Catalog.getInstance().log(actorName + " entered the Treasure room", true);
    }

    public synchronized void releaseReadAccess(String actorName) {
        // note in the catalogue a person left
        Catalog.getInstance().log(actorName + " left the Treasure room", true);
    }

    public synchronized void releaseWriteAccess(String actorName) {
        // note in the catalogue a person left
        Catalog.getInstance().log(actorName + " left the Treasure room", true);
    }

    // interact methods

    public Valuable retrieveValuable() {
        Valuable v = null;
        if (gems.size() > 0) {
            v = gems.remove(0);
        }
        return v;
    }

    public void addValuable(Valuable v) {
        gems.add(v);
    }

    @Override
    public List<Valuable> lookAtAllGems() {
        return new ArrayList<Valuable>(gems);
    }
}
