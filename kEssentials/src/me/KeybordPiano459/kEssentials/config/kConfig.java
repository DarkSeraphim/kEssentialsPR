package me.KeybordPiano459.kEssentials.config;

import me.KeybordPiano459.kEssentials.kEssentials;

public class kConfig {
	static kEssentials plugin;
	public kConfig(kEssentials plugin) {
		kConfig.plugin = plugin;
	}
	
	public static void loadConfig() {
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}
	
	public static void saveConfig() {
		plugin.saveConfig();
	}
}
