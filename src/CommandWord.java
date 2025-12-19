public enum CommandWord {
    ENTER("entre"), BACK("voltar"), INTERACT("interagir"), HELP("ajuda"), TAKE("pegar"), DROP("largar"), LOOK("olhar"), QUIT("sair"), UNKNOWN("?");

    private String commandWord;

    CommandWord(String command) {
        this.commandWord = command;
    }

    public String toString() {
        return commandWord;
    }
}
