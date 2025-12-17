package locations;

import java.util.Arrays;
import java.util.HashMap;

public class Floor {
    private Integer[][] map;
    private HashMap<Integer, Location> locations;

    public Floor(int lines, int cols) {
        if (lines < 1 || cols < 1) throw new IllegalArgumentException("A sala deve ter ao menos 1 tile.");

        this.map = new Integer[lines][cols];
        this.locations = new HashMap<>();
    }

    public void createLocation(LocationType type, String description, String tiles, String doors) {
        if (description == null) throw new IllegalArgumentException("Descrição não pode ser nula.");
        if (tiles == null || tiles.isEmpty()) throw new IllegalArgumentException("Tiles não podem ser nulos ou vazio.");
        if (doors == null || doors.isEmpty()) throw new IllegalArgumentException("O local deve ter ao menos 1 porta.");

        int id = this.locations.size();

        Location location = Location.from(type);

        String[] aTiles = tiles.replace(" ", "").split(",");

        for (String tile : aTiles) {

        }

        return;
    };

    public Location gatLocationOn(String tile) {
        return null;
    };
}
