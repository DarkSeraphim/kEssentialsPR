package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandOnline extends kCommand implements CommandExecutor {
    public CommandOnline(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("online")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.online")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (tplayer != null) {
                            player.sendMessage(GREEN + player.getName() + " is online!");
                        } else {
                            player.sendMessage(RED + args[0] + " is offline.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/online <player>");
                }
            } else {
                if (args.length == 1) {
                    Player player = Bukkit.getServer().getPlayer(args[0]);
                    if (player != null) {
                        Logger.getLogger("Minecraft").log(Level.INFO, "{0} is online!", player.getName());
                    } else {
                        Logger.getLogger("Minecraft").log(Level.INFO, "{0} is offline.", args[0]);
                    }
                } else {
                    incorrectUsageC("/online <player>");
                }
            }
        }
        return false;
    }
}