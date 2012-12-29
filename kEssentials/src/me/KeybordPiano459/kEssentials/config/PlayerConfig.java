package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import me.KeybordPiano459.kEssentials.kEssentials;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerConfig {
	static kEssentials plugin;
	public PlayerConfig(kEssentials plugin) {
		PlayerConfig.plugin = plugin;
	}
	
	public static FileConfiguration customConfig = null;
	public static File customConfigFile = null;
	
	public static void generatePlayerConfig(String player) {
		if (customConfigFile != null) {
			customConfigFile.delete();
		}
		
		reloadPlayerConfig(player);
		getPlayerConfig(player).set("muted", false);
		getPlayerConfig(player).set("backpack", "54;");
		savePlayerConfig(player);
		reloadPlayerConfig(player);
	}
	
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