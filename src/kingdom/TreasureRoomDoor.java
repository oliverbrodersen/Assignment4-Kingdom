package kingdom;

import kingdom.Flyweight.Valuable;

import java.util.List;

public interface TreasureRoomDoor {

    void acquireReadAccess(String actorName);

    void acquireWriteAccess(String actorName);

    void releaseReadAccess(String actorName);

    void releaseWriteAccess(String actorName);

    Valuable retrieveValuable();

    void addValuable(Valuable v);

    List<Valuable> lookAtAllGems();

}
