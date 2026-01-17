package dev.bethinhas.map;

public class Room extends Location {

    public Room(String location, String code, String description) {
        super(location, code, description);
    }

    public Room(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
