package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.map.Location;
import dev.bethinhas.utils.TextFormatter;

public class EnterCommand implements Command {
    @Override
    public void execute(Player player, String argument) {
        if (argument.isBlank()) throw new RuntimeException("Ir para onde?");

        Location location = player.go(argument);

        System.out.println(TextFormatter.format(location.getLocationInfo(), player));
    }
}