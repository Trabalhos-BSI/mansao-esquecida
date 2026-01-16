package dev.bethinhas;

/**
 * @author Guilherme
 */
public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Cria um objeto de comando. A primeira e a segunda palavra devem ser fornecidas, mas
     * qualquer uma (ou ambas) podem ser null.
     * @param firstWord A primeira palavra do comando. Null se o comando
     * não foi reconhecido.
     * @param secondWord A segunda palavra do comando.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Retorna a palavra de comando (a primeira palavra) deste comando. Se o
     * comando não foi compreendido, o resultado é null.
     * @return A palavra de comando.
     */
    public CommandWord getCommandWord()
    {
        CommandWords commands = new CommandWords();
        return commands.getCommand(commandWord);
    }

    /**
     * @return A segunda palavra deste comando. Retorna null se não houver
     * uma segunda palavra.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true se este comando não foi compreendido.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true se o comando tem uma segunda palavra.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}