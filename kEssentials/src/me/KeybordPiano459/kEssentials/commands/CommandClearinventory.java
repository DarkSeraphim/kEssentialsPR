package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearinventory extends kCommand implements CommandExecutor {
    public CommandClearinventory(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clearinventory")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.clearinventory.self")) {
                        player.getInventory().clear();
                        player.sendMessage(GREEN + "Your inventory has been cleared.");
                    } else {
                        noPermissionsMessage(player);
                    }
                } else if (args.length == 1) {
                    if (player.hasPermission("kessentials.clearinventory.others")) {
                        Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                        if (tplayer != null) {
                            tplayer.getInventory().clear();
                            tplayer.sendMessage(DARK_GRAY + "Your inventory has been cleared.");
                        } else {
                            player.sendMessage(RED + "The player " + YELLOW + args[0] + RED + " isn't online.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                }
            } else {
                if (args.length > 1 || args.length == 0) {
                    incorrectUsageC("/clearinventory <player>");
                } else {
                    Player player = Bukkit.getServer().getPlayer(args[0]);
                    if (player != null) {
                        player.getInventory().clear();
                        player.sendMessage(DARK_GRAY + "Your inventory has been cleared.");
                    } else {
                        Logger.getLogger("Minecraft").log(Level.INFO, "The player {0} isn''t online.", args[0]);
                    }
                }
            }
        }
        return false;
    }
}