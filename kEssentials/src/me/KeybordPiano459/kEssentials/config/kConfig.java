package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.KeybordPiano459.kEssentials.kEssentials;

public class kConfig {
	static kEssentials plugin;
	public kConfig(kEssentials plugin) {
		kConfig.plugin = plugin;
	}
	
	public static void loadComments() {
		File file = new File(plugin.getDataFolder(), "config.yml");
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write("hello: true\n");
			fw.write("#This is hi");
			fw.write("hello: false");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
