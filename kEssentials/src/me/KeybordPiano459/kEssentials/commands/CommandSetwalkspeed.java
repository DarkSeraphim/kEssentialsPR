package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetwalkspeed extends kCommand implements CommandExecutor {
    public CommandSetwalkspeed(kEssentials plugin) {
        super(plugin);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setwalkspeed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (player.hasPermission("kessentials.setwalkspeed")) {
                        float walkSpeed = 0;
                        try {
                            walkSpeed = Float.valueOf(args[0]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(RED + "That isn't a valid walk speed!");
                            return false;
                        }
                        if (walkSpeed < -1F || walkSpeed > 1F) {
                            player.sendMessage(RED + "The walk speed must be between -1 and 1!");
                        } else {
                            player.setWalkSpeed(walkSpeed);
                            player.sendMessage(GREEN + "Your walk speed is now " + walkSpeed + ".");
                        }
                    } else {
                        noPermissionsMessage(player);
                    }
                } else {
                    incorrectUsage(player, "/walkspeed <speed>");
                }
            } else {
                consoleError();
            }
        }
        return false;
    }
}