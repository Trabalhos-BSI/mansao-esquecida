package dev.bethinhas.command;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandRegistry() {
        registerCommand(new EnterCommand(), "entre", "ir", "entrar", "vá");
        registerCommand(new BackCommand(), "voltar", "volte");

        registerCommand(new LookCommand(), "olhar", "ver", "l");

        registerCommand(new TakeCommand(), "pegar", "pegue", "coletar");

        registerCommand(new CaptureCommand(), "capturar");

        registerCommand(new QuitCommand(), "sair", "quit", "q");
    }

    public void registerCommand(Command command, String... aliases) {
        for (String alias : aliases) {
            commands.put(alias, command);
        }
    }

    public Command getCommand(String word) {
        return commands.get(word);
    }

    public Set<Command> getCommands(String commandWord) {
        return new HashSet<>(commands.values());
    }
}