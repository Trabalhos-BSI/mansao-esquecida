package dev.bethinhas.item;

import dev.bethinhas.map.Location;

public class Key extends Item {
    private Location location;

    public Key(String name, String description, Location location) {
        super(name, description);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setRoom(Location location) {
        this.location = location;
    }

    public void unlock() {
        this.location.setLocked(false);
    }
}
