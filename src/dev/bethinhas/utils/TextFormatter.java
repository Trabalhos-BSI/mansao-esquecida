package dev.bethinhas.utils;

import dev.bethinhas.Player;

public class TextFormatter {

    public static String format(String template, Player player) {
        if (template == null) return "";

        String output = template;

        if (player != null) {
            // Substitui {player}
            output = output.replace("{player}", player.getName());

            // Substitui {room} se o player estiver em uma sala
            if (player.getCurrentLocation() != null) {
                output = output.replace("{location}", player.getCurrentLocation().getDescription());
            }
        }

        return output;
    }
}