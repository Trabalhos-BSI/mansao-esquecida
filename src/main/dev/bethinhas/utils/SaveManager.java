package main.dev.bethinhas.utils;

import main.dev.bethinhas.Save;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    public static File getSaveDirectory() {
        String userHome = System.getProperty("user.home");

        File documentsFolder = new File(userHome, "Documents");
        if (!documentsFolder.exists()) {
            documentsFolder = new File(userHome, "Documentos");
        }

        File gameFolder = new File(documentsFolder, "Mansão Esquecida");
        if (!gameFolder.exists()) {
            boolean created = gameFolder.mkdirs();
            if (!created) throw new RuntimeException("Não foi possível criar a pasta padrão do jogo.");
        }

        File saveFolder = new File(gameFolder, "Jogos salvos");
        if (!saveFolder.exists()) {
            boolean created = saveFolder.mkdirs();
            if (!created) return saveFolder;
        }
        return saveFolder;
    }

    public static void saveGame(Save save) {
        File folder = getSaveDirectory();

        String playerName = save.getPlayer().getName().trim().replace(" ", "_");
        String fileName = "save_" + playerName + ".dat";

        File saveFile = new File(folder, fileName);

        try (FileOutputStream fileOut = new FileOutputStream(saveFile);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(save);
            System.out.println("Jogo salvo em: " + saveFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<String> getAvailableSaves() {
        File folder = getSaveDirectory();
        List<String> saveNames = new ArrayList<>();

        File[] files = folder.listFiles((dir, name) -> name.startsWith("save_") && name.endsWith(".dat"));

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                String playerName = fileName.substring(5, fileName.length() - 4).replace("_", " ");
                saveNames.add(playerName);
            }
        }
        return saveNames;
    }

    public static Save loadGame(String playerName) {
        File folder = getSaveDirectory();
        String fileName = "save_" + playerName.replace(" ", "_") + ".dat";
        File saveFile = new File(folder, fileName);

        if (!saveFile.exists()) {
            return null;
        }

        try (FileInputStream fileIn = new FileInputStream(saveFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            return (Save) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
        return null;
    }
}