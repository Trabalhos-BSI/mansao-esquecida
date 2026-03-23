package main.dev.bethinhas.command;

import main.dev.bethinhas.Game;
import main.dev.bethinhas.command.game.QuitCommand;
import main.dev.bethinhas.command.game.SaveCommand;
import main.dev.bethinhas.command.location.LookCommand;
import main.dev.bethinhas.command.location.UnlockCommand;
import main.dev.bethinhas.command.phantom.CaptureCommand;
import main.dev.bethinhas.command.player.*;
import main.dev.bethinhas.command.view.ReadCommand;
import main.dev.bethinhas.command.view.ShowCommand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();
    public CommandRegistry(Game game) {
        registerCommand(new EnterCommand(), "entre", "ir", "entrar", "vá", "va");
        registerCommand(new BackCommand(), "voltar", "volte");

        registerCommand(new LookCommand(), "olhar");

        registerCommand(new InventoryCommand(), "inventario");
        registerCommand(new TakeCommand(), "pegar", "pegue", "coletar", "colete");
        registerCommand(new DropCommand(), "largar", "solte", "soltar");

        registerCommand(new CaptureCommand(), "capturar");

        registerCommand(new UnlockCommand(), "destrancar");

        registerCommand(new SaveCommand(game), "salvar", "save");

        registerCommand(new QuitCommand(), "sair");

        registerCommand(new ReadCommand(), "ler");
        registerCommand(new ShowCommand(), "exibir", "ver");
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