package me.KeybordPiano459.kEssentials.util;

import org.bukkit.ChatColor;

public class ChatManager {
	public static String colorCompatible(String string) 
        {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
}
