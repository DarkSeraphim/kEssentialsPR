package me.KeybordPiano459.kEssentials.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import me.KeybordPiano459.kEssentials.kEssentials;

public class ConfigComments {
	static kEssentials plugin;
	public ConfigComments(kEssentials plugin) {
		ConfigComments.plugin = plugin;
	}
	
	public static void loadComments() {
		try {
			FileOutputStream writer = new FileOutputStream(new File(plugin.getDataFolder() + File.separator + "config.yml"));
			InputStream out = kEssentials.class.getResourceAsStream("config.yml");
			byte[] linebuffer = new byte[4096];
			int lineLength = 0;
			while((lineLength = out.read(linebuffer)) > 0) {
				writer.write(linebuffer, 0, lineLength);
			}
			writer.close();
		} catch (NullPointerException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}