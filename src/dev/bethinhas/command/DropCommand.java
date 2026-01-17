package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.item.Item;

public class DropCommand implements Command {
    @Override
    public void execute(Player player, String argument) {
        if (argument.isBlank()) throw new RuntimeException();

        Item item = player.dropItem(argument);
        player.getCurrentLocation().addItem(item);
        System.out.println("O item " + item.getName() + " foi solto em " + player.getCurrentLocation().getLocation());
    }
}
