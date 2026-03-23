package main.dev.bethinhas.command.game;

import main.dev.bethinhas.Player;
import main.dev.bethinhas.Save;
import main.dev.bethinhas.Game; // Talvez precise passar o Game ou Mansion
import main.dev.bethinhas.command.Command;
import main.dev.bethinhas.command.CommandResult;
import main.dev.bethinhas.utils.SaveManager;

public class SaveCommand implements Command {
    private final Game game;

    public SaveCommand(Game game) {
        this.game = game;
    }

    @Override
    public CommandResult execute(Player player, String argument) {
        Save saveState = new Save(game.getMansion(), player);
        SaveManager.saveGame(saveState);
        return new CommandResult(true, "Jogo salvo com sucesso.");
    }
}