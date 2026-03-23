package main.dev.bethinhas.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StoryTeller {
    public void playIntro(String filename, String playerName) {
        try {
            InputStream is = getClass().getResourceAsStream("/main/resources/story/" + filename);

            if (is == null) {
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String fullText = reader.lines().collect(Collectors.joining("\n"));

            String[] parts = fullText.split("\\n\\s*\\n");

            for (String part : parts) {
                String formattedPart = part.replace("{player}", playerName);

                System.out.println(formattedPart);
                System.out.println();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Erro ao ler a história: " + e.getMessage());
        }
    }
}
