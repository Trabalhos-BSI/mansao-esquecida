import commands.Command;
import commands.CommandWord;
import entities.Player;
import map.Location;

import java.util.Scanner;

public class Game {
    private final Parser parser;
    private Player currentPlayer;
    private Location startLocation;

    /**
     * Cria o jogo e inicia o mapa.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Cria as salas definindo suas saídas.
     * Define a sala inicial que guarda a referência para outras salas.
     */
    private void createRooms() {
        this.startLocation = null;
    }

    /**
     * Game Loop.
     */
    public void play() {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o nome do jogador: ");
        String playerName = read.nextLine();
        currentPlayer = new Player(playerName);
        currentPlayer.setCurrentRoom(this.startLocation);

        this.printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar!");
    }

    /**
     * Exibe a mensagem de abertura
     */
    private void printWelcome() {
        printLocationInfo();
    }

    /**
     * Exibe as informações do local atual do player.
     */
    private void printLocationInfo() {
        System.out.println(currentPlayer.getCurrentRoom().getLongDescription());
    }

    /**
     * Recebe um comando e processa o mesmo.
     *
     * @param command O comando a ser processado.
     * @return true se o comando for de saída e false para os demais.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        System.out.println(commandWord);
        switch (commandWord) {
            case CommandWord.UNKNOWN -> System.out.println("Não entendi o que você quis dizer...");
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Exibe os comandos disponíveis.
     */
    private void printHelp() {
        System.out.println("...");
        System.out.println("...");
        System.out.println();
        System.out.println("Os comandos disponíveis são:");
        System.out.print("\t");
        parser.showCommands();
    }

    /**
     * Tenta ir em uma direção, se existir uma sala,
     * o player entra, caso contrário exibe uma mensagem de erro.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // Exige uma segunda palavra para saber aonde ir
            System.out.println("Ir onde?");
            return;
        }

        String direction = command.getSecondWord();

        if (!currentPlayer.goRoom(direction)) {
            System.out.println("Isso não é uma sala!");
        } else {
            printLocationInfo();
        }
    }

    /**
     * Verifica o restante do comando para saber se o usuário realmente quer sair.
     *
     * @return true, se o comando for saída, caso contrário, false.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quer realmente sair?");
            return false;
        } else {
            return true;
        }
    }


    /**
     * Exibe as informações da sala atual do player.
     */
    private void lookRoom() {
        System.out.println(currentPlayer.getCurrentRoom().getLongDescription());
    }

    /**
     * Volta salas conforme os locais que o player passou
     */
    private void backRoom() {
        if (currentPlayer.backRoom()) {
            printLocationInfo();
        } else {
            System.out.println("Não há salas para voltar.");
        }
    }

    /**
     * Pega um item na sala que o player está.
     *
     * @param command O comando para processar o item.
     */
    private void takeItem(Command command) {
        String itemName = command.getSecondWord();
        if (itemName == null) {
            return;
        }

        if (!currentPlayer.takeItem(itemName)) {
            System.out.println("...");
        } else {
            System.out.println("Você pegou " + itemName);
        }
    }

    /**
     * Solta um item na sala que o player está.
     *
     * @param command O comando para processar o item.
     */
    private void dropItem(Command command) {
        String itemName = command.getSecondWord();
        if (itemName == null) {
            return;
        }

        if (!currentPlayer.dropItem(itemName)) {
            System.out.println("...");
        } else {
            System.out.println(itemName + " foi largado em " + currentPlayer.getCurrentRoom().getName());
        }
    }

    private void inventory() {
        System.out.println("...");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
