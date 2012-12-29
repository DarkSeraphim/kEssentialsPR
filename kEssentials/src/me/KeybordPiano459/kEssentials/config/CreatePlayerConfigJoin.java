package me.KeybordPiano459.kEssentials.config;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.KeybordPiano459.kEssentials.kEssentials;

public class CreatePlayerConfigJoin extends PlayerConfig implements Listener {
	public CreatePlayerConfigJoin(kEssentials plugin) {
		super(plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		File playerConfig = new File(plugin.getDataFolder() + "playerdata" + File.separator + player.getName() + ".yml");
		if (!player.hasPlayedBefore() || !playerConfig.exists()) {
			generatePlayerConfig(player.getName());
		}
	}
}