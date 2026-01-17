package dev.bethinhas.command;

import dev.bethinhas.Player;

public interface Command {
    void execute(Player player, String argument);
}