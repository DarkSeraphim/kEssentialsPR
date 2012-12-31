package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Back;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBack extends kCommand implements CommandExecutor {
    public CommandBack(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("back")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.hasPermission("kessentials.back")) {
                        if (Back.getBackLocation(player) != null) {
                            player.teleport(Back.getBackLocation(player));
                            player.sendMessage(GREEN + "You have teleported to yuor last location.");
                        } else {
                            player.sendMessage(RED + "There isn't a location to go back to.");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/back");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}