package dev.bethinhas.map;

import dev.bethinhas.item.Food;
import dev.bethinhas.phantom.FatPhantom;
import dev.bethinhas.phantom.FighterPhantom;
import dev.bethinhas.phantom.IntelligentPhantom;

import java.util.List;
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

        Room hallway1 = new Room(RoomType.HALLWAY, "...", false);
        Room hallway2 = new Room(RoomType.HALLWAY, "...", false);
        Room hallway3 = new Room(RoomType.HALLWAY, "...", false);
        Room hallway4 = new Room(RoomType.HALLWAY, "...", false);

        Room room1 = new Room(RoomType.ROOM, "...", false);
        Room room2 = new Room(RoomType.ROOM, "...", false);
        Room room3 = new Room(RoomType.ROOM, "...", false);

        Room livingRoom = new Room(RoomType.LIVING_ROOM, "...", false);

        Room bathroom = new Room(RoomType.BATHROOM, "...", false);

        Room kitchen = new Room(RoomType.KITCHEN, "...", false);

        Room stairs = new Room(RoomType.STAIRS, "...", false);

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

        livingRoom.setPhantom(new FighterPhantom(
                "",
                "${player} entra em ${room} e escuta uma voz dizendo:  \"A luta é tudo o que restou de mim...\".",
                "Você pode capturar esse fantasma com um espelho.",
                20
        ));

        room2.setPhantom(new IntelligentPhantom(
                "",
                "${player} entra em ${room} e escuta uma voz dizendo:  \\\"Não é a força que me mantém aqui, é o que vocês nunca conseguiram entender...\\\".\"",
                "Você pode capturar esse fantasma resolvendo um enigma.",
                "Qual a cor do cavalo branco de Napoleão?",
                List.of("Branco", "branco")
        ));

        kitchen.setPhantom(new FatPhantom(
                "Mabin Joo",
                "${player} entra em ${room} e escuta uma voz dizendo:  \\\"Vou te comer, vou te comer, vou te comer...\\\".\"",
                "Você pode capturar esse fantasma lhe dando comida.",
                List.of("Alface")
        ));

        kitchen.addItem(new Food("alface", "Um alface bem verdinho"));

        this.locations.addAll(Set.of(hallway1, hallway2, hallway3, hallway4, room1, room2, room3, livingRoom, bathroom, kitchen));

        initialRoom = hallway1;
    }

    public Room getInitialRoom() {
        return initialRoom;
    }
}
