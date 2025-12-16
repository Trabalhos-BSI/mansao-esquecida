package locations;

import entities.PhantomType;

public class Room extends Location {

    public Room() {
        super();
        this.type = LocationType.ROOM;

        this.availablePhantoms.add(PhantomType.SMART);
        this.availablePhantoms.add(PhantomType.FIGHTER);

        this.minTiles = 2;
        this.maxTiles = 4;

        this.minQuantity = 0;
        this.maxQuantity = 4;
    }
}
