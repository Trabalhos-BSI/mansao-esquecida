package commands;

public enum CommandWord {
    UNKNOWN("?");

    private String commandWord;

    CommandWord(String command) {
        this.commandWord = command;
    }

    public String toString() {
        return commandWord;
    }
}
