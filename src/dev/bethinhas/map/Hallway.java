package dev.bethinhas.map;

public class Hallway extends Location {

    public Hallway(String location, String code, String description) {
        super(location, code, description);
    }

    public Hallway(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
