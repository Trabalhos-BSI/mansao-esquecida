package dev.bethinhas.map;

public class Balcony extends Location {

    public Balcony(String location, String code, String description) {
        super(location, code, description);
    }

    public Balcony(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
