import java.util.Scanner;

/**
 * Esta classe faz parte da aplicação "World of Zuul". 
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 * * Este analisador (parser) lê a entrada do utilizador e tenta interpretá-la como um
 * comando de "Aventura". Cada vez que é chamado, ele lê uma linha do terminal e
 * tenta interpretar a linha como um comando de duas palavras. Ele retorna o comando
 * como um objeto da classe commands.Command.
 *
 * O analisador tem um conjunto de palavras de comando conhecidas. Ele verifica a entrada
 * do utilizador em relação aos comandos conhecidos e, se a entrada não for um dos comandos
 * conhecidos, ele retorna um objeto de comando que está marcado como um comando desconhecido.
 * * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private CommandWords commands;  // guarda todas as palavras de comando válidas
    private Scanner reader;         // origem da entrada de comandos

    /**
     * Cria um analisador para ler da janela do terminal.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return O próximo comando do utilizador.
     */
    public Command getCommand() 
    {
        String inputLine;   // guardará a linha de entrada completa
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // inicializa o prompt

        inputLine = reader.nextLine();

        // Encontra até duas palavras na linha.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // obtém a primeira palavra
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // obtém a segunda palavra
            }
        }
        tokenizer.close();
        
        // Agora verifica se esta palavra é conhecida. Se for, cria um comando
        // com ela. Se não, cria um comando "null" (para comando desconhecido).
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }
    
    /**
     * Exibe os comandos.
     */
    public void showCommands() {
        for (String command : commands.getCommandList()) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}