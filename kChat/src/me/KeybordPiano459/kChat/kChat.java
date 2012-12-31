package me.KeybordPiano459.kChat;

import me.KeybordPiano459.kEssentials.config.kConfig;

import org.bukkit.plugin.java.JavaPlugin;

public class kChat extends JavaPlugin {
	
	public static String opcolor = kConfig.getConfig().getString("op-name-color");
	public static boolean colorallowed = kConfig.getConfig().getBoolean("colors-allowed-chat");
	public static int chatradius = kConfig.getConfig().getInt("chat-radius");
	
	public void onEnable() {
		if (kEssentials()) {
			getLogger().info("kChat v1.0 has been enabled!");
		} else {
			getLogger().warning("|----------------------------------------------|");
			getLogger().warning("|         Could not load kChat v1.0!!!         |");
			getLogger().warning("|      kChat is an add-on for kEssentials.     |");
			getLogger().warning("|      It can't load without it. Download      |");
			getLogger().warning("|     the newest version of kEssentials at     |");
			getLogger().warning(" http://dev.bukkit.org/server-mods/kEssentials/ ");
			getLogger().warning("|----------------------------------------------|");
			this.setEnabled(false);
		}
	}
	
	public void onDisable() {
		getLogger().info("kChat v1.0 has been disabled.");
	}
	
	public boolean kEssentials() {
		if (getServer().getPluginManager().getPlugin("kEssentials") != null) {
			return true;
		} else {
			return false;
		}
	}
}
