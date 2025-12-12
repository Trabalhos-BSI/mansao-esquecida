package commands;

/**
 * Esta classe faz parte da aplicação "World of Zuul". 
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Esta classe guarda informações sobre um comando que foi emitido pelo utilizador.
 * Um comando consiste atualmente em duas strings: uma palavra de comando e uma segunda
 * palavra (por exemplo, se o comando fosse "pegar mapa", as duas strings
 * seriam obviamente "pegar" e "mapa").
 * * A forma como isto é usado é: Os comandos já são verificados para garantir que são palavras
 * de comando válidas. Se o utilizador inseriu um comando inválido (uma palavra que não é
 * conhecida), então a palavra de comando é <null>.
 *
 * Se o comando tinha apenas uma palavra, então a segunda palavra é <null>.
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
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