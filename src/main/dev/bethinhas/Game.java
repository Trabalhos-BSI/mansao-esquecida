package main.dev.bethinhas;

import main.dev.bethinhas.command.Command;
import main.dev.bethinhas.command.CommandRegistry;
import main.dev.bethinhas.command.CommandResult;
import main.dev.bethinhas.utils.FileReader;
import main.dev.bethinhas.utils.SaveManager;
import main.dev.bethinhas.utils.StoryTeller;
import main.dev.bethinhas.view.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Parser parser;
    private final CommandRegistry commandRegistry;

    private Mansion mansion;
    private Player currentPlayer;


    public Game() {
        this.parser = new Parser();
        this.commandRegistry = new CommandRegistry(this);
    }

    public void play() {
        gameIntro();
        printRoomInfo();

        while (true) {
            try {
                String fullLine = parser.readLine();
                if (fullLine.isBlank()) continue;

                List<String> parts = new ArrayList<>(List.of(fullLine.split(" ")));
                String commandWord = parts.removeFirst();
                String argument = parts.stream().collect(Collectors.joining(" ", "", ""));

                Command command = commandRegistry.getCommand(commandWord);

                if (command == null) throw new IllegalArgumentException("Não entendi o que é '" + commandWord + "'...");
                CommandResult result = command.execute(currentPlayer, argument);
                for (String message : result.messages()) {
                    System.out.println(message);
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * Método responsável por exibir a introdução do jogo e inicializar a Mansão e o Jogador.
     */
    public void gameIntro() {
        FileReader reader = new FileReader();
        String intro = reader.read("", "game_intro.txt");
        System.out.println(intro);

        System.out.println("O que deseja fazer?");
        while (mansion == null || currentPlayer == null) {
            System.out.println("\t[1] - Novo jogo");
            System.out.println("\t[2] - Carregar jogo");
            String inputCommand = parser.readLine();

            try {
                int option = Integer.parseInt(inputCommand.trim());

                switch (option) {
                    case 1 -> newGame();
                    case 2 -> loadGame();
                    default -> System.out.println("Ops... Opção '" + option + "' inválida. Tente 1 ou 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ops... Por favor, digite apenas números válidos (1 ou 2).");
            }
        }
    }

    public void newGame() {
        this.mansion = new Mansion();

        System.out.println("Digite o nome: ");
        String playerName = parser.readLine();
        this.currentPlayer = new Player(playerName);
        this.currentPlayer.setCurrentLocation(mansion.getInitialLocation());

        StoryTeller storyTeller = new StoryTeller();
        storyTeller.playIntro("intro.txt", currentPlayer.getName());
    }

    public void loadGame() {
        List<String> availableSaves = SaveManager.getAvailableSaves();

        if (availableSaves.isEmpty()) {
            System.out.println("Nenhum jogo salvo encontrado.");
            return;
        }

        System.out.println("Jogos salvos encontrados:");
        for (String name : availableSaves) {
            System.out.println("\t- " + name);
        }

        System.out.println("Digite o nome do personagem que deseja carregar (ou deixe em branco para cancelar): ");
        String chosenName = parser.readLine().trim();

        if (chosenName.isBlank()) {
            System.out.println("Carregamento cancelado.");
            return;
        }

        Save loadedSave = SaveManager.loadGame(chosenName);

        if (loadedSave != null) {
            this.mansion = loadedSave.getMansion();
            this.currentPlayer = loadedSave.getPlayer();
            System.out.println("Jogo carregado com sucesso! Bem-vindo de volta, " + currentPlayer.getName() + ".");
        } else {
            System.out.println("Ops... Jogo salvo não encontrado para '" + chosenName + "'. Verifique se digitou corretamente.");
        }
    }

    private void printRoomInfo() {
        System.out.println(currentPlayer.getCurrentLocation().getLocationInfo());
    }

    public Mansion getMansion() {
        return mansion;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
