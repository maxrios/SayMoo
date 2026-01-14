package dev.maxrios.events;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import java.util.Arrays;

public class MooEvent {

    public static boolean isMooEnabled = false;

    public static void onPlayerChat(PlayerChatEvent event) {
        if (!isMooEnabled) return;

        event.setContent(convertMessageToMooMessage(event.getContent()));
    }

    private static String convertMessageToMooMessage(String message) {
        if (message.isEmpty()) return message;

        String[] words =  message.split("\\s+");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(words).forEach(word -> {
            sb.append(convertWordToMoo(word));
            sb.append(" ");
        });
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString().trim();
    }

    private static String convertWordToMoo(String word) {
        if (word.length() < 3) return "moo";

        StringBuilder sb = new StringBuilder("o".repeat(word.length()));
        sb.setCharAt(0, 'm');

        return sb.toString();
    }
}