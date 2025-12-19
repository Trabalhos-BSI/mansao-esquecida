import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private final Parser parser;
    private Player currentPlayer;
    private Room startRoom;

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
        this.startRoom = null;
    }

    /**
     * Game Loop.
     */
    public void play() {
        Mansion mansion = new Mansion();
        startRoom = mansion.getInitialRoom();

        Scanner read = new Scanner(System.in);
        System.out.print("Digite o nome do jogador: ");
        String playerName = read.nextLine();
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
            case CommandWord.ENTER -> goRoom(command);
            case CommandWord.BACK -> backRoom();
            case CommandWord.INTERACT -> interact(command);
            case TAKE -> takeItem(command);
            case DROP -> dropItem(command);
            case CommandWord.QUIT -> wantToQuit = quit(command);
            case CommandWord.HELP -> printHelp();
            case CommandWord.UNKNOWN -> System.out.println("Não entendi o que você quis dizer...");
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
            System.out.println(itemName + " foi largado em " + currentPlayer.getCurrentRoom().getLongDescription());
        }
    }

    public void interact(Command command) {
        Scanner read = new Scanner(System.in);
        if (!currentPlayer.getCurrentRoom().containsPhantom()) {
            System.out.println("Não há nada para interagir aqui.");
            return;
        }

        Phantom phantom = currentPlayer.getCurrentRoom().getPhantom();
        System.out.println(phantom.getWhoCapture());

        switch (phantom.getType()) {
            case SMART -> {
                System.out.println(phantom.getInteractions().getPuzzle());


                String response = "";
                while (!phantom.getInteractions().checkPuzzle(response)) {
                    System.out.print("> ");
                    response = read.nextLine();
                    System.out.println("Você errou. Tente novamente.");
                }
                System.out.println("Fantasma capturado com sucesso!");
            }
            case FIGHTER -> {
                // ...
            }
            case FAT -> {
                System.out.println("Qual item deseja usar?");
                System.out.print("> ");
                String itemName = read.nextLine();

                Item item = currentPlayer.useItem(itemName);

                if (!phantom.getInteractions().item(item)) {
                    System.out.println("Esse item não pode ser utilizado para capturar esse fantasma.");
                    currentPlayer.addItem(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
