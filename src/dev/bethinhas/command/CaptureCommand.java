package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.phantom.Phantom;
import dev.bethinhas.utils.TextFormatter;

public class CaptureCommand implements Command {
    @Override
    public void execute(Player player, String argument) {
        Phantom phantom = player.getCurrentLocation().getPhantom();

        phantom.interact(player);

        if (phantom.isCaptured()) {
            player.addCapturedPhantom(phantom);
            player.getCurrentLocation().setPhantom(null);
            System.out.println("Fantasma capturado com sucesso!");
            System.out.println(TextFormatter.format(player.getCurrentLocation().getLocationInfo(), player));
        }
    }
}
