package locations;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Davi
 */
public class Map {


    private Integer[][][] map;
    private HashMap<Integer, Location> locations;
    private Location initialLocation;

    public Map() {
        this.locations = new HashMap<>();
        this.map = new Integer[3][10][5];

        this.createLocations();
    }

    public int[] getTile(String coord){
        int line = coord.charAt(0) - ASCII_A;
        int col = coord.charAt(1) - ASCII_1;

        return new int[]{line, col};
    }

    /**
     *
     * @param description A descrição da sala
     * @param tiles       "A1, A2, A3, B1, B2, B3"
     * @param doors       "A1, B2"
     */
    public void createLocation(LocationType type, String description, int floor, String tiles, String doors) {
        int id = this.locations.size();

        Arrays.stream(tiles.split(", ")).forEach(tile -> {
            room.getTiles().add(tile);

            int line = tile.charAt(0) - ASCII_A;
            int col = tile.charAt(1) - ASCII_1;

            this.map[floor - 1][line][col] = id;
        });
        Arrays.stream(doors.split(", ")).forEach(door -> {
            room.addDoor(door);
        });

        this.locations.put(id, room);
    }

    public Location createLocations() {
        createLocation(LocationType.ROOM, "Um quarto qualquer", 1,"F1, G1, H1, I1", "F1");

        initialLocation = locationOn("F1", 1);
        return initialLocation;
    }

    public Location locationOn(String tile, int floor) {
        int line = tile.charAt(0) - ASCII_A;
        int col = tile.charAt(1) - ASCII_1;

        return locations.get(map[floor][line][col]);
    }

    public void printMap() {};
}
