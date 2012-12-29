package me.KeybordPiano459.kEssentials.util.helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.KeybordPiano459.kEssentials.kEssentials;

public class MOTD {
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
}