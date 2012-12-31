package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CommandHat extends kCommand implements CommandExecutor {
    public CommandHat(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.hat")) {
                        ItemStack item = player.getItemInHand();
                        PlayerInventory inv = player.getInventory();
                        ItemStack helm = inv.getHelmet();
                        int amount = item.getAmount();
                        Material itemid = Material.getMaterial(item.getTypeId());
                        ItemStack hat = new ItemStack(itemid, 1);
                        
                        if (helm == null) {
                            if (hat.getType().isBlock()) {
                                if (!(hat.getTypeId() == 0)) {
                                    if (amount > 1) {
                                        item.setAmount(amount - 1);
                                    } else {
                                        inv.setItemInHand(null);
                                    }
                                    
                                    if (item.getDurability() != 0) {
                                        hat = new ItemStack(itemid, 1, item.getDurability());
                                    }
                                    
                                    inv.setHelmet(hat);
                                    player.sendMessage(GREEN + "You now have a cool new hat!");
                                } else {
                                    player.sendMessage(RED + "You need to be holding an item!");
                                }
                            } else {
                                player.sendMessage(RED + "You can't wear items, only blocks!");
                            }
                        } else {
                            player.sendMessage(RED + "Take off your current helmet before putting another one on!");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/hat");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}