package dev.bethinhas.map;

public class BathRoom extends Location {

    public BathRoom(String location, String code, String description) {
        super(location, code, description);
    }

    public BathRoom(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
