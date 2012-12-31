package me.KeybordPiano459.kChat;

import me.KeybordPiano459.kEssentials.util.ChatManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColors implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String msg = event.getMessage();
		if (kChat.colorallowed)
			event.setMessage(ChatManager.colorCompatible(msg)); // Add color symbols to chat messages
		if (player.isOp() && kChat.opcolor != "none")
			event.setFormat("<" + ChatManager.colorCompatible(kChat.opcolor + player.getName()) + "> " + event.getMessage());
	}
}
