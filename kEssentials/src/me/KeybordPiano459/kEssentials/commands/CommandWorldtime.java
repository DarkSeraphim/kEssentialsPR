package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Logger;

import me.KeybordPiano459.kEssentials.util.helpers.Time;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorldtime extends kCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (player.hasPermission("kessentials.worldtime")) {
					player.sendMessage(GREEN + "It is " + Time.getTime() + " on the server's computer.");
				} else {
					noPermissionsMessage(player);
				}
			} else {
				incorrectUsage(player, "/worldtime");
			}
		} else {
			if (args.length == 0) {
				Logger.getLogger("Minecraft").info("It is " + Time.getTime() + " on the server's computer.");
			} else {
				incorrectUsageC("/worldtime");
			}
		}
		return false;
	}
}
