package dev.bethinhas.view;

import dev.bethinhas.action.Action;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Esta classe faz parte da aplicação "World of Zuul". 
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 * * Este analisador (parser) lê a entrada do utilizador e tenta interpretá-la como um
 * comando de "Aventura". Cada vez que é chamado, ele lê uma linha do terminal e
 * tenta interpretar a linha como um comando de duas palavras. Ele retorna o comando
 * como um objeto da classe commands.dev.bethinhas.Command.
 *
 * O analisador tem um conjunto de palavras de comando conhecidas. Ele verifica a entrada
 * do utilizador em relação aos comandos conhecidos e, se a entrada não for um dos comandos
 * conhecidos, ele retorna um objeto de comando que está marcado como um comando desconhecido.
 * * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{ // guarda todas as palavras de comando válidas
    private Scanner reader;         // origem da entrada de comandos

    private Map<String, Action> actions;

    /**
     * Cria um analisador para ler da janela do terminal.
     */
    public Parser() 
    {
        reader = new Scanner(System.in);
        actions = new HashMap<>();
    }

    public String getInput() {
        System.out.print("> ");
        return reader.nextLine();
    }
}