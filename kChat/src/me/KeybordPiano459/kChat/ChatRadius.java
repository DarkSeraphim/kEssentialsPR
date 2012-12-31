package me.KeybordPiano459.kChat;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatRadius implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		int nearbyn = kChat.chatradius;
		if (nearbyn != 0) {
			List<Entity> nearby = player.getNearbyEntities(nearbyn, nearbyn, nearbyn);
			for (Entity e : nearby) {
				if (e instanceof Player) {
					Player p = (Player) e;
					p.sendMessage("<" + player.getName() + "> " + event.getMessage());
				}
			}
		}
	}
}
