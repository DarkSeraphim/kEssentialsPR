package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Logger;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.util.helpers.Mute;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUnmute extends kCommand implements CommandExecutor {
	static kEssentials plugin;
	public CommandUnmute(kEssentials plugin) {
		CommandUnmute.plugin = plugin;
	}
	
	private Mute Mute = new Mute(plugin);
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unmute")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1) {
					if (player.hasPermission("kessentials.unmute")) {
						Player tplayer = Bukkit.getServer().getPlayer(args[0]);
						Mute.setMute(player, false);
						player.sendMessage(GREEN + "You have unmuted " + args[0] + "!");
						if (player != null) {
							tplayer.sendMessage(DARK_GRAY + "You have been unmuted!");
						}
					} else {
						noPermissionsMessage(player);
					}
				} else {
					incorrectUsage(player, "/unmute <player>");
				}
			} else {
				if (args.length == 1) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					Mute.setMute(player, false);
					Logger.getLogger("Minecraft").info("You have unmuted " + args[0]);
					if (player != null) {
						player.sendMessage(DARK_GRAY + "You have been unmuted!");
					}
				} else {
					incorrectUsageC("/mute <player>");
				}
			}
		}
		return false;
	}
}
