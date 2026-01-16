package dev.bethinhas;

import dev.bethinhas.map.Mansion;
import dev.bethinhas.map.Room;
import dev.bethinhas.map.RoomType;
import dev.bethinhas.view.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private final Parser parser;
    private Player currentPlayer;
    private Room startRoom;

    List<Command> commands;

    /**
     * Cria o jogo e inicia o mapa.
     */
    public Game() {
        createRooms();
        parser = new Parser();
        commands = new ArrayList<Command>();
    }

    /**
     * Cria as salas definindo suas saídas.
     * Define a sala inicial que guarda a referência para outras salas.
     */
    private void createRooms() {
        this.startRoom = null;
    }

    /**
     * dev.bethinhas.Game Loop.
     */
    public void play() {
        Mansion mansion = new Mansion();
        startRoom = mansion.getInitialRoom();

        System.out.println("Digite o nome do jogador: ");
        String playerName = parser.getLine();

        currentPlayer = new Player(playerName);
        currentPlayer.setCurrentRoom(this.startRoom);

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
        printRoomInfo();
    }

    /**
     * Exibe as informações do local atual do player.
     */
    private void printRoomInfo() {
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
        switch (commandWord) {
            case ENTER -> goRoom(command);
            case BACK -> backRoom();
            case INTERACT -> interact(command);
            case TAKE -> takeItem(command);
            case DROP -> dropItem(command);
            case LOOK -> lookRoom();
            case QUIT -> wantToQuit = quit(command);
            case HELP -> printHelp();
            case UNKNOWN -> System.out.println("Não entendi o que você quis dizer...");
        }

        return wantToQuit;
    }

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
            System.out.println("Ir onde?");
            return;
        }

        HashMap<String, RoomType> roomTypeHashMap = new HashMap<>();
        roomTypeHashMap.put(RoomType.ROOM.toString(), RoomType.ROOM);
        roomTypeHashMap.put(RoomType.KITCHEN.toString(), RoomType.KITCHEN);
        roomTypeHashMap.put(RoomType.BATHROOM.toString(), RoomType.BATHROOM);
        roomTypeHashMap.put(RoomType.HALLWAY.toString(), RoomType.HALLWAY);
        roomTypeHashMap.put(RoomType.LIVING_ROOM.toString(), RoomType.LIVING_ROOM);
        roomTypeHashMap.put(RoomType.BALCONY.toString(), RoomType.BALCONY);
        roomTypeHashMap.put(RoomType.STAIRS.toString(), RoomType.STAIRS);

        RoomType room = roomTypeHashMap.get(command.getSecondWord());
        if (room == RoomType.UNKNOWN || !currentPlayer.goRoom(room)) {
            System.out.println("Isso não é um cômodo!");
        } else {
            printRoomInfo();
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
            printRoomInfo();
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
            System.out.println(itemName + " foi largado em " + currentPlayer.getCurrentRoom().getType().toString());
        }
    }

    private void interact(Command command) {
        if (!currentPlayer.getCurrentRoom().containsPhantom()) {
            System.out.println("Não há nada para interagir aqui.");
            return;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
