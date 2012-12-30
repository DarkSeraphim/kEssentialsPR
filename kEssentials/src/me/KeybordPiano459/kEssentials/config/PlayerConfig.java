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
	
	public FileConfiguration customConfig = null;
	public File customConfigFile = null;
	public String s = File.separator;
	public String dataFolder = "plugins" + s + "kEssentials";
	//private kConfig kConfig;
	
	public boolean hasPlayerConfig(String player) {
		File file = new File(dataFolder, "playerdata" + s + player + ".yml");
		if (file.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void generatePlayerConfig(String player) {
		if (customConfigFile != null) {
			customConfigFile.delete();
		}
		
		reloadPlayerConfig(player);
		getPlayerConfig(player).set("muted", false);
		getPlayerConfig(player).set("backpack", "54;");
		//getPlayerConfig(player).set("money", kConfig.getConfig().getDouble("starting-balance"));
		savePlayerConfig(player);
	}
	
	public void reloadPlayerConfig(String player) {
		if (customConfigFile == null) {
			customConfigFile = new File(dataFolder, "playerdata" + s + player + ".yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
		InputStream defConfigStream = plugin.getResource("playerdata" + s + player + ".yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}
	
	public FileConfiguration getPlayerConfig(String player) {
		if (customConfig == null) {
			reloadPlayerConfig(player);
		}
		return customConfig;
	}
	
	public void savePlayerConfig(String player) {
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