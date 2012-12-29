package me.KeybordPiano459.kEssentials.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.util.ChatManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMotd extends kCommand implements CommandExecutor {
	static kEssentials plugin;
	public CommandMotd(kEssentials plugin) {
		CommandMotd.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("motd")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
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
					} else {
						noPermissionsMessage(player);
					}
				} else {
					incorrectUsage(player, "/motd");
				}
			} else {
				if (args.length == 0) {
					try {
						File file = new File(plugin.getDataFolder(), "motd.txt");
						Scanner s = new Scanner(file);
						while (s.hasNextLine()) {
							Logger.getLogger("Minecraft").info(s.nextLine());
						}
						s.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} else {
					incorrectUsageC("/motd");
				}
			}
		}
		return false;
	}
}