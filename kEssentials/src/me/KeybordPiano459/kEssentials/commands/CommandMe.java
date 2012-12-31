package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMe extends kCommand implements CommandExecutor {
    public CommandMe(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("me")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    incorrectUsage(player, "/me <message>");
                } else {
                    if (player.hasPermission("kessentials.me")) {
                        StringBuilder str = new StringBuilder(args[0]);
                        for (int i=1; i<args.length; i++) {
                            str.append(" ").append(args[i]);
                        }
                        Bukkit.getServer().broadcastMessage("*" + player.getDisplayName() + " " + str.toString());
                    } else {
                        noPermissionsMessage(player);
                    }
                }
            } else {
                if (args.length == 0) {
                    incorrectUsageC("/me <message>");
                } else {
                    StringBuilder str = new StringBuilder(args[0]);
                    for (int i=1; i<args.length; i++) {
                        str.append(" ").append(args[i]);
                    }
                    Bukkit.getServer().broadcastMessage("*CONSOLE " + str.toString());
                }
            }
        }
        return false;
    }
}