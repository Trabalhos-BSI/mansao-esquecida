package dev.bethinhas;

import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // Um mapa que relaciona o texto do comando, com o ENUM do comando.
    private static HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - inicializa os comandos.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Verifica se a String fornecida é um comando válido. 
     * @param aString a String a ser validada.
     * @return true, se o comando existir, caso contrário, false.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Busca um comando no mapa de comandos.
     * @param commandString O comando que deseja buscar
     * @return commands.dev.bethinhas.CommandWord o Enum referente ao comando
     */
    public CommandWord getCommand(String commandString) {
        CommandWord commandWord = validCommands.get(commandString);
        if (commandWord == null) {
            return CommandWord.UNKNOWN;
        }
        return commandWord;
    }

    // TODO: Mover para a classe Game
    public Set<String> getCommandList() {
        return validCommands.keySet();
    }
}
