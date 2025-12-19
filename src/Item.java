
/**
 * @author Enzo
 */
public class Item {
    private String name;
    private String description;
    private ItemType type;

    /**
     * Construtor - Inicializa o objeto com nome, descrição e tipo.
     *
     * @param name        o nome do item.
     * @param description a descrição do item.
     * @param type        o tipo do item.
     */
    public Item(String name, String description, ItemType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * @return String retorna o nome do item.
     */
    public String getName() {
        return name;
    }

    /**
     * @return String retorna a descrição do item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return String retorna as informações completas do item.
     */
    public String getInfo() {
        return "Nome: " + name + ".\nDescrição: " + description;
    }

    public ItemType getType() {
        return type;
    }

    /**
     * Utiliza o item.
     *
     * @param player O jogador que está usando o item.
     * @return true se o uso foi bem sucedido.
     */
    public boolean use(Player player) {
        if (this.type == ItemType.KEY) {
            Room room = player.getCurrentRoom();
            if (room != null && room.getExit(RoomType.STAIRS) != null) {
                // Desbloquear quarto
                return true;
            }
        }
        if (this.type == ItemType.PICTURE || this.type == ItemType.DIARY ) {
            System.out.println(this.description);
        }


        return false;
    }
}