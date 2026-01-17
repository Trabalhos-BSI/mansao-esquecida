package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.map.Location;
import dev.bethinhas.utils.TextFormatter;

public class BackCommand implements Command {

    @Override
    public void execute(Player player, String argument) {
        Location location = player.back();
        System.out.println(TextFormatter.format(location.getLocationInfo(), player));
    }
}
