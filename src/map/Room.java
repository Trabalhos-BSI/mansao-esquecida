package map;

import entities.PhantomType;

import java.util.Set;

public class Room extends Location {

    public Room(int id, String description) {
        super();
        this.id = id;
        this.description = description;

        this.type = LocationType.ROOM;

        this.availablePhantoms.add(PhantomType.SMART);
        this.availablePhantoms.add(PhantomType.FIGHTER);

        this.minTiles = 2;
        this.maxTiles = 4;

        this.minQuantity = 0;
        this.maxQuantity = 4;
    }
}
