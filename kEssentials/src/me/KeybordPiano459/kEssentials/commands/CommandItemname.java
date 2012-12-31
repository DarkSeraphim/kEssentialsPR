package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandItemname extends kCommand implements CommandExecutor {
    public CommandItemname(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("itemname")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.itemname")) {
                        String name = args[0];
                        if (player.getItemInHand().getType() != Material.AIR) {
                            ItemStack item = player.getItemInHand();
                            player.getInventory().removeItem(item);
                            ItemMeta meta = item.getItemMeta();
                            meta.setDisplayName(name);
                            item.setItemMeta(meta);
                            player.getInventory().addItem(item);
                            player.sendMessage(GREEN + "Your item is now named " + name + ".");
                        } else {
                            player.sendMessage(RED + "You need to be holding an item in your hand.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/itemname <name>");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}