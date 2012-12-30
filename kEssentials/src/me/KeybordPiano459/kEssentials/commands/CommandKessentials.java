package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.config.PlayerConfig;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKessentials extends kCommand implements CommandExecutor {
	static kEssentials plugin;
	public CommandKessentials(kEssentials plugin) {
		CommandKessentials.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kessentials")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {

				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("resetconfig")) {
						PlayerConfig PlayerConfig = new PlayerConfig(plugin);
						PlayerConfig.generatePlayerConfig(player.getName());
					}
				}
			}
		}
		return false;
	}
}