package me.KeybordPiano459.kEssentials.config;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.KeybordPiano459.kEssentials.kEssentials;

public class CreatePlayerConfigJoin implements Listener {
	static kEssentials plugin;
	public CreatePlayerConfigJoin(kEssentials plugin) {
		CreatePlayerConfigJoin.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		if (plugin != null) {
			File playerConfig = new File(plugin.getDataFolder() + "playerdata" + File.separator + player.getName() + ".yml");
			if (!player.hasPlayedBefore() || !playerConfig.exists()) {
				PlayerConfig PlayerConfig = new PlayerConfig(plugin);
				PlayerConfig.generatePlayerConfig(player.getName());
			}
		}
	}
}