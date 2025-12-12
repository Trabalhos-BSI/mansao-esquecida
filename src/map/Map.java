package map;

import java.util.HashSet;
import java.util.Set;

public class Map {
    private Set<Location> locations;
    private Location initialLocation;

    public Map() {
        this.locations = new HashSet<>();
    }

    public Location createRooms() {
        // ...
        return initialLocation;
    }
}
