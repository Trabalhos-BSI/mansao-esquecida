package dev.bethinhas.map;

public class LivingRoom extends Location {

    public LivingRoom(String location, String code, String description) {
        super(location, code, description);
    }

    public LivingRoom(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
