package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.map.RoomType;

public class EnterCommand extends Command {
    public EnterCommand(String commandWord) {
        super(commandWord);
    }

    @Override
    public void run(Player player) {
        String roomName = player.getResponse();
        if (roomName.isEmpty()) throw new RuntimeException();

        RoomType roomType = RoomType.from(roomName);
        if (roomType == RoomType.UNKNOWN) throw new RuntimeException();
        if (player.getCurrentRoom().getExit(roomType) == null) throw new RuntimeException();

        player.goRoom(roomType);
    }
}
