package main.dev.bethinhas.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileReader {
    public String read(String folder, String filename) {
        try {
            InputStream is = getClass().getResourceAsStream("/main/resources/" + filename);
            if (is == null) throw new RuntimeException("Um erro ocorreu ao buscar um arquivo.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            System.out.println("Um erro ocorreu ao ler a intro...");
            return "";
        }
    }
}
