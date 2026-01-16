package dev.bethinhas.command;

import dev.bethinhas.Player;

public abstract class Command {
    protected String commandWord;

    public Command(String commandWord) {
        this.commandWord = commandWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public void setCommandWord(String commandWord) {
        this.commandWord = commandWord;
    }

    public abstract void run(Player player);
}
