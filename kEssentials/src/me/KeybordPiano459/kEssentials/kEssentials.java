package me.KeybordPiano459.kEssentials;

import java.io.IOException;

import me.KeybordPiano459.kEssentials.commands.CommandSpawner;
import me.KeybordPiano459.kEssentials.commands.kCommand;
import me.KeybordPiano459.kEssentials.config.PlayerConfigValues;
import me.KeybordPiano459.kEssentials.util.BukkitMetrics;
import me.KeybordPiano459.kEssentials.util.helpers.Back;
import me.KeybordPiano459.kEssentials.util.helpers.Backpack;
import me.KeybordPiano459.kEssentials.util.helpers.Mute;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class kEssentials extends JavaPlugin {
	public void onEnable() {
		getLogger().info("kEssentials v1.0 has been enabled!");
		kCommand.getCommands();
		getConstructorClasses();
		
		try {
			BukkitMetrics metrics = new BukkitMetrics(this);
			metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :-(
		}
	}
	
	public void onDisable() {
		getLogger().info("kEssentials v1.0 has been disabled.");
	}
	
	public void getConstructorClasses() {
		getHelper(new Back());
		getHelper(new Backpack());
		getHelper(new Mute(this));
		getHelper(new PlayerConfigValues(this));
		kCommand.getCommand("spawner", new CommandSpawner(this));
	}
	
	public void getHelper(Listener listener) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, this);
	}
}
