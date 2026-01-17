package dev.bethinhas.view;

import dev.bethinhas.command.Command;
import dev.bethinhas.command.CommandRegistry;

import java.util.*;

public class Parser {
    private final Scanner reader;
    private final CommandRegistry commandRegistry;

    public Parser()
    {
        reader = new Scanner(System.in);
        commandRegistry = new CommandRegistry();
    }

    public String readLine() {
        System.out.print("> "); // Prompt visual para o usuário saber que pode digitar
        return reader.nextLine();
    }
}