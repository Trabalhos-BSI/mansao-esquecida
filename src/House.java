package locations;

import java.util.HashSet;
import java.util.Set;

public class House {
    Set<Floor> floors;

    public House() {
        this.floors = new HashSet<>();
    };
}
