package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import me.KeybordPiano459.kEssentials.config.PlayerConfig;
import me.KeybordPiano459.kEssentials.players.kPlayer;
import me.KeybordPiano459.kEssentials.util.helpers.Backpack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandBackpack extends kCommand implements CommandExecutor
{

    kEssentials plugin;

    public CommandBackpack(kEssentials plugin)
    {
        this.plugin = plugin;
    }
    private Backpack backpack;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("backpack"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (args.length == 0)
                {
                    if (player.hasPermission("kessentials.backpack"))
                    {
                        Inventory backInv = backpack.getBackpack(player);
                        if (backpack.hasBackpack(player))
                        {
                            ItemStack[] contents = backInv.getContents();
                            Inventory inv = Bukkit.createInventory(player, 54, "Backpack");
                            inv.setContents(contents);
                            player.openInventory(inv);
                        }
                        else
                        {
                            backpack.setBackpack(player, Bukkit.createInventory(player, 54, "Backpack"));
                            kPlayer kplayer = plugin.getPlayerManager().getPlayer(player.getName());
                            kplayer.getPlayerConfig().reloadPlayerConfig();
                            Inventory inv = Bukkit.createInventory(player, 54, "Backpack");
                            player.openInventory(inv);
                        }
                    }
                    else
                    {
                        noPermissionsMessage(player);
                    }
                }
                else
                {
                    incorrectUsage(player, "/backpack");
                }
            }
            else
            {
                consoleError();
            }
        }
        return false;
    }
}
