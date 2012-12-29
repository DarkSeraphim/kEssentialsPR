package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Logger;

import me.KeybordPiano459.kEssentials.util.helpers.Mute;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMute extends kCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mute")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1) {
					if (player.hasPermission("kessentials.mute")) {
						Player tplayer = Bukkit.getServer().getPlayer(args[0]);
						Mute.setMute(player, true);
						player.sendMessage(GREEN + "You have muted " + args[0] + "!");
						if (player != null) {
							tplayer.sendMessage(DARK_GRAY + "You have been muted!");
						}
					} else {
						noPermissionsMessage(player);
					}
				} else {
					incorrectUsage(player, "/mute <player>");
				}
			} else {
				if (args.length == 1) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					Mute.setMute(player, true);
					Logger.getLogger("Minecraft").info("You have muted " + args[0]);
					if (player != null) {
						player.sendMessage(DARK_GRAY + "You have been muted!");
					}
				} else {
					incorrectUsageC("/mute <player>");
				}
			}
		}
		return false;
	}
}
