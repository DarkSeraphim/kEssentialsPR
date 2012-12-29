package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.config.PlayerConfig;
import me.KeybordPiano459.kEssentials.util.helpers.Backpack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandBackpack extends kCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("backpack")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					if (player.hasPermission("kessentials.backpack")) {
						Inventory backpack = Backpack.getBackpack(player);
						if (Backpack.hasBackpack(player)) {
							ItemStack[] contents = backpack.getContents();
							Inventory inv = Bukkit.createInventory(player, 54, "Backpack");
							inv.setContents(contents);
							player.openInventory(inv);
						} else {
							Backpack.setBackpack(player, Bukkit.createInventory(player, 54, "Backpack"));
							PlayerConfig.reloadPlayerConfig(player.getName());
							Inventory inv = Bukkit.createInventory(player, 54, "Backpack");
							player.openInventory(inv);
						}
					} else {
						noPermissionsMessage(player);
					}
				} else {
					incorrectUsage(player, "/backpack");
				}
			} else {
				consoleError();
			}
		}
		return false;
	}
}
