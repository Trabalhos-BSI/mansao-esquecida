package dev.bethinhas.action;

import dev.bethinhas.Player;
import dev.bethinhas.map.RoomType;

public class EnterAction extends Action {

    @Override
    public void execute(Player player) {
        String roomName = player.getInput();
        if (roomName.isEmpty()) throw new RuntimeException();

        RoomType roomType = RoomType.from(roomName);
        if (roomType == RoomType.UNKNOWN) throw new RuntimeException();
        if (player.getCurrentRoom().getExit(roomType) == null) throw new RuntimeException();

        player.goRoom(roomType);
    }
}
