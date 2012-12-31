package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearenderchest extends kCommand implements CommandExecutor {
    public CommandClearenderchest(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clearenderchest")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.clearenderchest.self")) {
                        player.getEnderChest().clear();
                        player.sendMessage(GREEN + "Your enderchest has been cleared.");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else if (args.length == 1) {
                    if (player.hasPermission("kessentials.clearenderchest.others")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (tplayer != null) {
                            tplayer.getEnderChest().clear();
                            tplayer.sendMessage(DARK_GRAY + "Your enderchest has been cleared.");
                        } else {
                            player.sendMessage(RED + "The player " + YELLOW + args[0] + RED + " isn't online.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                }
            } else {
                if (args.length == 1) {
                    Player player = Bukkit.getServer().getPlayer(args[0]);
                    if (player != null) {
                        player.getEnderChest().clear();
                        player.sendMessage(DARK_GRAY + "Your enderchest has been cleared.");
                    } else {
                        Logger.getLogger("Minecraft").log(Level.INFO, "The player {0} isn''t online.", args[0]);
                    }
                } else {
                    incorrectUsageC("/clearenderchest <player>");
                }
            }
        }
        return false;
    }
}