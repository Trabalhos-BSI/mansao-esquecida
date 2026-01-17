package dev.bethinhas;

import dev.bethinhas.command.*; // Importa seus comandos
import dev.bethinhas.map.Location;
import dev.bethinhas.map.Mansion;
import dev.bethinhas.view.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Parser parser;
    private final CommandRegistry commandRegistry; // Nova peça
    private final Mansion mansion;

    private Player currentPlayer;
    private Location startLocation;

    public Game() {
        this.mansion = new Mansion();
        this.parser = new Parser();
        this.commandRegistry = new CommandRegistry();

        createRooms();
    }

    private void createRooms() {
        this.startLocation = this.mansion.getInitialLocation();
    }

    public void play() {
        this.startLocation = this.mansion.getInitialLocation();
        createPlayer();
        printWelcome();

        while (true) {
            String fullLine = parser.readLine();
            if (fullLine.isBlank()) continue;

            List<String> parts = new ArrayList<>(List.of(fullLine.split(" ")));
            String commandWord = parts.removeFirst();
            String argument = parts.stream().collect(Collectors.joining(" ", "", ""));
            currentPlayer.setInput(argument);

            Command command = commandRegistry.getCommand(commandWord);

            if (command != null) {
                command.execute(currentPlayer, argument);
            } else {
                System.out.println("Não entendi o que é '" + commandWord + "'...");
            }
        }
    }

    private void createPlayer() {
        System.out.println("Digite o nome do jogador: ");
        String fullLine = parser.readLine();
        if (fullLine.isBlank()) throw new RuntimeException();

        this.currentPlayer = new Player(fullLine);
        this.currentPlayer.setCurrentLocation(this.startLocation);
    }

    private void printWelcome() {
        printRoomInfo();
    }

    private void printRoomInfo() {
        System.out.println(currentPlayer.getCurrentLocation().getLocationInfo());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
