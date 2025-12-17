package locations;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Davi
 */
public class Map {
    private final int ASCII_A = 65;
    private final int ASCII_1 = 49;

    private Integer[][] map;
    private HashMap<Integer, Location> locations;
    private Location initialLocation;

    public Map() {
        this.locations = new HashMap<>();
        this.map = new Integer[10][5];

        this.createRooms();
    }

    /**
     *
     * @param description A descrição da sala
     * @param tiles       "A1, A2, A3, B1, B2, B3"
     * @param doors       "A1, B2"
     */
    public void createRoom(LocationType type, String description, String tiles, String doors) {
        int id = this.locations.size();

        Location room = switch (type) {
            case HALLWAY -> null;
            case ROOM -> new Room(id, description);
            case LIVING_ROOM -> null;
            case BATHROOM -> null;
            case BALCONY -> null;
        };
        Arrays.stream(tiles.split(", ")).forEach(tile -> {
            room.getTiles().add(tile);

            int line = tile.charAt(0) - ASCII_A;
            int col = tile.charAt(1) - ASCII_1;

            this.map[line][col] = id;
        });
        Arrays.stream(doors.split(", ")).forEach(door -> {
            room.addDoor(door);
        });

        this.locations.put(id, room);
    }

    public Location createRooms() {
        createRoom(LocationType.ROOM, "Um quarto qualquer", "F1, G1, H1, I1", "F1");

        initialLocation = locationOn("F1");
        return initialLocation;
    }

    public Location locationOn(String tile) {
        int line = tile.charAt(0) - ASCII_A;
        int col = tile.charAt(1) - ASCII_1;

        return locations.get(map[line][col]);
    }

    public void printMap() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.print(this.map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
