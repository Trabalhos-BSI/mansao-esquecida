package dev.bethinhas.item;

import dev.bethinhas.map.Room;

public class Key extends Item {
    private Room room;

    public Key(String name, String description, Room room) {
        super(name, description);
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void unlock() {
        this.room.unlock();
    }
}
