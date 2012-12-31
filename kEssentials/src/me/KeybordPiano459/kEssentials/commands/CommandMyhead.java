package me.KeybordPiano459.kEssentials.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

public class CommandMyhead extends kCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("myhead"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (args.length == 0)
                {
                    if (player.hasPermission("kessentials.myhead"))
                    {
                        ItemStack skull = new ItemStack(Material.SKULL_ITEM);
                        skull.setData(new MaterialData(3));
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwner(player.getName());
                        skull.setItemMeta(meta);
                        player.getInventory().addItem(skull);
                        player.sendMessage(GREEN + "Here is your head!");
                    }
                    else
                    {
                        noPermissionsMessage(player);
                    }
                }
                else
                {
                    incorrectUsage(player, "/myhead");
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
