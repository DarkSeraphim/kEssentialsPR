package me.KeybordPiano459.kEssentials;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class kPlayer {
	static kEssentials plugin;
	public kPlayer(kEssentials plugin) {
		kPlayer.plugin = plugin;
	}
	
	public static FileConfiguration customConfig = null;
	public static File customConfigFile = null;
	
	public static void reloadPlayerConfig(String player) {
		if (customConfigFile == null) {
			customConfigFile = new File(plugin.getDataFolder(), "playerdata/" + player + ".yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
		InputStream defConfigStream = plugin.getResource("playerdata/" + player + ".yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}
	
	public static FileConfiguration getPlayerConfig(String player) {
		if (customConfig == null) {
			reloadPlayerConfig(player);
		}
		return customConfig;
	}
	
	public static void savePlayerConfig(String player) {
		if (customConfig == null || customConfigFile == null) {
			return;
		}
		
		try {
			customConfig.save(customConfigFile);
		} catch (IOException e) {
			Logger.getLogger("Minecraft").severe("Could not save " + player + "'s config to the disk!");
		}
	}
}