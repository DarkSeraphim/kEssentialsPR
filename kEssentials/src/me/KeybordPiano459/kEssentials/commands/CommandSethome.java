package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.config.PlayerConfig;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandSethome extends kCommand implements CommandExecutor {
	static kEssentials plugin;
	public CommandSethome(kEssentials plugin) {
		CommandSethome.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sethome")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					if (player.hasPermission("kessentials.sethome")) {
						PlayerConfig PlayerConfig = new PlayerConfig(plugin);
						FileConfiguration config = PlayerConfig.getPlayerConfig(player.getName());
						Location loc = player.getLocation();
						config.set("home.world", loc.getWorld().getName());
						config.set("home.x", loc.getX());
						config.set("home.y", loc.getY());
						config.set("home.z", loc.getZ());
						config.set("home.yaw", loc.getYaw());
						config.set("home.pitch", loc.getPitch());
						player.sendMessage(GREEN + "Your home has been set!");
					} else {
						noPermissionsMessage(player);
					}
				} else {
					incorrectUsage(player, "/sethome");
				}
			} else {
				consoleError();
			}
		}
		return false;
	}
}