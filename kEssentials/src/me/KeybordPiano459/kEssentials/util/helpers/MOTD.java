package me.KeybordPiano459.kEssentials.util.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.util.ChatManager;

public class MOTD implements Listener {
	static kEssentials plugin;
	public MOTD(kEssentials plugin) {
		MOTD.plugin = plugin;
	}
	
	private static File motdFile = null;
	
	public void createMOTD() {
		if (motdFile == null) {
			File motdFile = new File(plugin.getDataFolder(), "motd.txt");
			try {
				motdFile.createNewFile();
				FileWriter writer = new FileWriter(motdFile);
				writer.write("&dWelcome to our server!\n");
				writer.write("&2Use minecraft's color codes to color the text.");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("kessentials.motd")) {
			try {
				File file = new File(plugin.getDataFolder(), "motd.txt");
				Scanner s = new Scanner(file);
				while (s.hasNextLine()) {
					player.sendMessage(ChatManager.colorCompatible(s.nextLine()));
				}
				s.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}