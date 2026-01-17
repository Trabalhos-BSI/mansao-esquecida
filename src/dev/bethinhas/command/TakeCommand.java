package dev.bethinhas.command;

import dev.bethinhas.Player;
import dev.bethinhas.item.Item;

public class TakeCommand implements Command {

    @Override
    public void execute(Player player, String argument) {
        if (argument.isBlank()) throw new RuntimeException("Pegar o que?");

        Item item = player.takeItem(argument);
        System.out.println("O item " + item.getName() + " foi coletado.");
    }
}
