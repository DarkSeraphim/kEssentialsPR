package me.KeybordPiano459.kEssentials.util.helpers;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Mute implements Listener {
	static kEssentials plugin;
	public Mute(kEssentials plugin) {
		Mute.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (getMute(player)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You are mute!");
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPlayedBefore()) {
			setMute(player, false);
		}
	}
	
	public static boolean getMute(Player player) {
		return PlayerConfig.getPlayerConfig(player.getName()).getBoolean("muted");
	}
	
	public static void setMute(Player player, Boolean mute) {
		PlayerConfig.getPlayerConfig(player.getName()).set("muted", mute);
		PlayerConfig.savePlayerConfig(player.getName());
	}
}
