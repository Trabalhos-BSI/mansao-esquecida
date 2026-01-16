package dev.bethinhas;

import java.util.Set;
import java.util.HashSet;

/**
 * @author Davi
 */
public class Mansion {
    private Set<Room> locations;
    private Room initialRoom;

    public Mansion() {
        this.locations = new HashSet<>();

        this.init();
    }

    public void init() {
        if (initialRoom != null) return;

        Room hallway1 = new Room(RoomType.HALLWAY, "...");
        Room hallway2 = new Room(RoomType.HALLWAY, "...");
        Room hallway3 = new Room(RoomType.HALLWAY, "...");
        Room hallway4 = new Room(RoomType.HALLWAY, "...");

        Room room1 = new Room(RoomType.ROOM, "...");
        Room room2 = new Room(RoomType.ROOM, "...");
        Room room3 = new Room(RoomType.ROOM, "...");

        Room livingRoom = new Room(RoomType.LIVING_ROOM, "...");

        Room bathroom = new Room(RoomType.BATHROOM, "...");

        Room kitchen = new Room(RoomType.KITCHEN, "...");

        Room stairs = new Room(RoomType.STAIRS, "...");

        Phantom fat = new Phantom("Mabin Joo", PhantomType.FAT, ItemType.FOOD);
        Phantom smart = new Phantom("Enzo", PhantomType.INTELLIGENT, "Qual a cor do cavalo branco de Napoleão?", "Branco");
        Phantom fighter = new Phantom("Do Brox", PhantomType.FIGHTER);

        Item lettuce = new Item("alface", "Um alface bem verdinho", ItemType.FOOD);

        hallway1.setExit(RoomType.HALLWAY, hallway2);
        hallway1.setExit(RoomType.LIVING_ROOM, livingRoom);

        livingRoom.setExit(RoomType.BATHROOM, bathroom);

        hallway2.setExit(RoomType.HALLWAY, hallway3);
        hallway2.setExit(RoomType.ROOM, room1);

        hallway3.setExit(RoomType.LIVING_ROOM, livingRoom);
        hallway3.setExit(RoomType.KITCHEN, kitchen);
        hallway3.setExit(RoomType.ROOM, room2);

        hallway4.setExit(RoomType.ROOM, room3);

        hallway4.setExit(RoomType.STAIRS, stairs);

        livingRoom.setPhantom(fighter);

        room2.setPhantom(smart);

        kitchen.setPhantom(fat);

        kitchen.addItem(lettuce);

        this.locations.addAll(Set.of(hallway1, hallway2, hallway3, hallway4, room1, room2, room3, livingRoom, bathroom, kitchen));

        initialRoom = hallway1;
    }

    public Room getInitialRoom() {
        return initialRoom;
    }
}
