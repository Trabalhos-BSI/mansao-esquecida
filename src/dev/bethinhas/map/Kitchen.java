package dev.bethinhas.map;

public class Kitchen extends Location {

    public Kitchen(String location, String code, String description) {
        super(location, code, description);
    }

    public Kitchen(String location, String code, String description, Boolean locked) {
        super(location, code, description, locked);
    }
}
